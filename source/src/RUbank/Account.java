package RUbank;

/**
 *
 * @author
 */
public abstract class Account implements Comparable<Account>{
    protected Profile holder;
    protected double balance;

    public abstract double monthlyInterest();
    public abstract double monthlyFee();

    public Account(Profile holder, double balance){
        this.holder = holder;
        this.balance = balance;
    }
    public boolean equals(Object account){
        Account a = (Account) account;
        //System.out.println("CHECKING SHIT IN HERE");
        return holder.getFname().equalsIgnoreCase(a.holder.getFname()) &&
                holder.getLname().equalsIgnoreCase(a.holder.getLname()) &&
                holder.getDob().equals(a.holder.getDob());
    }
}
