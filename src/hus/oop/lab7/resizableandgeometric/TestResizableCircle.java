package hus.oop.lab7.resizableandgeometric;

public class TestResizableCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("Circle:");
        System.out.println(circle.toString());
        System.out.println("Perimeter: " + circle.getPerimeter());
        System.out.println("Area: " + circle.getArea());

        Circle circle1 = new ResizableCircle(3.0);
        System.out.println("\nResizable Circle:");
        System.out.println(circle1.toString());
        ResizableCircle resizable = (ResizableCircle) circle1;
        resizable.resize(50);
        System.out.println("After resizing by 50%:");
        System.out.println(resizable.toString());
    }
}
