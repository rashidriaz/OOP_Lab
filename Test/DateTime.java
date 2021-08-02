public class DateTime{
    private Date myDate;
    private Time myTime;
    
    public DateTime(){
        myDate = new Date();
        myTime = new Time();
    }
    public DateTime(int month, int day, int year, int hour, int minute, int second){
        myDate = new Date(month, day, year);
        myTime = new Time(hour, minute, second);
    }
    public void setTime(int hour, int minute, int second){
        myTime.setTime(hour, minute, second);
    }
    public void setHour(int hour){
        myTime.setHour(hour);
    }
    public void setMinute(int minute) {
        myTime.setMinute(minute);
    }
    public void setSecond(int second){
        myTime.setSecond(second);
    }
    public void setDate(int month, int day, int year){
        myDate.setDate(month, day, year);
    }
    public void setDateAndTime(int month, int day, int year, int hour, int minute, int second){
        setDate(month, day, year);
        setTime(hour, minute, second);
    }
    public String universalTime(){
        return myTime.toUniversalString();
    }
    public String standardTime(){
        return myTime.toString();
    }
    public String getDate(){
        return myDate.toString();
    }
    public String toString(){
        return String.format("%s\t%s", getDate(), standardTime());
    }
    public void tick(){
        boolean endOfDay = myTime.tick();
        if (endOfDay) {
            nextDay();
        }
    }
    public void incrementHour(){
        boolean endOfDay = myTime.incrementHour();
        if (endOfDay) {
            nextDay();
        }
    }
    public void incrementMinute(){
        boolean endOfDay = myTime.incrementMinute();
        if (endOfDay) {
            nextDay();
        }
    }
    public void nextDay() {
        myDate.nextDay();
    }

}