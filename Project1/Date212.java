public class Date212 {
    private int month;
    private int year;
    private int day;

    public Date212(String s) { // constructor For Date212 class

        if (s.length() == 8) {

            year = Integer.parseInt(s.substring(0, 4)); // substring to parse the string. first four numbers of the
                                                        // string is the year
            month = Integer.parseInt(s.substring(4, 6)); // extracting the next two numbers and parse them into integers
            day = Integer.parseInt(s.substring(6, 8)); // extract last two numbers and parse them as
        }

        if (!isValidDate())
            System.out.println(s + " is an Invalid Date"); // if the date212 isnt valid, we print to the screen

    }

    public boolean isValidDate() { // method to determine if each date is correct
        if (month > 12 || month < 1 || day > 31 || day < 1 || year < 1 || year > 9999)
            return false; // dates cannot be greater than 12, days cannot be higher than 31 etc
        else
            return true;
    }

    public String toString() { // toString method to convert the date212 into a string in the form of
                               // month/day/year
        return month + "/" + day + "/" + year;
    }

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

}