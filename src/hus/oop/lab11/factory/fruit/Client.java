package hus.oop.lab11.factory.fruit;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.testMakeFruit();
    }

    public void testMakeFruit() {
        Fruit apple = FruitFactory.provideFruit("Apple");
        Fruit orange = FruitFactory.provideFruit("Orange");
        Fruit banana = FruitFactory.provideFruit("Banana");
    }
}
