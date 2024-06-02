package hus.oop.lab9.collections.phonebook;

import java.util.HashMap;
import java.util.Map;

public class PhoneBookMap implements PhoneBook {
    HashMap<String, Student> phoneBook;

    public PhoneBookMap() {
        phoneBook = new HashMap<>();
    }

    public void addPerson(Student s) {
        phoneBook.put(s.phone, s);
    }

    public Student searchByName(String name) {
        for (Map.Entry<String, Student> entry : phoneBook.entrySet()) {
            if (entry.getValue().name.equals(name)) {
                return entry.getValue();
            }
        }
        return new Student("", "", "");
    }

    public Student searchByLastName(String lastName) {
        for (Map.Entry<String, Student> entry : phoneBook.entrySet()) {
            if (entry.getValue().lastName.equals(lastName)) {
                return entry.getValue();
            }
        }
        return new Student("", "", "");
    }

    public Student searchByNumber(String phone) {
        for (Map.Entry<String, Student> entry : phoneBook.entrySet()) {
            if (entry.getKey().equals(phone)) {
                return entry.getValue();
            }
        }
        return new Student("", "", "");
    }

    public void deleteByNumber(String phone) {
        phoneBook.remove(phone);
    }
}
