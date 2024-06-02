package hus.oop.lab6.inheritance.animalanditssubclasses;

public class TestAnimal {
    public static void main(String[] args) {
        Animal animal = new Animal("Generic Animal");
        Mammal mammal = new Mammal("Generic Mammal");
        Cat cat = new Cat("Fluffy");
        Dog dog1 = new Dog("Buddy");
        Dog dog2 = new Dog("Max");

        System.out.println(animal);
        System.out.println(mammal);
        System.out.println(cat);
        System.out.println(dog1);
        System.out.println(dog2);

        cat.greets();
        dog1.greets();

        dog1.greets(dog2);
    }
}
