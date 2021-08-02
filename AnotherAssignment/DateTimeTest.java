// Author: Rashid Riaz - FA19_BSE_081
import java.util.Scanner;
import java.time.LocalDateTime;

public class DateTimeTest {
    private static Scanner input = new Scanner(System.in);
    private static DateAndTime myDateAndTime = new DateAndTime();

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            menu();
            switch (input.nextInt()) {
                case 1:
                    resetDateAndTime();
                    break;
                case 2:
                    resetTime();
                    break;
                case 3:
                    resetDate();
                    break;
                case 4:
                    myDateAndTime.incrementHour();
                    break;
                case 5:
                    myDateAndTime.incrementMinute();
                    break;
                case 6:
                    myDateAndTime.tick();
                    break;
                case 7:
                    addHorizontalLineOfEqual();
                    System.out.println(myDateAndTime);
                    addHorizontalLineOfEqual();
                    break;
                case 8:
                    addHorizontalLineOfEqual();
                    System.out.println(myDateAndTime.getDate());
                    addHorizontalLineOfEqual();
                    break;
                case 9:
                    addHorizontalLineOfEqual();
                    System.out.println(myDateAndTime.universalTime());
                    addHorizontalLineOfEqual();
                    break;
                case 10:
                    addHorizontalLineOfEqual();
                    System.out.println(myDateAndTime.standardTime());
                    addHorizontalLineOfEqual();
                    break;
                case 11:
                    myDateAndTime.nextDay();
                    break;
                case 12:
                    quit = true;
                    break;
                default:
                    addHorizontalLineOfEqual();
                    System.out.println("Invalid Choice");
                    addHorizontalLineOfEqual();
                    break;
            }
        }
    }

    private static void menu() {
        addTwoLineBreaks();
        addHorizontalLineOfEqual();
        System.out.println("01. Reset Date and Time");
        System.out.println("02. Reset Time");
        System.out.println("03. Reset Date");
        System.out.println("04. Increment Hour");
        System.out.println("05. Increment Minute");
        System.out.println("06. Increment Second");
        System.out.println("07. Display Date and Time");
        System.out.println("08. Display Date only");
        System.out.println("09. Display Universal Time Only");
        System.out.println("10. Display StandardTime Only");
        System.out.println("11. Next Day");
        System.out.println("12. Quit");
        addHorizontalLineOfEqual();
    }

    public static void resetDateAndTime() {
        resetDate();
        resetTime();
    }

    public static void resetDate() {
        addTwoLineBreaks();
        addHorizontalLineOfEqual();
        System.out.print("\nEnter Day:");
        int day = input.nextInt();
        System.out.print("\nEnter month:");
        int month = input.nextInt();
        System.out.print("\nEnter year:");
        int year = input.nextInt();
        try {
            myDateAndTime.setDate(month, day, year);
        } catch (IllegalArgumentException e) {
            addHorizontalLineOfEqual();
            System.out.println(e);
            addHorizontalLineOfEqual();
            resetDate();
        }
        addHorizontalLineOfEqual();
    }

    public static void resetTime() {
        addTwoLineBreaks();
        addHorizontalLineOfEqual();
        System.out.println("1. Reset Hour Only");
        System.out.println("2. Reset Minutes Only");
        System.out.println("3. Reset Seconds Only");
        System.out.println("4. Reset Hour Minutes and Seconds");
        addHorizontalLineOfEqual();
        switch (input.nextInt()) {
            case 1:
                addHorizontalLineOfEqual();
                System.out.print("\nEnter hour:");
                int hour = input.nextInt();
                addHorizontalLineOfEqual();
                try {
                    myDateAndTime.setHour(hour);
                } catch (IllegalArgumentException e) {
                    addHorizontalLineOfEqual();
                    System.out.println(e);
                    addHorizontalLineOfEqual();
                    resetTime();
                }
                break;
            case 2:
                addHorizontalLineOfEqual();
                System.out.print("\nEnter minute:");
                int minute = input.nextInt();
                addHorizontalLineOfEqual();
                try {
                    myDateAndTime.setMinute(minute);
                } catch (IllegalArgumentException e) {
                    addHorizontalLineOfEqual();
                    System.out.println(e);
                    addHorizontalLineOfEqual();
                    resetTime();
                }
                break;
            case 3:
                addHorizontalLineOfEqual();
                System.out.print("\nEnter Second:");
                int second = input.nextInt();
                addHorizontalLineOfEqual();
                try {
                    myDateAndTime.setSecond(second);
                } catch (IllegalArgumentException e) {
                    addHorizontalLineOfEqual();
                    System.out.println(e);
                    addHorizontalLineOfEqual();
                    resetTime();
                }
                break;
            case 4:
                addHorizontalLineOfEqual();
                System.out.print("\nEnter hour:");
                hour = input.nextInt();
                System.out.print("\nEnter Minutes:");
                minute = input.nextInt();
                System.out.print("\nEnter second:");
                second = input.nextInt();
                try {
                    myDateAndTime.setTime(hour, minute, second);
                } catch (IllegalArgumentException e) {
                    addHorizontalLineOfEqual();
                    System.out.println(e);
                    addHorizontalLineOfEqual();
                    resetTime();
                }
                addHorizontalLineOfEqual();
                break;
            default:
                System.out.println("\nWrong Option Selected.");
                resetTime();
                break;
        }
    }

    private static void addTwoLineBreaks() {
        System.out.println("\n\n");
    }

    private static void addHorizontalLineOfEqual() {
        System.out.println(
                "\n================================================================================================\n");
    }
}

class DateAndTime {
    private Date myDate;
    private Time myTime;

    public DateAndTime() {
        myDate = new Date();
        myTime = new Time();
    }

    public DateAndTime(int month, int day, int year, int hour, int minute, int second) {
        myDate = new Date(month, day, year);
        myTime = new Time(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        myTime.setTime(hour, minute, second);
    }

    public void setHour(int hour) {
        myTime.setHour(hour);
    }

    public void setMinute(int minute) {
        myTime.setMinute(minute);
    }

    public void setSecond(int second) {
        myTime.setSecond(second);
    }

    public void setDate(int month, int day, int year) {
        myDate.setDate(month, day, year);
    }

    public void setDateAndTime(int month, int day, int year, int hour, int minute, int second) {
        setDate(month, day, year);
        setTime(hour, minute, second);
    }

    public String universalTime() {
        return myTime.toUniversalString();
    }

    public String standardTime() {
        return myTime.toString();
    }

    public String getDate() {
        return myDate.toString();
    }

    public String toString() {
        return String.format("%s\t%s", getDate(), standardTime());
    }

    public void tick() {
        boolean endOfDay = myTime.tick();
        if (endOfDay) {
            if (!nextDay()) {
                myTime.setTime(23, 59, 59);
            }
        }
    }

    public void incrementHour() {
        boolean endOfDay = myTime.incrementHour();
        if (endOfDay) {
            if (!nextDay()) {
                int second = myTime.getSecond();
                int minute = myTime.getMinute();
                myTime.setTime(23, minute, second);
            }
        }
    }

    public void incrementMinute() {
        boolean endOfDay = myTime.incrementMinute();
        if (endOfDay) {
            if (!nextDay()) {
                int second = myTime.getSecond();
                myTime.setTime(23, 59, second);
            }
        }
    }

    public boolean nextDay() {
        return myDate.nextDay();
    }

}

class Date {
    private int month;
    private int day;
    private int year;
    LocalDateTime currentDate = LocalDateTime.now();

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
        } else {
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
    public boolean nextDay() {
        boolean validValueOfMonth = (this.month + 1) <= 12;
        boolean february29th = (this.month == 2 && (this.day + 1) == 29);
        boolean notLeapYear = (february29th && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)));
        boolean validDate = ((this.day + 1) <= daysPerMonth[this.month] || (february29th && !notLeapYear));
        int duplicateDay = this.day;
        int duplicateMonth = this.month;
        int duplicateYear = this.year;
        if (validDate) {
            duplicateDay++;
        } else {
            duplicateDay = 1;
            if (validValueOfMonth) {
                duplicateMonth++;
            } else {
                duplicateMonth = 1;
                duplicateYear++;
            }
        }
        if (dateIsGreaterThanCurrentDate(duplicateDay, duplicateMonth, duplicateYear)) {
            System.out.println("\n\n Error:\n");
            System.out.println(duplicateDay + "/" + duplicateMonth + "/" + duplicateYear + " is greater than "
                    + currentDate.toLocalDate());
            return false;
        } else {
            this.day = duplicateDay;
            this.month = duplicateMonth;
            this.year = duplicateYear;
            return true;
        }
    }

    // ------------------------------ Extras---------------------------------//
    private void checkForException(int day, int month, int year) {
        boolean monthValueOutOfRange = (month <= 0 || month > 12);
        boolean february29th = (month == 2 && day == 29);
        boolean notLeapYear = (february29th && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)));
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
        } else if (dateIsGreaterThanCurrentDate(day, month, year)) {
            throw new IllegalArgumentException("Provided Date is greater than " + currentDate);
        }
    }

    private boolean dateIsGreaterThanCurrentDate(int day, int month, int year) {
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

class Time {
    private int second;

    public Time() {
        this(0, 0, 0);
    }

    public Time(int hour) {
        this(hour, 0, 0);
    }

    public Time(int hour, int minute) {
        this(hour, minute, 0);
    }

    public Time(Time time) {
        this(time.getHour(), time.getMinute(), time.getSecond());
    }

    public Time(int hour, int minute, int second) {

        boolean validHour = hour >= 0 && hour < 24;
        boolean validMinute = (minute >= 0 && minute < 60);
        boolean validSecond = (second >= 0 && second < 60);

        if (!validHour)
            throw new IllegalArgumentException("hour must be 0-23");

        if (!validMinute)
            throw new IllegalArgumentException("minute must be 0-59");

        if (!validSecond)
            throw new IllegalArgumentException("second must be 0-59");
        this.second = (hour * 60 * 60) + (minute * 60) + second;
    }

    public void setTime(int hour, int minute, int second) {

        boolean validHour = (hour > 0 && hour <= 24);
        boolean validMinute = (minute > 0 && minute <= 60);
        boolean validSecond = (second > 0 && second <= 60);

        if (!validHour)
            throw new IllegalArgumentException("hour must be 0-23");

        if (!validMinute)
            throw new IllegalArgumentException("minute must be 0-59");

        if (!validSecond)
            throw new IllegalArgumentException("second must be 0-59");

        this.second = (hour * 60 * 60) + (minute * 60) + second;
    }

    public void setHour(int hour) {
        boolean validHour = (hour > 0 && hour <= 24);
        if (!validHour)
            throw new IllegalArgumentException("hour must be 0-23");
        int hoursInInSeconds = second / 3600;
        this.second = (second - (hoursInInSeconds * 3600)) + (hour * 3600);
    }

    public void setMinute(int minute) {
        boolean validMinute = (minute > 0 && minute <= 59);
        if (!validMinute)
            throw new IllegalArgumentException("hour must be 0-23");
        int hoursInInSeconds = this.second / 3600;
        int minuteInSeconds = (this.second - (hoursInInSeconds * 3600)) / 60;
        this.second = this.second - minuteInSeconds + (minute * 60);
    }

    public void setSecond(int second) {
        boolean validSecond = (second > 0 && second <= 59);
        if (!validSecond)
            throw new IllegalArgumentException("hour must be 0-23");

        int secondsInInstanceVariable = ((this.second % 3600) % 60);
        this.second += second - secondsInInstanceVariable;
    }

    public int getHour() {
        int hour = this.second / 3600;
        return hour;
    }

    public int getMinute() {
        int minutes = (this.second % 3600) / 60;
        return minutes;
    }

    public int getSecond() {
        int minuteInSeconds = (this.second % 3600);
        return minuteInSeconds % 60;
    }

    public String toUniversalString() {
        String universalString = String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
        return universalString;
    }

    public String toString() {
        boolean twelfthHour = (getHour() == 0 || getHour() == 12);
        int hour = (twelfthHour ? 12 : getHour() % 12);
        String AM_OR_PM = (getHour() < 12 ? "AM" : "PM");
        String timeFormat = String.format("%d:%02d:%02d %s", hour, getMinute(), getSecond(), AM_OR_PM);
        return timeFormat;
    }

    // Additions According to Exercise 8.7
    public boolean tick() {
        if ((this.second + 1) == 86400) {
            this.second = 0;
            return true;
        }
        this.second++;
        return false;
    }

    public boolean incrementMinute() {
        if ((this.second + 60) >= 86400) {
            this.second = this.second + 60 - 86400;
            return true;
        }
        this.second += 60;
        return false;
    }

    public boolean incrementHour() {
        if ((this.second + 3600) >= 86400) {
            this.second = this.second + 3600 - 86400;
            return true;
        }
        this.second += 3600;
        return false;
    }
}