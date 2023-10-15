package RUbank;

/**
 *
 * @author
 */

public class Checking extends Account{
    //constants
    final double checkingMonthlyFee = 12.0;
    final double checkingInterestRate = 0.01;

    @Override
    public double monthlyInterest() {
        return balance*(checkingInterestRate/12);
    }

    @Override
    public double monthlyFee() {
        if (balance >= 1000) {
            return 0;
        } else {
            return checkingMonthlyFee;
        }
    }

    @Override
    public void applyMonthlyInterestsAndFees(){
        balance-=monthlyFee();
        balance+=monthlyInterest();
    }

    public Checking(Profile holder, double balance) {
        super(holder, balance);
    }


    @Override
    public int compareTo(Account o) {
        return 0;
    }
}