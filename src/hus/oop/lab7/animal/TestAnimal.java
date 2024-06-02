package hus.oop.lab7.animal;

public class TestAnimal {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom");
        cat1.greets();

        Dog dog1 = new Dog("Buddy");
        dog1.greets();

        BigDog bigDog1 = new BigDog("Max");
        bigDog1.greets();

        // Using Polymorphism
        Animal animal1 = new Cat("Luna");
        animal1.greets();

        Animal animal2 = new Dog("Rocky");
        animal2.greets();

        Animal animal3 = new BigDog("Duke");
        animal3.greets();

        // Downcast

        Dog dog2 = new Dog();
        BigDog bigDog2 = (BigDog) animal3;

        Dog dog3 = new BigDog();
        Cat cat2 = new Cat();

        if (animal2 instanceof Dog) {
            dog2 = (Dog) animal2;
        }
        if (animal1 instanceof Cat) {
            cat2 = (Cat) animal1;
        }
        if (animal3 instanceof BigDog) {
            dog3 = (BigDog) animal3;
        }

        dog2.greets(dog3);
        dog3.greets(dog2);
        dog2.greets(bigDog2);
        bigDog2.greets(dog2);
        bigDog2.greets(bigDog1);
    }
}
