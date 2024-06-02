package hus.oop.lab10.designpatterns.strategy.strategies;

import hus.oop.lab9.library.Rent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayByPaypal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIN;

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIN) {
                System.out.println("Enter the user's email: ");
                email = READER.readLine();
                System.out.println("Enter the password: ");
                password = READER.readLine();

                if (verify()) {
                    System.out.println("Data verification has been successful.");
                } else {
                    System.out.println("Wrong email or password!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean verify() {
        setSignedIN(email.equals(DATA_BASE.get(password)));
        return signedIN;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIN) {
            System.out.println("Paying" + paymentAmount + "using Paypal.");
            return true;
        }
        return false;
    }

    public void setSignedIN(boolean signedIN) {
        this.signedIN = signedIN;
    }
}
