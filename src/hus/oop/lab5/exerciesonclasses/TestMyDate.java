package hus.oop.lab5.exerciesonclasses;

public class TestMyDate {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(2005, 7, 5);
        System.out.println(date1);
        System.out.println(date1.nextDay());
        System.out.println(date1.nextDay());
        System.out.println(date1.nextMonth());
        System.out.println(date1.nextYear());

        MyDate date2 = new MyDate(2012, 1, 2);
        System.out.println(date2); // Monday 2 Jan 2012
        System.out.println(date2.previousDay()); // Sunday 1 Jan 2012
        System.out.println(date2.previousDay()); // Saturday 31 Dec 2011
        System.out.println(date2.previousMonth()); // Wednesday 30 Nov 2011
        System.out.println(date2.previousYear()); // Tuesday 30 Nov 2010

        MyDate date3 = new MyDate(2012, 2, 29);
        System.out.println(date3.previousYear()); // Monday 28 Feb 2011


        try {
            MyDate date4 = new MyDate(2099, 11, 31);
            MyDate date5 = new MyDate(2011, 2, 29);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
