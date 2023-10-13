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


    /**
     * createLocationFromInt() creates
     *
     * @param campus int representative of location
     * @return Location object based on integer provided
     */
    private Campus createLocationFromInt(int campus) {
        Campus place = null;
        switch (campus) {
            case 0:
                place = Campus.NEW_BRUNSWICK;
                break;
            case 1:
                place = Campus.NEWARK;
                break;
            case 2:
                place = Campus.CAMDEN;
                break;
        }
        return place;
    }

    /**
     * operationA() method
     */
    private void operationO(Account a, AccountDatabase2Test ad) {
        //Check if any elements of event is invalid and display error message
        Date date = a.holder.getDob();
        if(!date.isValid()){
            return;
        }
        if(a.getClass() == MoneyMarket.class && a.balance < 2000) {
            System.out.println("Minimum of $2000 to open a Money Market account.");
            return;
        }




        ad.open(a);

    }

    /**
     * operationR() method
     */
//    private void operationR(String date, String location, AccountDatabase2Test ac) {
//        //Create Date object
//        Date dateObj = createDateFromString(date);
//        //Check if any elements of event is invalid and display error message
//        if (!dateObj.isValid()) {
//            return;
//        }
//
//        //Create Timeslot object
//        Timeslot startTime = createTimeSlotFromString(timeSlot);
//
//        //Create Location object
//        Location room = createLocationFromString(location);
//
//        //Create Event object
//        Event e = new Event(dateObj, startTime, room);
//
//        //Check if Event object is in the event calendar to remove or not
//        if (ec.contains(e)) {
//            ec.remove(e);
//            System.out.println("Event has been removed from the calendar!");
//        } else {
//            System.out.println("Cannot remove; event is not in the calendar! ");
//        }
//    }
//
//    /**
//     * operationP() method
//     */
//    private void operationP(AccountDatabase2Test ad) {
//        ad.printSorted();
//    }
//
//    /**
//     * operationPE() method
//     */
//    private void operationPI(AccountDatabase2Test ec) {
//        ec.printFeesAndInterests();
//    }
//
//    /**
//     * operationPC() method
//     */
//    private void operationUB(AccountDatabase2Test ec) {
//        ec.printUpdatedBalances();
//    }
//
//
//    /**
//     * run() method
//     */
//    public void run() {
//        System.out.println("Event Organizer running...\n");
//        Scanner scanObj = new Scanner(System.in);
//        boolean programRun = true;
//        EventCalendar eventCalendar = new EventCalendar();
//        while (programRun) {
//            String command = scanObj.nextLine();
//            if (command.equals("")) continue;
//            String[] inputList = command.replaceAll("(^\\s+|\\s+$)", "").split("\\s+");//split the whole line into elements of String array
//            String firstCMD = inputList[0];
//            if (!isValidCommand(firstCMD)) {
//                System.out.println(firstCMD + " is an invalid command!");
//            } else {
//                switch (firstCMD) {
//                    case "Q":
//                        programRun = false;
//                        System.out.println("Event Organizer terminated.");
//                        break;
//                    case "A":
//                        //inputList[i] (i=1 Date, i=2 TimeSlot, i=3 Location, i=4 Department, i=5 email, i=6 duration
//                        Event aEvent = createEventObj(inputList[1], inputList[2], inputList[3], inputList[4], inputList[5], inputList[6]);
//                        operationA(aEvent, eventCalendar);
//                        break;
//                    case "R":
//                        ////inputList[i] (i=1 Date, i=2 TimeSlot, i=3 Location)
//                        operationR(inputList[1], inputList[2], inputList[3], eventCalendar);
//                        break;
//                    case "P":
//                        operationP(eventCalendar);
//                        break;
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
//                }
//            }
//        }
//    }
}
