package hus.oop.lab7.interfacemovable;

public class TestMovable {
    public static void main(String[] args) {
        // Test MovablePoint
        System.out.println("Testing MovablePoint:");
        Movable m1 = new MovablePoint(5, 6, 10, 15); // upcast
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);

        // Test MovableCircle
        System.out.println("\nTesting MovableCircle:");
        Movable m2 = new MovableCircle(1, 2, 3, 4, 20); // upcast
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);

        // Test MovableRectangle
        System.out.println("\nTesting MovableRectangle:");
        Movable movableRectangle = new MovableRectangle(0, 0, 5, 5, 1, 1);
        System.out.println("Original position: " + movableRectangle);
        movableRectangle.moveUp();
        movableRectangle.moveRight();
        System.out.println("After moving up and right: " + movableRectangle);
    }
}
