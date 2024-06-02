package hus.oop.lab9.collections.phonebook;

import java.util.ArrayList;

public class PhoneBookList implements PhoneBook{
    ArrayList<Student> phoneBook;

    public PhoneBookList() {
        phoneBook = new ArrayList<>();
    }

    @Override
    public void addPerson(Student p) {
        phoneBook.add(p);
    }

    @Override
    public Student searchByName(String name) {
        for (Student student : phoneBook) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return new Student("", "", "");
    }

    @Override
    public Student searchByLastName(String lastName) {
        for (Student student : phoneBook) {
            if (student.lastName.equals(lastName)) {
                return student;
            }
        }
        return new Student("", "", "");
    }

    @Override
    public Student searchByNumber(String phone) {
        for (Student student : phoneBook) {
            if (student.phone.equals(phone)) {
                return student;
            }
        }
        return new Student("", "", "");
    }

    @Override
    public void deleteByNumber(String phone) {
        for (Student student : phoneBook) {
            if (student.phone.equals(phone)) {
                phoneBook.remove(student);
            }
        }
    }

}
