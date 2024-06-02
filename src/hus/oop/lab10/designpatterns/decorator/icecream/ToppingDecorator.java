package hus.oop.lab10.designpatterns.decorator.icecream;

public abstract class ToppingDecorator implements IceCream {
    IceCream iceCream;
    public abstract String getDescription();
    public abstract String addTopping();
}
