package P01_MyDate;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 * MyDate represents a specific date (YYYY/MM/DD).
 * @author Grant Simpson
 *
 */
public class MyDate {
    private int year;
    private int month;
    private int day;

    /**
     * The default constructor constructs today's date.
     */
    MyDate() {
        GregorianCalendar cal = new GregorianCalendar();
        year = cal.get(GregorianCalendar.YEAR);
        month = cal.get(GregorianCalendar.MONTH) + 1;
        day = cal.get(GregorianCalendar.DAY_OF_MONTH);
    }


    /**
     * Given a period of time in milliseconds, this constructor converts the time into a date of the form <i>YYYY/MM/DD</i>
     * @param elapsedTime time in milliseconds
     */
    MyDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date(elapsedTime);
        cal.setTime(date);
        year = cal.get(GregorianCalendar.YEAR);
        month = cal.get(GregorianCalendar.MONTH) + 1;
        day = cal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    /**
     * A date is constructed with the given year, month, and day
     * @param year the value used to set the year
     * @param month the value used to set the month
     * @param day - the value used to set the day
     */
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

    /**
     * Given an integer representing a month, returns the Calendar constant representing the month. The Calendar constants
     * (e.g. Calendar.MAY, Calendar.JUNE, etc.) returned are zero based. For example, Calendar.APRIL returns 3, not 4.
     * @param month a value representing a month
     * @return Calendar.[MONTH]. -1 if a number not representing a month is given.
     */
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
