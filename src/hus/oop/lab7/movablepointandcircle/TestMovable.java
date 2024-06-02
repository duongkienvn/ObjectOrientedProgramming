package hus.oop.lab7.movablepointandcircle;

public class TestMovable {
    public static void main(String[] args) {
        Movable point = new MovablePoint(1, 1, 2, 2);
        System.out.println("Initial position of the point: " + point);

        point.moveUp();
        point.moveRight();
        System.out.println("After moving up and right: " + point);

        // Test MovableCircle
        Movable circle = new MovableCircle(3, 3, 1, 1, 5);
        System.out.println("Initial position and radius of the circle: " + circle);

        circle.moveDown();
        circle.moveLeft();
        System.out.println("After moving down and left: " + circle);
    }
}
