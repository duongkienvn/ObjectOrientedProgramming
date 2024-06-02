package hus.oop.lab5.exerciesonclasses;

import java.math.BigInteger;

public class TestBigInteger {
    public static void main(String[] args) {
        String num1 = "11111111111111111111111111111111111111111111111111111111111111";
        String num2 = "22222222222222222222222222222222222222222222222222";
        BigInteger i1 = new BigInteger(num1);
        BigInteger i2 = new BigInteger(num2);
        System.out.println(i1.add(i2));
        System.out.println(i1.subtract(i2));
        System.out.println(i1.multiply(i2));
        System.out.println(i1.divide(i2));
        System.out.println(i1.min(i2));
        System.out.println(i1.max(i2));
        System.out.println(i1.pow(3));
        System.out.println(i1.signum()); // negative number => return -1, postive number => return 1
        System.out.println(i1.compareTo(i2));
    }

}
