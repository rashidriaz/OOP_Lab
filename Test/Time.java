public class Time {
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
        this.second = (second - hoursInInSeconds) + (hour * 3600);
    }

    public void setMinute(int minute) {
        boolean validMinute = (minute > 0 && minute <= 59);
        if (!validMinute)
            throw new IllegalArgumentException("hour must be 0-23");
            int hoursInInSeconds = second / 3600;
            int minuteInSeconds = (second - hoursInInSeconds) / 60;
        this.second = second - minuteInSeconds + (minute * 60);
    }

    public void setSecond(int second) {
        boolean validSecond = (second > 0 && second <= 59);
        if (!validSecond)
            throw new IllegalArgumentException("hour must be 0-23");

            int hoursInInSeconds = this.second / 3600;
            int minuteInSeconds = (this.second - hoursInInSeconds) / 60;
            this.second = (this.second - (minuteInSeconds * 60) % 60) + second;
        }

    public int getHour() {
        int hour = this.second / 3600;
        return hour;
    }

    public int getMinute() {
        int minutes = (this.second % 3600)/ 60;
        return minutes;
    }

    public int getSecond() {
        int minuteInSeconds = (this.second % 3600)/ 60;
       int second = (minuteInSeconds * 60) % 60;
        return second;
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
    public boolean tick(){
        if ((this.second + 1) == 86400) {
            this.second = 0;
            return true;
        }
        this.second++;
        return false;
    }
    public boolean incrementMinute(){
        if ((this.second + 60) >= 86400) {
            this.second = this.second +60 - 86400;
            return true;
        }
        this.second += 60;
        return false;
    }
    public boolean incrementHour(){
        if((this.second + 3600) >= 86400){
            this.second = this.second + 3600 - 86400;
            return true;
        }
        this.second += 3600;
        return false;
    }
}