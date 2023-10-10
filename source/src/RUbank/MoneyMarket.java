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
    public int with(){
        int temp = withdrawal;
        withdrawal++;
        return temp;
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
    public boolean equals(Object mmAccount){
        MoneyMarket m = (MoneyMarket) mmAccount;
        //System.out.println("CHECKING SHIZ IN HERE");
        return super.equals(m) && (withdrawal == m.withdrawal);
    }

}
