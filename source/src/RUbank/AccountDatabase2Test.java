package RUbank;

/**
 *
 * @author
 */

public class AccountDatabase2Test {
    private Account[] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array

    private int find(Account a) {
        for (int i = 0; i < numAcct; i++) {
            if (accounts[i] != null) {
                if(a.getClass() == accounts[i].getClass()){
                    if(accounts[i].equals(a)){
                        return i;
                    }
                }
            }
        }
        return -1;
    } //search for an account in the array

    private void grow() {
        int newNumofEvents = numAcct + 4;
        Account[] newAccounts = new Account[newNumofEvents];

        for (int i = 0; i < numAcct; i++) {
            newAccounts[i] = accounts[i];
        }
        accounts = newAccounts;
        numAcct = newNumofEvents;
    } //increase the capacity by 4

    private boolean isEmpty() {
        boolean check = true;

        if (accounts == null) {
            check = true;
        } else {
            for (Account i : accounts) {
                if (i != null) {
                    check = false;
                }
            }
        }
        return check;
    }

    public boolean contains(Account account) {
        return find(account) != -1;
    } //overload if necessary
    public boolean open(Account account) {
        if (numAcct == 0) {
            grow();
            accounts[0] = account;
            return true;
        }
        else {
            if (!contains(account)) {
                int temp = -1;
                for (int i = 0; i < numAcct; i++) {
                    if (accounts[i] == null) {
                        temp = i;
                        break;
                    }
                }
                if (temp == -1) {
                    grow();
                    int temp2 = -1;
                    for (int i = 0; i < numAcct; i++) {
                        if (accounts[i] == null) {
                            temp2 = i;
                            break;
                        }
                    }
                    accounts[temp2] = account;
                }
                else {
                    accounts[temp] = account;
                }
                return true;
            }
            else {
                return false;
            }
        }
    } //add a new account

    public boolean close(Account account) {
        if (!contains(account)) {
            return false;
        } else {
            int index = find(account);
            //System.out.println(index);
            if (index == numAcct - 1) {
                accounts[index] = null;
            } else {
                for(int i = index; i < numAcct-1; i++){
                    accounts[i] = accounts[i+1];
                }
                accounts[numAcct-1] = null;
                //printy();
            }
        }
        return true;
    } //remove the given account

    public boolean withdraw(Account account) {
        if (isEmpty() || find(account) == -1) {
            return false;
        } else
            if (account.getClass() == Checking.class ||
                    account.getClass() == CollegeChecking.class) { // withdraw from checking/college
                if ((accounts[find(account)].balance >= account.balance)) {
                    System.out.println("WITHDRAWING...");
                    accounts[find(account)].balance -= account.balance;
                    return true;
                }
            }
            else if(account.getClass() == Savings.class){ // withdraw from savings
                if ((accounts[find(account)].balance >= account.balance)) {
                    Savings temp = (Savings) accounts[find(account)];
                    System.out.println("WITHDRAWING...");
                    temp.balance -= account.balance;
                    temp.updateStatus();
                    return true;
                }
            }
            else{
                if ((accounts[find(account)].balance >= account.balance)){ // withdraw from MM
                    MoneyMarket temp = (MoneyMarket) accounts[find(account)];
                    if(temp.with() > 3){
                        System.out.println("WITHDRAWING...");
                        temp.balance -= 10+account.balance;
                    }
                    else{
                        System.out.println("WITHDRAWING...");
                        temp.balance -= account.balance;
                    }
                    temp.updateStatus();
                    return true;
                }
            }
        return false;
    } //false if insufficient fund

    public void deposit(Account account) { // handling invalid numbers of deposits should be in transmanager
        if (isEmpty()) {
            System.out.println("Account Database is empty!");
        } else
        if (account.getClass() == Checking.class ||
                account.getClass() == CollegeChecking.class) { // depositing from checking/college
            System.out.println("DEPOSITING...");
            accounts[find(account)].balance += account.balance;
        }
        else if(account.getClass() == Savings.class){ // depositing from savings
            Savings temp = (Savings) accounts[find(account)];
            System.out.println("DEPOSITING...");
            temp.balance += account.balance;
            temp.updateStatus();
        }
        else{
            //printtest();
            MoneyMarket temp = (MoneyMarket) accounts[find(account)]; // depositing from MM
            System.out.println("DEPOSITING...");
            temp.balance += account.balance;
            temp.updateStatus();
        }
    }

    public Account[] sort(Account[] sorted){
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < numAcct - 1; i++) {
                if (sorted[i + 1] != null) {
                    if (sorted[i].getClass().getSimpleName().compareToIgnoreCase(sorted[i + 1].getClass().getSimpleName()) > 0) {
                        Account temp = sorted[i];
                        sorted[i] = sorted[i + 1];
                        sorted[i + 1] = temp;
                        swap = true;
                    }
                }
            }
        } while (swap);
        do {
            swap = false;
            for (int i = 0; i < numAcct - 1; i++) {
                if (sorted[i + 1] != null) {
                    if (sorted[i].compareTo(sorted[i+1]) > 1) { //need to test compaoreTo
                        Account temp = sorted[i];
                        sorted[i] = sorted[i + 1];
                        sorted[i + 1] = temp;
                        swap = true;
                    }
                }
            }
        } while (swap);
        return sorted;
    }

    public void printSorted() {
        if(accounts[0] != null) {
            Account[] copy = new Account[numAcct];
            // copy array first
            for (int i = 0; i < numAcct; i++) {
                if (accounts[i] != null) {
                    copy[i] = accounts[i];
                }
            }
            sort(copy);
            for (Account a : copy) {
                if (a != null) {
                    System.out.println(a.toString());
                }
            }
        }
    } //sort by account type and profile

    public void printFeesAndInterests() {

    } //calculate interests/fees
//
//    public void printUpdatedBalances() {
//    } //apply the interests/fees

    public void printtest(){
        for(Account i : accounts){
            if(i != null){
                System.out.println(i);
                //System.out.println("Account : "+i+" BAL: "+i.balance);
            }
        }
    }
    public void printy(){
        for(int i = 0; i < numAcct; i++){
            System.out.println(accounts[i]);
        }
    }

    // test method
    public void addy(Account a, int index){
        accounts[index] = a;
    }

    public static void main(String[] args) {
        // test bed
        AccountDatabase2Test test = new AccountDatabase2Test();
        Date temp = new Date(1776, 7, 4);
        Date temp2 = new Date(2005, 7, 4);
        Profile a = new Profile("john", "smith", temp);
        Profile ab = new Profile("john", "ssmith", temp);
        Profile abc = new Profile("jo2hn", "Dsmith", temp);
        Profile abcd = new Profile("jo2hn", "Dsmith", temp2);

        Checking john = new Checking(a, 10000);
        Checking john2 = new Checking(a, 5000);

        CollegeChecking johnny = new CollegeChecking(a, 14000, Campus.NEW_BRUNSWICK);
        CollegeChecking johnny2 = new CollegeChecking(a, 14000, Campus.NEW_BRUNSWICK);
        CollegeChecking johnnyD = new CollegeChecking(abc, 10000, Campus.NEW_BRUNSWICK);
        CollegeChecking johnnyDe = new CollegeChecking(abcd, 10000, Campus.NEW_BRUNSWICK);

        MoneyMarket johniey = new MoneyMarket(a, 20000, true, 0);
        MoneyMarket johniey2 = new MoneyMarket(a, 2000, true, 0);

        Savings johnie = new Savings(a, 20000, true);
        Savings johnie2 = new Savings(a, 5000, true);

        test.open(john);
        test.open(johnny);
        test.open(johnie);
        test.open(johnnyDe);
        test.open(johniey);
        test.open(johnnyD);

        System.out.println("regular print");
        test.printtest();

        System.out.println("printed by name");
        test.printSorted();

        test.withdraw(john2);
        test.withdraw(johnny2);
        test.withdraw(johnie2);
        test.withdraw(johniey2);
        MoneyMarket johniey22 = new MoneyMarket(a, 2000, true, 1);
        test.withdraw(johniey22);
        MoneyMarket johniey222 = new MoneyMarket(a, 2000, true, 2);
        test.withdraw(johniey222);
        MoneyMarket johniey2222 = new MoneyMarket(a, 2000, true, 3);
        test.withdraw(johniey2222);
        MoneyMarket johniey22222 = new MoneyMarket(a, 2000, true, 4);
        test.withdraw(johniey22222);

        MoneyMarket johniey222222 = new MoneyMarket(a, 2000, true, 5);
        test.printtest();

        System.out.println("Depositing");
        test.deposit(john2); // checking
        test.deposit(johnny2); // college
        test.deposit(johnie2); // savings
        test.deposit(johniey222222); // money market

        test.printtest();

        System.out.println("ACCS AFTER CLOSING: ");
        test.close(john);
        test.close(johniey);
        test.close(johnny);
        test.close(johnie);

        System.out.println("");

        test.printtest();
        test.open(john); // check

        System.out.println("reopen test");
        test.printtest();

//        test.open(john);
//        test.open(john2);


//      System.out.println(john.holder);
//      System.out.println(john2.holder);


        //CollegeChecking asdasd = new CollegeChecking(ab, 16000, Campus.NEW_BRUNSWICK);
//        CollegeChecking johnny2 = new CollegeChecking(ab, 15000, Campus.NEW_BRUNSWICK);
//        CollegeChecking johnny3 = new CollegeChecking(abc, 19000, Campus.NEW_BRUNSWICK);

        //System.out.println(test.open(johnny));
        //System.out.println(test.open(johnny2));
//        test.open(johnny2);
//        test.open(johnny3);
        //test.open(asdasd);

//        Savings johnie = new Savings(a, 20000, false);
//        Savings johnie2 = new Savings(a, 5000, false);
//        test.open(johnie);


//        test.open(johniey);
        //test.addy(johnny, 1);
        //System.out.println("HOW ABOUT NOW SHOULD BE YES "+test.contains(johnny));
        //test.printtest();

        // NOTE IN ORDER TO WITHDRAW, YOU MUST CREATE AN OBJECT WITH EVERY VALUE EQUAL EXCEPT BALANCE
        //System.out.println(test.withdraw(john2));
//        System.out.println(test.withdraw(johnny2));
//        System.out.println(test.withdraw(johnie2));

        // for updating
//        System.out.println(test.withdraw(johniey2));
//        johniey2 = new MoneyMarket(a, 2000, true, 1);
//        System.out.println("is johniey equal to johniey 2: "+johniey.equals(johniey2));
//        System.out.println(test.withdraw(johniey2));
//
//        johniey2 = new MoneyMarket(a, 2000, true, 2);
//        System.out.println("is johniey equal to johniey 2: "+johniey.equals(johniey2));
//        System.out.println(test.withdraw(johniey2));
//
//        johniey2 = new MoneyMarket(a, 2000, true, 3);
//        System.out.println("is johniey equal to johniey 2: "+johniey.equals(johniey2));
//        System.out.println(test.withdraw(johniey2));
//
//        johniey2 = new MoneyMarket(a, 2000, true, 4);
//        System.out.println("is johniey equal to johniey 2: "+johniey.equals(johniey2));
//        System.out.println(test.withdraw(johniey2));



        //System.out.println("DOES JOHNNY 2 SAME NAME BAL DIF CAMPUS IN LIST? SHOULD BE NO"+test.contains(johnny2));
        //test.printtest();

        //test.withdraw(johnny2);


    }
}
