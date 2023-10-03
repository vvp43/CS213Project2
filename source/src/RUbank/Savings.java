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
