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

    /**
     * Constructor with campus as parameter
     * @param campus name fo campus
     */
    public CollegeChecking(Campus campus){
        this.campus=campus;
    }

    /**
     * Campus getter method
     */
    public Campus getCampus () {
        return this.campus;
    }

    public static void main(String[] args) {
//        CollegeChecking cc = new CollegeChecking(Campus.NEW_BRUNSWICK);
//        System.out.println(cc.getCampus());
//        System.out.println(cc.monthlyFee());
//        System.out.println(cc.monthlyInterest());

    }
}
