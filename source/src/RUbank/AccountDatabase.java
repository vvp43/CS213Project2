package RUbank;

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
    public boolean contains(Account account){
        return find(account) != -1;
    } //overload if necessary

    public boolean open(Account account){
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

    public boolean close(Account account){
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

    public boolean withdraw(Account account){

        return false;
    } //false if insufficient fund

    public void deposit(Account account){}

    public void printSorted(){} //sort by account type and profile

    public void printFeesAndInterests(){} //calculate interests/fees

    public void printUpdatedBalances(){} //apply the interests/fees
}
