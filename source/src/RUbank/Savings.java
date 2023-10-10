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
    final double savingsInterestRate = 4.0/100;

    public Savings(Profile holder, double balance, boolean isLoyal) {
        super(holder, balance);
        this.isLoyal = isLoyal;
    }

    @Override
    public boolean equals(Object savingAccount){
        Savings s = (Savings) savingAccount;
        //System.out.println("CHECKING SHIZ IN HERE");
        return super.equals(s) && (isLoyal == s.isLoyal);
    }
    @Override
    public double monthlyInterest() {
        return savingsInterestRate;
    }

    @Override
    public double monthlyFee() {
        return savingsMonthlyFee;
    }

    @Override
    public int compareTo(Account o) {
        return 0;
    }
}
