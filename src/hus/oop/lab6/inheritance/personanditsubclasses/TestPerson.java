package hus.oop.lab6.inheritance.personanditsubclasses;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person("John", "123 Main St");
        System.out.println("Person:");
        System.out.println("Name: " + person.getName());
        System.out.println("Address: " + person.getAddress());
        System.out.println();

        Student student = new Student("Alice", "456 Elm St", "Computer Science", 2023, 5000.0);
        System.out.println("Student:");
        System.out.println("Name: " + student.getName());
        System.out.println("Address: " + student.getAddress());
        System.out.println("Program: " + student.getProgram());
        System.out.println("Year: " + student.getYear());
        System.out.println("Fee: " + student.getFee());
        System.out.println();

        Staff staff = new Staff("Bob", "789 Oak St", "High School", 3000.0);
        System.out.println("Staff:");
        System.out.println("Name: " + staff.getName());
        System.out.println("Address: " + staff.getAddress());
        System.out.println("School: " + staff.getSchool());
        System.out.println("Pay: " + staff.getPay());
    }
}
