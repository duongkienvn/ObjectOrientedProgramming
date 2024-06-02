package hus.oop.lab7.shape;

public class TestShape {
    public static void main(String[] args) {
        Shape shape1 = new Circle("red", false, 5.5);
        System.out.println(shape1);
        System.out.println(shape1.getArea()); // which version?
        System.out.println(shape1.getPerimeter()); // which version?
        System.out.println(shape1.getColor());
        System.out.println(shape1.isFilled());
        System.out.println(((Circle)shape1).getRadius()); // Downcast back to Circle
        Circle circle1 = (Circle) shape1;
        System.out.println(circle1);
        System.out.println(circle1.getArea());
        System.out.println(circle1.getPerimeter());
        System.out.println(circle1.getColor());
        System.out.println(circle1.isFilled());
        System.out.println(circle1.getRadius());

    //    Shape shape2 = new Shape();  error
        Shape shape3 = new Rectangle("red", false, 2.0, 1.0); // Upcast
        System.out.println(shape3);
        System.out.println(shape3.getArea());
        System.out.println(shape3.getPerimeter());
        System.out.println(shape3.getColor());
        System.out.println(((Rectangle)shape3).getLength()); // downcast
        Rectangle rectangle1 = (Rectangle) shape3;
        System.out.println(rectangle1);
        System.out.println(rectangle1.getArea());
        System.out.println(rectangle1.getColor());
        System.out.println(rectangle1.getLength());

        Shape shape4 = new Square(6.6); // Upcast
        System.out.println(shape4);
        System.out.println(shape4.getArea());
        System.out.println(shape4.getColor());
        System.out.println(((Square)shape4).getSide());
        // Take note that we downcast Shape shape4 to Rectangle,
        // which is a superclass of Square, instead of Square
        Rectangle rectangle2 = (Rectangle) shape4;
        System.out.println(rectangle2);
        System.out.println(rectangle2.getArea());
        System.out.println(rectangle2.getColor());
        // System.out.println(((Rectangle)rectangle2).getSide()); // Rectangle doesn't have a method getSide(), this line may throw an error
        System.out.println(rectangle2.getLength());
        // Downcast Rectangle rectangle2 to Square
        Square square1 = (Square) rectangle2;
        System.out.println(square1);
        System.out.println(square1.getArea());
        System.out.println(square1.getColor());
        System.out.println(square1.getSide());
        System.out.println(square1.getLength());
    }
}
