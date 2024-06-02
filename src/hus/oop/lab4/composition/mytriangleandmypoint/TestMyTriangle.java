package hus.oop.lab4.composition.mytriangleandmypoint;

import hus.oop.lab4.composition.mypoint.MyPoint;

public class TestMyTriangle {
    public static void main(String[] args) {
        MyTriangle triangle1 = new MyTriangle(0, 0, 3, 0, 0, 4);
        MyTriangle triangle2 = new MyTriangle(new MyPoint(0, 0), new MyPoint(3, 0), new MyPoint(0, 4));

        // Test toString method
        System.out.println("Triangle 1: " + triangle1.toString());
        System.out.println("Triangle 2: " + triangle2.toString());

        // Test getPerimeter method
        System.out.println("Perimeter of triangle 1: " + triangle1.getPerimeter());
        System.out.println("Perimeter of triangle 2: " + triangle2.getPerimeter());

        // Test getType method
        System.out.println("Type of triangle 1: " + triangle1.getType());
        System.out.println("Type of triangle 2: " + triangle2.getType());
    }
}
