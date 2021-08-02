
public class math {
  private Date date;
    private Time time;

    public math() {
        this.time = new Time();
        this.date = new Date();
    }

    public math(Time time, Date date) {
        this.time = time;
        this.date = date;
    }

    public math(int month, int day, int year, int hour, int minute, int second) {
        try {
            date = new Date(month, day, year);
        } catch (IllegalArgumentException e) {
            addHorizontalLineOfEquals();
            System.out.println(e);
            addHorizontalLineOfEquals();
        }
        try {
            time = new Time(hour, minute, second);
        } catch (IllegalArgumentException e) {
            addHorizontalLineOfEquals();
            System.out.println(e);
            addHorizontalLineOfEquals();
        }
    }

    public void displayDateAndTime() {
        addTwoLineBreaks();
        addHorizontalLineOfEquals();
        System.out.printf("%s\t%s", date, time);
        addHorizontalLineOfEquals();
    }
    // -------------------For Class Time-------------------------------------//

    public void tick() {
        if (time.tick()) {
            date.nextDay();
        }
        displayDateAndTime();
    }

    public void incrementMinute() {
        if (time.incrementMinute()) {
            date.nextDay();
        }
        displayDateAndTime();
    }

    public void incrementHour() {
        if (time.incrementHour()) {
            date.nextDay();
        }
        displayDateAndTime();
    }

    // ----------------For Class Date-------------------------------------//
    public void nextDay() {
        date.nextDay();
        displayDateAndTime();
    }

    // ---------------------------------Extras------------------------------------//
    private void addTwoLineBreaks() {
        System.out.println("\n\n");
    }

    private void addHorizontalLineOfEquals() {
        System.out.println(
                "\n=========================================================================================================\n");
    }
}