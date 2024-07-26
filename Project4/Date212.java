import java.util.Comparator;

public class Date212 implements Comparable<Date212> {
    /**
     * month value of the date212 object
     */
    private int month;
    /**
     * year value of the date212 object
     */
    private int year;

    /**
     * day value of the date212 object
     */
    private int day;

    /**
     * constructor For Date212 class
     */
    public Date212(String s) { // constructor For Date212 class

        if (s.length() == 8) {

            year = Integer.parseInt(s.substring(0, 4)); // substring to parse the string. first four numbers of the
                                                        // string is the year
            month = Integer.parseInt(s.substring(4, 6)); // extracting the next two numbers and parse them into integers
            day = Integer.parseInt(s.substring(6, 8)); // extract last two numbers and parse them as
        }

        if (month > 12 || month < 1 || day > 31 || day < 1 || year < 1 || year > 9999)
            throw new IllegalDate212Exception(s + "is an invalid Date");

        /*
         * if (!isValidDate())
         * System.out.println(s + " is an Invalid Date"); // if the date212 isnt valid,
         * we print to the screen
         */
    }

    /**
     * checks if the date contains proper numbers
     * <p>
     * we take our date212 object and check if it contains crrect numbers that
     * propelry represent a date
     * 
     * @param date.year takes date212 objectand checks if its valid
     * @return boolean, returns true if the date contains proper numbers
     */
    public boolean isValidDate() { // method to determine if each date is correct
        if (month > 12 || month < 1 || day > 31 || day < 1 || year < 1 || year > 9999)
            return false; // dates cannot be greater than 12, days cannot be higher than 31 etc
        else
            return true;
    }
      public int getYear(){
        return year;
      }
    /**
     * converts the Date212 object into a string
     * 
     * @param date.year
     * @return String
     */
    public String toString() { // toString method to convert the date212 into a string in the form of
                               // month/day/year
        return month + "/" + day + "/" + year;
    }

    /**
     * compares two date212 objects
     * <p>
     * compares the year/month/day of two date 212 objects and returns -1 if the
     * current value is greate than the index
     * 
     * @param date.year
     * @return int returns 1 if its, less,-1 if its greater, 0 if its equak
     */

    public int compareTo(Date212 date) { // compareTo method to compare two date212 objects
        if (this.year < date.year) {
            return -1; // if the month/date/year is greater than the value at the next index,we'll
                       // switch
        } else if (this.year > date.year) {
            return 1;
        } else {
            if (this.month < date.month) {
                return -1;
            } else if (this.month > date.month) {
                return 1;
            } else {
                if (this.day < date.day) {
                    return -1;
                } else if (this.day > date.day) {
                    return 1;
                } else {
                    return 0; // Dates are equal
                }
            }
        }

    }

    public static class Sort implements Comparator<Date212> {
        public int compare(Date212 a, Date212 date) {
            if (a.year < date.year) {
                return -1; // if the month/date/year is greater than the value at the next index,we'll
                           // switch
            } else if (a.year > date.year) {
                return 1;
            } else {
                if (a.month < date.month) {
                    return -1;
                } else if (a.month > date.month) {
                    return 1;
                } else {
                    if (a.day < date.day) {
                        return -1;
                    } else if (a.day > date.day) {
                        return 1;
                    } else {
                        return 0; // Dates are equal
                    }
                }
            }
        }
    }

}