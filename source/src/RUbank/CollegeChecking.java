package RUbank;

import java.sql.SQLOutput;

/**
 *
 * @author
 */

public class CollegeChecking extends Checking {
    //Instance variable
    private Campus campus; //campus code

    //Constants
    final double collegeCheckingFee = 12.0;
    final double collegeCheckingInterestRate = 1.0/100;

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

    @Override
    public boolean equals(Object collegeCheckingAccount){
        CollegeChecking c = (CollegeChecking) collegeCheckingAccount;
        //System.out.println("CHECKING SHIZ IN HERE");
        return holder.getFname().equals(c.holder.getFname()) &&
                holder.getLname().equals(c.holder.getLname()) &&
                holder.getDob().equals(c.holder.getDob()) &&
                campus.equals(c.getCampus());
    }

    public static void main(String[] args) {
//        CollegeChecking cc = new CollegeChecking(Campus.NEW_BRUNSWICK);
//        System.out.println(cc.getCampus());
//        System.out.println(cc.monthlyFee());
//        System.out.println(cc.monthlyInterest());

    }
}
