package RUbank;

/**
 *
 * @author
 */

public class Savings extends Account{
    //Instance variable
    protected boolean isLoyal; //loyal customer status

    //Constants
    final double savingsMonthlyFee = 25;
    final double savingsInterestRate = 0.04;

    public Savings(Profile holder, double balance, boolean isLoyal) {
        super(holder, balance);
        this.isLoyal = isLoyal;
    }

    public void updateStatus(){
        if(balance < 2000){
            isLoyal = false;
        }
        else{
            isLoyal = true;
        }
    }

    @Override
    public double monthlyInterest() {
        if(isLoyal){
            return balance*((savingsInterestRate+0.0025)/12);
        }
        else{
            return balance*((savingsInterestRate)/12);
        }

    }
    @Override
    public double monthlyFee() {
        if (balance >= 500) {
            return 0;
        } else {
            return savingsMonthlyFee;
        }
    }

    @Override
    public String toString(){
        if(isLoyal){
            return "Savings::"+holder.getFname()+" "+holder.getLname()+" "
                    +holder.getDob().toString()+"::Balance $"+balance+"::is loyal";
        }
        else{
            return "Savings::"+holder.getFname()+" "+holder.getLname()+" "
                    +holder.getDob().toString()+"::Balance $"+balance;
        }
    }

    @Override
    public boolean equals(Object savingAccount){
        Savings s = (Savings) savingAccount;
        //System.out.println("CHECKING SHIZ IN HERE");
        return super.equals(s) && (isLoyal == s.isLoyal);
    }

    @Override
    public int compareTo(Account o) {
        return 0;
    }
}
