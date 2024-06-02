package hus.oop.lab10.designpatterns.decorator.icecream;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        IceCream iceCream = new ChocolateIceCream();
        IceCream iceCream1 = new StrawberryIceCream();
        IceCream iceCream3 = new VanillaIceCream();
        IceCream iceCream4 = new HoneyToppingDecorator(new StrawberryIceCream());
        IceCream iceCream5 = new HoneyToppingDecorator(new VanillaIceCream());
        IceCream iceCream6 = new NutsToppingDecorator(iceCream);

        List<IceCream> iceCreamList = new ArrayList<>();
        iceCreamList.add(iceCream1);
        iceCreamList.add(iceCream3);
        iceCreamList.add(iceCream4);
        iceCreamList.add(iceCream5);
        iceCreamList.add(iceCream6);

        for (IceCream icecream : iceCreamList) {
            System.out.println(icecream.getDescription());
        }
    }
}
