package hus.oop.lab10.designpatterns.decorator.icecream;

public class NutsToppingDecorator extends ToppingDecorator {
    public NutsToppingDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public String getDescription() {
        return iceCream.getDescription() + addTopping();
    }

    public String addTopping() {
        return ", Nuts";
    }
}
