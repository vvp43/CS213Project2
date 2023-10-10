package RUbank;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

/**
 *
 * @author
 */

public class AccountDatabase {
    private Account[] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array

    private int find(Account a) {
        for (int i = 0; i < numAcct; i++) {
            if (accounts[i] != null) {
                if (accounts[i].equals(a)) {
                    return i;
                }
            }
        }
        return -1;
    } //search for an account in the array
    private int find(CollegeChecking a) {
        for (int i = 0; i < numAcct; i++) {
            if (accounts[i] != null) {
                if (accounts[i] instanceof CollegeChecking){
                    CollegeChecking cmp = (CollegeChecking) accounts[i];
                    if(cmp.equals(a)){
                        return i;
                    }
                }
            }
        }
        return -1;
    } //search for an account in the array

    private int find(Savings a) {
        for (int i = 0; i < numAcct; i++) {
            if (accounts[i] != null) {
                if (accounts[i] instanceof Savings){
                    Savings cmp = (Savings) accounts[i];
                    if(cmp.equals(a)){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private int find(MoneyMarket a) {
        for (int i = 0; i < numAcct; i++) {
            if (accounts[i] != null) {
                if (accounts[i] instanceof MoneyMarket){
                    MoneyMarket cmp = (MoneyMarket) accounts[i];
                    if(cmp.equals(a)){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

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
    public boolean contains(CollegeChecking account) {
        return find(account) != -1;
    }
    public boolean contains(Savings account) {
        return find(account) != -1;
    }
    public boolean contains(MoneyMarket account) {
        return find(account) != -1;
    }
    public boolean open(Account account) {
        if (numAcct == 0) {
            grow();
            accounts[0] = account;
            return true;
        } else {
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
                } else {
                    accounts[temp] = account;
                }
                return true;
            } else {
                return false;
            }
        }
    } //add a new account

    public boolean open(CollegeChecking account) {
        if (numAcct == 0) {
            grow();
            accounts[0] = account;
            return true;
        } else {
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
                } else {
                    accounts[temp] = account;
                }
                return true;
            } else {
                return false;
            }
        }
    } //add a new account

    public boolean open(Savings account) {
        if (numAcct == 0) {
            grow();
            accounts[0] = account;
            return true;
        } else {
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
                } else {
                    accounts[temp] = account;
                }
                return true;
            } else {
                return false;
            }
        }
    } //add a new account
    public boolean open(MoneyMarket account) {
        if (numAcct == 0) {
            grow();
            accounts[0] = account;
            return true;
        } else {
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
                } else {
                    accounts[temp] = account;
                }
                return true;
            } else {
                return false;
            }
        }
    } //add a new account
    public boolean close(Account account) {
        if (!contains(account)) {
            return false;
        } else {
            int index = 0;
            for (Account i : accounts) {
                if (i != null) {
                    if (i.equals(account)) {
                        break;
                    }
                }
                index++;
            }
            if (index == numAcct - 1) {
                accounts[index] = null;
            } else {
                accounts[index] = null;
                for (int j = index; j < numAcct - 1; j++) {
                    if (accounts[j + 1] != null) {
                        accounts[j] = accounts[j + 1];
                    } else {
                        accounts[j] = null;
                    }
                }
                return true;
            }
        }
        return true;
    } //remove the given account

    public boolean withdraw(Account account) {
        if (isEmpty()){
            return false;
        } else
                if ((accounts[find(account)].balance >= account.balance)) {
                    accounts[find(account)].balance -= account.balance;
                    return true;
                }
        return false;
    } //false if insufficient fund

    public boolean withdraw(CollegeChecking account) {
        if (isEmpty()){
            return false;
        } else
        if ((accounts[find(account)].balance >= account.balance)) {
            accounts[find(account)].balance -= account.balance;
            return true;
        }
        return false;
    } //false if insufficient fund

    public boolean withdraw(Savings account) {
        if (isEmpty()){
            return false;
        } else
        if ((accounts[find(account)].balance >= account.balance)) {
            accounts[find(account)].balance -= account.balance;
            return true;
        }
        return false;
    } //false if insufficient fund

    public boolean withdraw(MoneyMarket account) {
        if (isEmpty() || (find(account) == -1)){
            return false;
        } else
        if ((accounts[find(account)].balance >= account.balance)){
            MoneyMarket temp = (MoneyMarket) accounts[find(account)];
            if(temp.with() > 3){
                System.out.println("GOT IN!");
                temp.balance -= 10+account.balance;
            }
            else{
                temp.balance -= account.balance;
            }
            temp.updateStatus();
            return true;
        }
        return false;
    } //false if insufficient fund

    public void deposit(Account account) {
    }

    public void printSorted() {
    } //sort by account type and profile

    public void printFeesAndInterests() {
    } //calculate interests/fees

    public void printUpdatedBalances() {
    } //apply the interests/fees

    public void printtest(){
        for(Account i : accounts){
            if(i != null){
                System.out.println("Account : "+i.balance);
            }
        }
    }

    // test method
    public void addy(Account a, int index){
        accounts[index] = a;
    }

    public static void main(String[] args) {
        // test bed
        AccountDatabase test = new AccountDatabase();
        Date temp = new Date(1776, 7, 4);
        Profile a = new Profile("john", "smith", temp);

        Checking john = new Checking(a, 10000);
        Checking john2 = new Checking(a, 5000);
        test.open(john);
        //test.printtest();

//      System.out.println(john.holder);
//      System.out.println(john2.holder);
        //test.withdraw(john2);

        CollegeChecking johnny = new CollegeChecking(a, 14000, Campus.NEW_BRUNSWICK);
        CollegeChecking johnny2 = new CollegeChecking(a, 14000, Campus.NEW_BRUNSWICK);
        test.open(johnny);

        Savings johnie = new Savings(a, 20000, false);
        Savings johnie2 = new Savings(a, 5000, false);
        test.open(johnie);

        MoneyMarket johniey = new MoneyMarket(a, 20000, true, 0);
        MoneyMarket johniey2 = new MoneyMarket(a, 2000, true, 0);
        test.open(johniey);
        //test.addy(johnny, 1);
        //System.out.println("HOW ABOUT NOW SHOULD BE YES "+test.contains(johnny));
        test.printtest();

        // NOTE IN ORDER TO WITHDRAW, YOU MUST CREATE AN OBJECT WITH EVERY VALUE EQUAL EXCEPT BALANCE
        System.out.println(test.withdraw(john2));
        System.out.println(test.withdraw(johnny2));
        System.out.println(test.withdraw(johnie2));

        // for updating
        System.out.println(test.withdraw(johniey2));
        johniey2 = new MoneyMarket(a, 2000, true, 1);
        System.out.println("is johniey equal to johniey 2: "+johniey.equals(johniey2));
        System.out.println(test.withdraw(johniey2));

        johniey2 = new MoneyMarket(a, 2000, true, 2);
        System.out.println("is johniey equal to johniey 2: "+johniey.equals(johniey2));
        System.out.println(test.withdraw(johniey2));

        johniey2 = new MoneyMarket(a, 2000, true, 3);
        System.out.println("is johniey equal to johniey 2: "+johniey.equals(johniey2));
        System.out.println(test.withdraw(johniey2));

        johniey2 = new MoneyMarket(a, 2000, true, 4);
        System.out.println("is johniey equal to johniey 2: "+johniey.equals(johniey2));
        System.out.println(test.withdraw(johniey2));



        //System.out.println("DOES JOHNNY 2 SAME NAME BAL DIF CAMPUS IN LIST? SHOULD BE NO"+test.contains(johnny2));
        test.printtest();

        //test.withdraw(johnny2);


    }
}
