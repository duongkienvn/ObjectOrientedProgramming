package hus.oop.lab4.composition.authorandbook;

public class TestAuthor {
    public static void main(String[] args) {
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        System.out.println(ahTeck); // Test toString()

        // Test setter
        ahTeck.setEmail("paulTan@nowhere.com");

        // Test getters
        System.out.println("Name is: " + ahTeck.getName());
        System.out.println("Email is: " + ahTeck.getEmail());
        System.out.println("Gender is: " + ahTeck.getGender());
    }
}
