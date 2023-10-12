package RUbank;

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
    public int with(){
        int temp = withdrawal;
        withdrawal++;
        return temp;
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
    @Override
    public String toString(){
        if(isLoyal){
            return "Money Market::Savings::"+holder.getFname()+" "+holder.getLname()+" "
                    +holder.getDob().toString()+"::Balance $"+balance+"::is loyal::withdrawl "+withdrawal;
        }
        else{
            return "Money Market::Savings::"+holder.getFname()+" "+holder.getLname()+" "
                    +holder.getDob().toString()+"::Balance $"+balance+"::withdrawl "+withdrawal;
        }
    }
    @Override
    public boolean equals(Object mmAccount){
        MoneyMarket m = (MoneyMarket) mmAccount;
        //System.out.println("CHECKING SHIZ IN HERE");
        return super.equals(m) && (withdrawal == m.withdrawal);
    }

}
