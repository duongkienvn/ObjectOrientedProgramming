package hus.oop.lab4.shapes;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public double getAnnualSalary(){
        return salary * 12;
    }

    public int raiseSalary(int percent){
        this.salary = this.salary + this.salary * percent / 100;
        return this.salary;
    }

    public String toString(){
        return "Employee[id=" + id + ", name=" + getName() + ", salary=" + getSalary() + "]";
    }
}
