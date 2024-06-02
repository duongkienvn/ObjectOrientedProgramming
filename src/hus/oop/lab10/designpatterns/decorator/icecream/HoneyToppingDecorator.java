package hus.oop.lab10.designpatterns.decorator.icecream;

public class HoneyToppingDecorator extends ToppingDecorator {
    public HoneyToppingDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public String getDescription() {
        return iceCream.getDescription() + addTopping();
    }

    public String addTopping() {
        return ", Honey";
    }
}
