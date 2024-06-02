package hus.oop.lab4.composition.mycircleandmypoint;

import hus.oop.lab4.composition.mypoint.MyPoint;

public class TestMyCircle {
    public static void main(String[] args) {
        MyPoint point = new MyPoint(3, 4);

        // Test constructors
        MyCircle circle1 = new MyCircle();
        MyCircle circle2 = new MyCircle(1, 2, 3);
        MyCircle circle3 = new MyCircle(point, 5);

        // Test getters and setters
        System.out.println("Center of circle1: " + circle1.getCenter());
        System.out.println("Radius of circle1: " + circle1.getRadius());

        circle1.setCenter(new MyPoint(1, 1));
        circle1.setRadius(2);

        System.out.println("Updated center of circle1: " + circle1.getCenter());
        System.out.println("Updated radius of circle1: " + circle1.getRadius());

        System.out.println("CenterX of circle2: " + circle2.getCenterX());
        System.out.println("CenterY of circle2: " + circle2.getCenterY());

        circle2.setCenterX(5);
        circle2.setCenterY(6);

        System.out.println("Updated CenterX of circle2: " + circle2.getCenterX());
        System.out.println("Updated CenterY of circle2: " + circle2.getCenterY());

        // Test other methods
        System.out.println("Area of circle3: " + circle3.getArea());
        System.out.println("Circumference of circle3: " + circle3.getCircumference());

        // Test distance method
        MyCircle anotherCircle = new MyCircle(7, 8, 9);
        System.out.println("Distance between circle3 and anotherCircle: " + circle3.distance(anotherCircle));

        // Test toString method
        System.out.println(circle1.toString());
        System.out.println(circle2.toString());
        System.out.println(circle3.toString());
    }
}
