package hus.oop.lab6.inheritance.circleandcylindercomposition;

public class TestCylinder {
    public static void main(String[] args) {
        Circle circle1 = new Circle(3.5, "Red");
        System.out.println("Circle 1:");
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Color: " + circle1.getColor());
        System.out.println("Area: " + circle1.getArea());
        System.out.println("String representation: " + circle1.toString());
        System.out.println();

        // Test Cylinder class
        Circle base = new Circle(2.0, "Blue");
        Cylinder cylinder1 = new Cylinder(base, 5.0);
        System.out.println("Cylinder 1:");
        System.out.println("Base - Radius: " + cylinder1.getBase().getRadius());
        System.out.println("Base - Color: " + cylinder1.getBase().getColor());
        System.out.println("Height: " + cylinder1.getHeight());
        System.out.println("Volume: " + cylinder1.getVolume());
        System.out.println("String representation: " + cylinder1.toString());
    }
}
