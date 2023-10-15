package RUbank;
import java.text.DecimalFormat;

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

    public void applyMonthlyInterestsAndFees(){
        balance+=monthlyInterest();
        balance-=monthlyFee();
    }
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#0.00");
        return "Checking::"+holder.getFname()+" "+holder.getLname()+" "
                +holder.getDob().toString()+"::Balance $"+df.format(balance);
    }
    public boolean equals(Object account){
        Account a = (Account) account;
//        System.out.println("first cmp: "+holder.getFname()+" "+holder.getLname()+" Date: "+holder.getDob().toString());
//        System.out.println("second  cmp: "+a.holder.getFname()+" "+a.holder.getLname()+" Date: "+a.holder.getDob().toString());

        return holder.getFname().equalsIgnoreCase(a.holder.getFname()) &&
                holder.getLname().equalsIgnoreCase(a.holder.getLname()) &&
                holder.getDob().equals(a.holder.getDob());
    }

    @Override
    public int compareTo(Account a){ //i think i can make it compare everything in this lets se
        int temp = holder.getLname().compareToIgnoreCase(a.holder.getLname());
        if(temp != 0){
            return temp; // return if last name is alphabetically first
        }
        else{
            return holder.getFname().compareToIgnoreCase(a.holder.getFname());
        }
    }
}
