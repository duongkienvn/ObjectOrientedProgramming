package hus.oop.lab11.abstractfactory.shape;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory factory = FactoryProducer.getFactory(false);
        Shape rectangle = factory.getShape("rectangle");
        rectangle.draw();

        Shape square = factory.getShape("square");
        square.draw();

        AbstractFactory roundedShapeFactory = FactoryProducer.getFactory(true);
        Shape roundedSquare = roundedShapeFactory.getShape("square");
        roundedSquare.draw();

        Shape roundedRectangle = roundedShapeFactory.getShape("rectangle");
        roundedRectangle.draw();
    }
}
