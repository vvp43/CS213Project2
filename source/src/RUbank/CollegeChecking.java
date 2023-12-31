package RUbank;

import java.sql.SQLOutput;
import java.text.DecimalFormat;

/**
 *
 * @author
 */

public class CollegeChecking extends Checking {
    //Instance variable
    private Campus campus; //campus code

    //Constants
    final double collegeCheckingFee = 12.0;
    final double collegeCheckingInterestRate = 0.01;

    public CollegeChecking(Profile holder, double balance, Campus campus) {
        super(holder, balance);
        this.campus = campus;
    }

    /**
     * Campus getter method
     */
    public Campus getCampus () {
        return this.campus;
    }

    public void setCampus (Campus a) {
        campus = a;
    }
    @Override
    public double monthlyFee() {
        return 0;
    }

    public void applyMonthlyInterestsAndFees(){
        balance-=monthlyFee();
        balance+=monthlyInterest();
    }
    @Override
    public boolean equals(Object collegeCheckingAccount){
        CollegeChecking c = (CollegeChecking) collegeCheckingAccount;
        //System.out.println("CHECKING SHIZ IN HERE");
        return super.equals(c) && campus.equals(c.getCampus());
    }
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#0.00");
        return "College Checking::"+holder.getFname()+" "+holder.getLname()+" "
                +holder.getDob().toString()+"::Balance $"+df.format(balance)+"::"+campus;
    }

    public static void main(String[] args) {
        Date a = new Date (1776, 7, 7);
        Profile john = new Profile ("John", "johnson", a);
        CollegeChecking cc = new CollegeChecking(john, 5000, Campus.NEW_BRUNSWICK);
        System.out.println(cc.getCampus());
        System.out.println(cc.toString());
        System.out.println(cc.monthlyFee());
        System.out.println(cc.monthlyInterest());
        cc.applyMonthlyInterestsAndFees();

    }
}