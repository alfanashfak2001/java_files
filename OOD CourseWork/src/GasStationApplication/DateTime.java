package GasStationApplication;

public class DateTime {
    private String Date;
    private int hours;
    private int minutes;
    // date format "yyyy-mm-dd"
    public DateTime(String date,int hours,int minutes){
        this.Date=date;
        this.hours=hours;
        this.minutes=minutes;
    }
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date=date;
    }


    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

}
