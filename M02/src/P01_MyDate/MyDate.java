package P01_MyDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate {
    private int year;
    private int month;
    private int day;

    MyDate() {
        year = GregorianCalendar.YEAR;
        month = GregorianCalendar.MONTH;
        day = GregorianCalendar.DAY_OF_MONTH;
    }

    MyDate(long elapsedTime) {
        Calendar cal= new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
    }

    MyDate(int year, int month, int day) {
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(long elapsedTime) {
    }
}
