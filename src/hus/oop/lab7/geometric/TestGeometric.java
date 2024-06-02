package hus.oop.lab7.geometric;

public class TestGeometric {
    public static void main(String[] args) {
        GeometricObject circle = new Circle(5.5);
        System.out.println(circle);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        GeometricObject rectangle = new Rectangle(2.0, 3.0);
        System.out.println(rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());
    }
}
