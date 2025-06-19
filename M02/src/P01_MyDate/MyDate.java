package P01_MyDate;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.TimeZone;

public class MyDate {
    private int year;
    private int month;
    private int day;

    MyDate() {
        GregorianCalendar cal = new GregorianCalendar();
        year = cal.get(GregorianCalendar.YEAR);
        month = cal.get(GregorianCalendar.MONTH) + 1;
        day = cal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    MyDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date(elapsedTime);
        cal.setTime(date);
        //cal.setTimeZone(TimeZone.getDefault());
        year = cal.get(GregorianCalendar.YEAR);
        month = cal.get(GregorianCalendar.MONTH) + 1;
        day = cal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    MyDate(int year, int month, int day) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(year, mapMonth(month), day);
        this.year = cal.get(GregorianCalendar.YEAR);
        this.month = cal.get(GregorianCalendar.MONTH) + 1;
        this.day = cal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month; // months are zero based
    }

    public int getDay() {
        return day;
    }

    public void setDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime * 1000);
        year = cal.get(GregorianCalendar.YEAR);
        month = cal.get(GregorianCalendar.MONTH);
        day = cal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    private static int mapMonth(int month) {
        return switch (month) {
            case 1 -> Calendar.JANUARY;
            case 2 -> Calendar.FEBRUARY;
            case 3 -> Calendar.MARCH;
            case 4 -> Calendar.APRIL;
            case 5 -> Calendar.MAY;
            case 6 -> Calendar.JUNE;
            case 7 -> Calendar.JULY;
            case 8 -> Calendar.AUGUST;
            case 9 -> Calendar.SEPTEMBER;
            case 10 -> Calendar.OCTOBER;
            case 11 -> Calendar.NOVEMBER;
            case 12 -> Calendar.DECEMBER;
            default -> -1; // not a valid month

        };
    }
}
