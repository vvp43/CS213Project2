package RUbank;

import java.util.Calendar;

/**
 * This Date class retrieves information
 * about date which contains year, month and day
 *
 * @author Seth Yeh, Vinh Pham
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    final Calendar curr = Calendar.getInstance(); // the current year date
    Calendar event = Calendar.getInstance(); // the event date

    /**
     * Constructor with param year, month and day
     *
     * @param year event year
     * @param month event month
     * @param day event day
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        event.set(year, month, day);
    }

    /**
     * getYear() method
     * @return year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * getMonth() method
     * @return month
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * getDay() method
     * @return day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * compareTo() method
     *
     *
     * @param input the object to be compared.
     * @return 1 if current date is after input date, 0 if current date is the same with output date, -1 if current date is before input date
     */
    @Override
    public String toString(){
        return month+"/"+day+"/"+year;
    }
    @Override
    public int compareTo(Date input) {
        int inputDateInt = input.year * 10000 + input.month * 100 + input.day;
        int currentDateInt = this.year * 10000 + this.month * 100 + this.day;
        int diff = currentDateInt - inputDateInt;

        if (diff > 0) {
            return 1;
        }

        if (diff == 0) {
            return 0;
        }

        return -1;
    }


    /**
     * isLeapYear method()
     * checks if year is a leap year
     *
     * @param year year to check
     * @return true if it is, false otherwise
     */
    private boolean isLeapYear(int year) {
        boolean is_Leap = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    is_Leap = true;
                }
            } else {
                is_Leap = true;
            }
        }
        return is_Leap;
    }

    /**
     * isValidDate() method : used to check if the day is valid in a month
     * vinh
     *
     * @param date date to check
     * @return boolean true or false
     */
    private boolean isValidDate(Date date) {
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        if (month > 0 && month < 13) {
            switch (month) {
                case 1, 3, 5, 7, 8, 10, 12:
                    return day <= 31 && day > 0;
                case 4, 6, 9, 11:
                    return day <= 30 && day > 0;
                case 2:
                    if (isLeapYear(year)) return day <= 29 && day > 0;
                    else return day <= 28 && day > 0;
                default:
                    return true;
            }
        }
        return false;
    }

    /**
     * isFutureDate method()
     * Checks if date is in the future or not
     *
     * @param inputDate date to compare
     * @return true if inputDate is in the future, false otherwise
     */
    private boolean isFutureDate(Date inputDate) {
        int currentYear = inputDate.curr.get(Calendar.YEAR);
        int currentMonth = inputDate.curr.get(Calendar.MONTH) + 1;
        int currentDay = inputDate.curr.get(Calendar.DAY_OF_MONTH);
        Date currentDate = new Date(currentYear, currentMonth, currentDay);
        if (inputDate.isValidDate(inputDate)) {
            return inputDate.compareTo(currentDate) > 0;
        }
        return false;
    }

    /**
     * isWithinSixMonths() method
     * Checks if date is within 6 months of the current date
     *
     * @param inputDate date to compare
     * @return true if inputDate is within 6 months of the current date, false otherwise
     */
    private boolean isWithinSixMonths(Date inputDate) {
        if (inputDate.isValidDate(inputDate)) {
            if (isFutureDate(inputDate)) {
                Calendar temp = Calendar.getInstance();
                temp.add(Calendar.MONTH, 7);
                return !inputDate.event.after(temp);
            }
        }

        return false;
    }


    /**
     * isValid() method
     * Checks if an event is valid meaning within 6 months, cannot be in the future, and is an actual date possible.
     *
     * @return true if all conditions above are met, otherwise false
     */
    public boolean isValid() {
        int y = this.year;
        int m = this.month;
        int d = this.day;
        Date thisEvent = new Date(y, m, d);
        //1st step: checks if event date is valid
        if (isValidDate(thisEvent)) {
            //2nd step: checks if event date is in the future
            if (isFutureDate(thisEvent)) {
                //3rd step: check if event date is within 6 months
                if (isWithinSixMonths(thisEvent)) {
                    //4th step: check if event date is duplicated
                    return true;
                } else {
                    System.out.println(m + "/" + d + "/" + y + ": Event date must be within 6 months!");
                    return false;
                }
            } else {
                System.out.println(m + "/" + d + "/" + y + ": Event date must be a future date!");
                return false;
            }
        }
        System.out.println(m + "/" + d + "/" + y + ": Invalid calendar date!");
        return false;
    }

    /**
     * Testbed main()
     *
     */
    public static void main(String[] args) {
        /**
         Demonstrate test case for isValid()
         isValid() is designed based on three conditions
         1. The date is valid ( )
         2. The date is in the future
         3. The date is within 6 months;
         */

        /**
         * Example Dates (Today's date: 9/30/2023)
         */

        /**
         * Test cases
         */
        Date a = new Date(2024, 2, 29);
        Date b = new Date(2023, 2, 29);
        Date c = new Date(2022, 2, 29);
        Date d = new Date(2025, 3, 31);


        //isValid() complete method
        System.out.println(a.isValid());
        System.out.println(b.isValid());
        System.out.println(c.isValid());
        System.out.println(d.isValid());
    }
}
