package hus.oop.lab11.factory.fruit;

public class FruitFactory {
    public FruitFactory() {

    }

    public static final Fruit provideFruit(String fruitType) {
        Fruit fruit;

        switch (fruitType.toLowerCase()) {
            case "apple":
                fruit = new Apple();
                break;
            case "banana":
                fruit = new Banana();
                break;
            case "orange":
                fruit = new Orange();
                break;
            default:
                throw new IllegalArgumentException("No such Fruit");
        }
        fruit.produceJuice();
        return fruit;
    }
}
