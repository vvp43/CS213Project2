package RUbank;

/**
 *
 * @author
 */

public class MoneyMarket extends Savings{
    //Instance variable
    private int withdrawal;

    //Constants
    final double marketSavingsInterestRate = 4.5/100;
    final double marketSavingsMonthlyFee= savingsMonthlyFee;

    public MoneyMarket(Profile holder, double balance, boolean isLoyal, int withdrawal) {
        super(holder, balance, isLoyal);
        this.withdrawal = withdrawal;
    }
}
