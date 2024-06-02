package hus.oop.lab5.exerciesonclasses;

public class MyDate {
    private int year;
    private int month;
    private int day;

    final static String MONTHS[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"};

    final static String DAYS[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday"};

    final static int DAYS_IN_MONTHS[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int getDayInMonth(int month) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return DAYS_IN_MONTHS[month - 1];
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12 || day < 1 || day > getDayInMonth(month)) {
            return false;
        }
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            return false;
        }
        return true;
    }

    public int getDayOfWeek(int year, int month, int day) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31 * m0) / 12) % 7;
        return d0;
    }

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    public void setDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Invalid year!");
        }
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month!");
        }
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int day) {
        if (day < 1 || day > getDayInMonth(month)) {
            throw new IllegalArgumentException("Invalid day!");
        }
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public String toString() {
        return DAYS[getDayOfWeek(year, month, day)] + " " + getDay() + " " +
                MONTHS[getMonth() - 1] + " " + getYear();
    }

    public MyDate nextDay() {
        day++;
        if (day > getDayInMonth(month)) {
            day = 1;
            nextMonth();
        }
        return this;
    }

    public MyDate nextMonth() {
        month++;
        if (month > 12) {
            month = 1;
            nextYear();
        }
        return this;
    }

    public MyDate nextYear() {
        year++;
        if (year > 9999) {
            throw new IllegalArgumentException("Invalid year!");
        }
        return this;
    }

    public MyDate previousYear() {
        year--;
        if (year < 1) {
            throw new IllegalArgumentException("Invalid year!");
        }
        return this;
    }

    public MyDate previousMonth() {
        month--;
        if (month < 1) {
            month = 12;
            previousYear();
        }
        return this;
    }

    public MyDate previousDay() {
        day--;
        if (day < 1) {
            previousMonth();
            day = getDayInMonth(month);
        }
        return this;
    }
}
