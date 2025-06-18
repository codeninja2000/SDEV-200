package P01_MyDate;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        MyDate myDate = new MyDate();
        System.out.printf("Date: %d/%d/%d%n", myDate.getMonth(), myDate.getDay(), myDate.getYear());
        MyDate myDate2 = new MyDate(1690289159L);
        System.out.printf("Date: %d/%d/%d%n", myDate2.getMonth(), myDate2.getDay(), myDate2.getYear());
        MyDate myDate3 = new MyDate(1990, 3, 27);
        System.out.printf("Date: %d/%d/%d%n", myDate3.getMonth(), myDate3.getDay(), myDate3.getYear());
        myDate3.setDate(1150212159);
        System.out.printf("Date: %d/%d/%d%n", myDate3.getMonth(), myDate3.getDay(), myDate3.getYear());

    }
}