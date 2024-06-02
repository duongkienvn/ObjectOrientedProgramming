package hus.oop.lab5.exerciesonclasses;

public class TestMyTime {
    public static void main(String[] args) {
        // Test constructor and setters
        MyTime time = new MyTime(12, 30, 45);
        System.out.println("Initial time: " + time);

        // Test nextSecond(), nextMinute(), nextHour()
        System.out.println("Next second: " + time.nextSecond());
        System.out.println("Next minute: " + time.nextMinute());
        System.out.println("Next hour: " + time.nextHour());

        // Test previousSecond(), previousMinute(), previousHour()
        System.out.println("Previous second: " + time.previousSecond());
        System.out.println("Previous minute: " + time.previousMinute());
        System.out.println("Previous hour: " + time.previousHour());

        // Test toString()
        System.out.println("Current time: " + time);

        // Test setters
        time.setHour(15);
        time.setMinute(20);
        time.setSecond(10);
        System.out.println("Updated time: " + time);

        // Test setTime()
        time.setTime(23, 59, 59);
        System.out.println("Set time to 23:59:59: " + time);

        // Test invalid input
        try {
            time.setTime(25, 70, 80); // Invalid time
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input caught: " + e.getMessage());
        }
    }
}
