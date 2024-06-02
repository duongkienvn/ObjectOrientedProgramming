package hus.oop.lab7.movable;

public class TestMovable {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(1, 1, 2, 2);
        System.out.println("Initial position: " + point);

        point.moveUp();
        point.moveRight();
        System.out.println("After moving up and right: " + point);

        point.moveDown();
        point.moveLeft();
        System.out.println("After moving down and left: " + point);
    }
}
