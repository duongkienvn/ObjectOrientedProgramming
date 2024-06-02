package hus.oop.lab10.designpatterns.decorator.shape;

public class ShapeDecorator extends Shape {
    Shape shape;

    ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    void draw() {
        shape.draw();
    }
}
