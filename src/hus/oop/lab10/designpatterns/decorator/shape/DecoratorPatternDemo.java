package hus.oop.lab10.designpatterns.decorator.shape;

import java.util.ArrayList;
import java.util.List;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape shape1 = new RedShapeDecorator(new Circle());
        Shape shape2 = new RedShapeDecorator(new Rectangle());
        Shape shape3 = new RedShapeDecorator(new RedShapeDecorator(new Circle()));
        Shape shape4 = new RedShapeDecorator(new RedShapeDecorator(new Rectangle()));
        Shape shape5 = new Circle();
        Shape shape6 = new Rectangle();

        List<Shape> shapes = new ArrayList<>();
        shapes.add(shape1);
        shapes.add(shape2);
        shapes.add(shape3);
        shapes.add(shape4);
        shapes.add(shape5);
        shapes.add(shape6);

        for (Shape shape : shapes) {
            shape.draw();
            System.out.println();
        }
    }
}
