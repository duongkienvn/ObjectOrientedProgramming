package hus.oop.lab11.abstractfactory.shape;

public class RoundedShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("rectangle")) {
            return new RoundedRectangle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new RoundedRectangle();
        }
        return null;
    }
}
