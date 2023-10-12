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

    }
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#0.00");
        return "Checking::"+holder.getFname()+" "+holder.getLname()+" "
                +holder.getDob().toString()+"::Balance $"+df.format(balance);
    }
    public boolean equals(Object account){
        Account a = (Account) account;
        //System.out.println("CHECKING SHIT IN HERE");
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
            int temp2 = holder.getFname().compareToIgnoreCase(a.holder.getFname());
            if(temp2 != 0){
                return temp2; // return if last name is alphabetically same but different first name
            }
            else{
                return holder.getDob().compareTo(a.holder.getDob()); // return if everythihg before is equal but diff DOB
            }
        }
    }
}
