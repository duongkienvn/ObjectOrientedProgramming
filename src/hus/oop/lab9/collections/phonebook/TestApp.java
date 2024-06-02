package hus.oop.lab9.collections.phonebook;

import java.util.Map;

public class TestApp {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBookMap();

        pb.addPerson(new Student("Nicola", "Bicocchi", "34567"));
        pb.addPerson(new Student("Marco", "Rizzo", "45243"));
        pb.addPerson(new Student("Luisa", "Poppi", "24564"));

        System.out.println(pb.searchByName("Nicola"));
        System.out.println(pb.searchByLastName("Poppi"));
        System.out.println(pb.searchByNumber("34567"));


    }
}
