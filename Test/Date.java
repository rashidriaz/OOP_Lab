import java.time.LocalDateTime;

public class Date {
    private int month;
    private int day;
    private int year;

    private static final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Date() {
        LocalDateTime currentDate = LocalDateTime.now();
        System.out.println("When any Invalid Value is given, the date sets to current date by Default!");
        this.day = currentDate.getDayOfMonth();
        this.month = currentDate.getMonthValue();
        this.year = currentDate.getYear();
    }

    public Date(int month, int day, int year) {
        checkForException(day, month, year);
        if (year < 100) {
            
            addPreFixToYear(year);
        }else{
            this.year = year;
        }
        this.month = month;
        this.day = day;

        System.out.printf("Date object constructor for date %s%n", this);
    }

    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
    public void setDate(int month, int day, int year) {
        checkForException(day, month, year);
        if (year < 100) {

            addPreFixToYear(year);
        } else {
            this.year = year;
        }
        this.month = month;
        this.day = day;
    }

    // -------------Additions According to Exercise 8.8-----------------------//
    public void nextDay() {
        boolean validValueOfMonth = (this.month + 1) <= 12;
        boolean february29th = (this.month == 2 && (this.day + 1) == 29);
        boolean validDate = ((this.day + 1) <= daysPerMonth[this.month] || february29th);
        if (validDate) {
            this.day++;
        } else {
            day = 1;
            if (validValueOfMonth) {
                this.month++;
            } else {
                this.month = 1;
                this.year++;
            }
        }
    }

    // ------------------------------ Extras---------------------------------//
    private void checkForException(int day, int month, int year){
        LocalDateTime currentDate = LocalDateTime.now();
        boolean monthValueOutOfRange = (month <= 0 || month > 12);
        boolean february29th = (month == 2 && day == 29);
        boolean notLeapYear =  (february29th && !(year % 400 == 0 ||(year % 4 == 0 && year % 100 != 0)));
        boolean validYear = year <= currentDate.getYear() && year >= 0;
        boolean dateOutOfRange;
        try {
            dateOutOfRange = day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");
        }
        if (monthValueOutOfRange) {
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");
        } else if (dateOutOfRange || notLeapYear) {
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
        } else if (!validYear) {
            throw new IllegalArgumentException("Year (" + year + ") out-of-range");
        } else if (dateIsGreaterThanCurrentDate(day, month, year, currentDate)) {
            throw new IllegalArgumentException("Provided Date is greater than " + currentDate);
        }
    }
    private boolean dateIsGreaterThanCurrentDate(int day, int month, int year, LocalDateTime currentDate) {
        if (year == currentDate.getYear()) {
            if (month == currentDate.getMonthValue()) {
                if (day > currentDate.getDayOfMonth()) {
                    return true;
                }
            } else if (month > currentDate.getMonthValue()) {
                return true;
            }
        } else if (year > currentDate.getYear()) {
            return true;
        }
        return false;
    }

    private void addPreFixToYear(int year) {
        LocalDateTime currentDate = LocalDateTime.now();
        if (year < 100 && (year + 2000) > currentDate.getYear()) {
            this.year = 1900 + year;
        } else if (year <= (currentDate.getYear() - 2000)) {
            this.year = 2000 + year;
        }
    }
}