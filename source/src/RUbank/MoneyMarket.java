package RUbank;

import java.text.DecimalFormat;

/**
 *
 * @author
 */

public class MoneyMarket extends Savings{
    //Instance variable
    private int withdrawal;

    //Constants
    final double marketSavingsInterestRate = 0.045;
    final double marketSavingsMonthlyFee= savingsMonthlyFee;

    public MoneyMarket(Profile holder, double balance, boolean isLoyal, int withdrawal) {
        super(holder, balance, isLoyal);
        this.isLoyal = true;
        this.withdrawal = withdrawal;
    }

    public void setWithdrawal(int input) {
        withdrawal = input;
    }
    public int getWithdrawal() {
        return withdrawal;
    }

    @Override
    public double monthlyInterest() {
        if(isLoyal){
            return balance*((marketSavingsInterestRate+0.0025)/12);
        }
        else{
            return balance*((marketSavingsInterestRate)/12);
        }

    }
    @Override
    public double monthlyFee() {
        if (balance >= 2000) {
            return 0;
        } else {
            return marketSavingsMonthlyFee;
        }
    }
    public void applyMonthlyInterestsAndFees(){
        balance-=monthlyFee();
        balance+=monthlyInterest();
        withdrawal = 0;
    }
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#0.00");
        if(isLoyal){
            return "Money Market::Savings::"+holder.getFname()+" "+holder.getLname()+" "
                    +holder.getDob().toString()+"::Balance $"+df.format(balance)+"::is loyal::withdrawl "+withdrawal;
        }
        else{
            return "Money Market::Savings::"+holder.getFname()+" "+holder.getLname()+" "
                    +holder.getDob().toString()+"::Balance $"+df.format(balance)+"::withdrawl "+withdrawal;
        }
    }
    @Override
    public boolean equals(Object mmAccount){
        MoneyMarket m = (MoneyMarket) mmAccount;
        //System.out.println("CHECKING SHIZ IN HERE");
        return super.equals(m);
    }

}