package hus.oop.lab4.composition.mylineandmypoint;

import hus.oop.lab4.composition.mypoint.MyPoint;

public class TestMyLine {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(1, 2);
        MyPoint point2 = new MyPoint(4, 6);

        // Test constructors
        MyLine line1 = new MyLine(1, 2, 4, 6);
        MyLine line2 = new MyLine(point1, point2);

        // Test getters and setters
        System.out.println("Begin point of line1: " + line1.getBegin());
        System.out.println("End point of line1: " + line1.getEnd());

        line1.setBegin(new MyPoint(0, 0));
        line1.setEnd(new MyPoint(5, 5));

        System.out.println("Updated begin point of line1: " + line1.getBegin());
        System.out.println("Updated end point of line1: " + line1.getEnd());

        System.out.println("BeginX of line2: " + line2.getBeginX());
        System.out.println("BeginY of line2: " + line2.getBeginY());

        line2.setBeginX(3);
        line2.setBeginY(4);

        System.out.println("Updated BeginX of line2: " + line2.getBeginX());
        System.out.println("Updated BeginY of line2: " + line2.getBeginY());

        // Test other methods
        System.out.println("Length of line1: " + line1.getLength());
        System.out.println("Gradient of line1: " + line1.getGradient());

        // Test toString method
        System.out.println(line1.toString());
        System.out.println(line2.toString());
    }
}
