package hus.oop.lab6.inheritance.animalanditssubclasses;

public class Mammal extends Animal{
    public Mammal(String name) {
        super(name);
    }

    public String toString() {
        return "Mammal[" + super.toString() + "]";
    }
}
