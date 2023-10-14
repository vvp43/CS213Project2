package RUbank;
import java.util.Scanner;

/**
 *This is the user interface class that processes the transactions entered on the
 * terminal and performs all Input/Ouput. This class handles all Java exceptions and invalid data
 * @author
 */

public class TransactionManager {
    /**
     * isValidCommand() method checks if user's input is valid
     *
     * @param command user's input
     * @return true if command is valid and false if command is invalid
     */
    public boolean isValidCommand(String command) {
        return command.equals("O") || command.equals("C") || command.equals("D")
                || command.equals("W") || command.equals("P") || command.equals("PI")
                || command.equals("UB") || command.equals("Q");
    }

    /**
     * createDateFromString() method
     *
     * @param date String of date contains month, day, year
     * @return Date object
     */
    private Date createDateFromString(String date) {
        //Split date string into array contains month, day, year
        String[] dateArr = date.split("/");
        int month = Integer.parseInt(dateArr[0]);
        int day = Integer.parseInt(dateArr[1]);
        int year = Integer.parseInt(dateArr[2]);


        //Create Date object and return
        return new Date(year, month, day);
    }

    private boolean createLoyaltyFromString(String loyalty) {
        boolean temp = false;
        switch(loyalty){
            case "0":
                temp = false;
                break;
            case "1":
                temp = true;
                break;
        }
        return temp;
    }


    /**
     * createLocationFromInt() creates
     *
     * @param campus int representative of location
     * @return Location object based on integer provided
     */
    private Campus createCampusFromString(String campus) {
        Campus place = null;
        switch (campus) {
            case "0":
                place = Campus.NEW_BRUNSWICK;
                break;
            case "1":
                place = Campus.NEWARK;
                break;
            case "2":
                place = Campus.CAMDEN;
                break;
        }
        return place;
    }



    public String typeCheckCharacterReturn(Account a){
        if(a.getClass() == Checking.class){
            return "(C)";
        }
        else if(a.getClass() == CollegeChecking.class){
            return "(CC)";
        }
        else if(a.getClass() == Savings.class){
            return "(S)";
        }
        else{
            return "(MM)";
        }
    }

    public static boolean isValidDouble(String input) {
        if (input == null) {
            return false;
        }
        try {
            Double.parseDouble(input);
            // If parsing succeeds, it's a valid double
            return true;
        } catch (NumberFormatException e) {
            // Parsing failed, not a valid double
            return false;
        }
    }


    private Account createAccountFromStrings(String accountType, String fName, String lName, String date, double balance, String campus, String isLoyal, String withdraw) {
        //Create Date object
        Date dateObj = createDateFromString(date);
            Profile holder = new Profile(fName, lName, dateObj);
            if (accountType.equals("C")) {
                return new Checking(holder, balance);
            } else if (accountType.equals("CC")) {
                Campus camp = createCampusFromString(campus);
                return new CollegeChecking(holder, balance, camp);
            } else if (accountType.equals("S")) {
                boolean loyalty = createLoyaltyFromString(isLoyal);
                return new Savings(holder, balance, loyalty);
            } else {
                return new MoneyMarket(holder, balance, true, 0);
            }
        //Create Profile object
    }






    /**
     * operationA() method: Helper method used to call the .open() method in AccountDatabase,
     * used to check for any errors in input before opening an account
     *
     * @param a Account to be opened
     * @param ad , short for Account Database
     */
    private void operationO(Account a, AccountDatabase ad) {
        //Check if any elements of event is invalid and display error message

        if(a.getClass() == MoneyMarket.class && a.balance < 2000) {
            System.out.println("Minimum of $2000 to open a Money Market account.");
            return;
        }
        
        if(!a.holder.getDob().isValid()){
            return;
        }

        if(!ad.open(a)){
            System.out.println(a.holder.getFname()+" "+a.holder.getLname()+
                    " "+a.holder.getDob().toString() +typeCheckCharacterReturn(a) +" is already in the database");
        }
        else{
            System.out.println(a.holder.getFname()+" "+a.holder.getLname()+
                    " "+a.holder.getDob().toString() +typeCheckCharacterReturn(a) +" opened");
            ad.open(a);
        }
    }

    /**
     * operationR() method: Helper method used to call the .close() method in AccountDatabase,
     * used to check for any errors in input before opening an account
     *
     * @param a Account to be opened
     * @param ad , short for Account Database
     */
    private void operationC(Account a, AccountDatabase ad) {
        //Create Date object
        //Check if any elements of event is invalid and display error message
        if (!a.holder.getDob().isValid()) {
            return;
        }
        if(!ad.close(a)){
            System.out.println(a.holder.getFname()+" "+a.holder.getLname()+
                    " "+a.holder.getDob().toString() +typeCheckCharacterReturn(a) +" is not in the" +
                    "database");
        }
        ad.close(a);
    }

    /**
     * operationP() method: Helper method used to call printSorted which prints all accounts sorted
     * by Account Type and Profile
     *
     * @param ad ,short for Account Database
     */
    private void operationP(AccountDatabase ad) {
        ad.printSorted();
    }

    /**
     * operationPE() method: Helper method used to call printFeesAndInterests which prints
     * all accounts with their respective monthly interest and fees;
     *
     * @param ad ,short for Account Database
     */
    private void operationPI(AccountDatabase ad) {
        ad.printFeesAndInterests();
    }

    /**
     * operationPC() method: Helper method used to call printUpdatedBalances which updates and
     * applies all monthly fees and interest to accounts in database, then prints them sorted
     * by type of account and profile.
     *
     * @param ad ,short for Account Database
     */
    private void operationUB(AccountDatabase ad) {
        ad.printUpdatedBalances();
    }


    /**
     * run() method
     */
    public void run() {
        System.out.println("Event Organizer running...\n");
        Scanner scanObj = new Scanner(System.in);
        boolean programRun = true;
        AccountDatabase accountDatabase = new AccountDatabase();
        while (programRun) {
            String command = scanObj.nextLine();
            if (command.equals("")) continue;
            String[] inputList = command.replaceAll("(^\\s+|\\s+$)", "").split("\\s+");//split the whole line into elements of String array
            String firstCMD = inputList[0];
            if (!isValidCommand(firstCMD)) {
                System.out.println(firstCMD + " is an invalid command!");
            } else {
                switch (firstCMD) {
                    case "Q":
                        programRun = false;
                        System.out.println("Event Organizer terminated.");
                        break;
                    case "O":
                        switch (inputList[1]) {
                            case "CC" -> {
                                if(inputList.length == 7 && isValidDouble(inputList[5])) {
                                    double bal = Double.parseDouble(inputList[5]);
                                    if(bal > 0){
                                        Account add = createAccountFromStrings(inputList[1], inputList[2], inputList[3],
                                                inputList[4], bal, inputList[6], "", "");
                                        operationO(add, accountDatabase);
                                    }
                                    else{
                                        System.out.println("Initial deposit cannot be 0 or negative.");
                                    }
                                }
                                else{
                                    System.out.println("Missing data for opening an account.");
                                }
                            }
                            case "S" -> {
                                double bal = Double.parseDouble(inputList[5]);
                                if(inputList.length == 7 && isValidDouble(inputList[5])) {
                                    if(bal > 0) {
                                        Account add = createAccountFromStrings(inputList[1], inputList[2], inputList[3],
                                                inputList[4], bal, "", inputList[6], "");
                                        operationO(add, accountDatabase);
                                    }
                                    else{
                                        System.out.println("Initial deposit cannot be 0 or negative.");
                                    }
                                }
                                else {
                                    System.out.println("Missing data for opening an account.");
                                }

                            }
                            default ->{
                                if(inputList.length == 6  && isValidDouble(inputList[5])) {
                                    double bal = Double.parseDouble(inputList[5]);
                                    if(bal > 0){
                                        Account add = createAccountFromStrings(inputList[1], inputList[2], inputList[3],
                                                inputList[4], bal, "", "", "");
                                        operationO(add, accountDatabase);
                                    }
                                    else{
                                        System.out.println("Initial deposit cannot be 0 or negative.");
                                    }
                                }
                                else{
                                    System.out.println("Missing data for opening an account.");
                                }
                            }
                        }
                        break;


//                    case "R":
//                        ////inputList[i] (i=1 Date, i=2 TimeSlot, i=3 Location)
//                        operationR(inputList[1], inputList[2], inputList[3], eventCalendar);
//                        break;
                    case "P":
                        operationP(accountDatabase);
                        break;
//                    case "PC":
//                        operationPC(eventCalendar);
//                        break;
//                    case "PD":
//                        operationPD(eventCalendar);
//                        break;
//                    case "PE":
//                        operationPE(eventCalendar);
//                        break;
//
                }
            }
        }
    }
}
