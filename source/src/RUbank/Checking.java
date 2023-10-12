package RUbank;

/**
 *
 * @author
 */

public class Checking extends Account{
    //constants
    final double checkingMonthlyFee = 12.0;
    final double checkingInterestRate = 1.0/100;

    double m = monthlyInterest();

    public Checking(Profile holder, double balance) {
        super(holder, balance);
    }



    @Override
    public double monthlyInterest() {

        return checkingInterestRate;
    }

    @Override
    public double monthlyFee() {
        return checkingMonthlyFee;
    }

    @Override
    public int compareTo(Account o) {
        return 0;
    }
}
