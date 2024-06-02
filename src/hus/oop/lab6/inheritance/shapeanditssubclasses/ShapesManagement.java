package hus.oop.lab6.inheritance.shapeanditssubclasses;

import java.util.ArrayList;
import java.util.List;

public class ShapesManagement {
    private ArrayList<Shape> listShape;

    public ShapesManagement() {
        listShape = new ArrayList<>();
    }

    public static void addShape(ArrayList<Shape> shapes, Shape shape) {
        shapes.add(shape);
    }

    public static void printShape(ArrayList<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shapes.toString());
        }
    }

    public static void printArea(ArrayList<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
    }

    public static void printPerimeter(ArrayList<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape.getPerimeter());
        }
    }

    public static void main(String[] args) {
        ShapesManagement shapesManagement = new ShapesManagement();

        addShape(shapesManagement.listShape, new Circle("red", true, 5.0));
        addShape(shapesManagement.listShape, new Rectangle("blue", false, 9.0, 5.0));
        addShape(shapesManagement.listShape, new Square(6.0));

        printArea(shapesManagement.listShape);
        printShape(shapesManagement.listShape);
        printPerimeter(shapesManagement.listShape);


    }
}
