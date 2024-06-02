package hus.oop.lab6.inheritance.animalanditssubclasses;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String toString() {
        return "Animal[name = " + name + "]";
    }
}
