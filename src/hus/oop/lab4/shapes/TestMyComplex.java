package hus.oop.lab4.shapes;

import java.util.Scanner;

public class TestMyComplex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter complex number 1 (real and imaginary part): ");
        double real1 = scanner.nextDouble();
        double imag1 = scanner.nextDouble();

        System.out.print("Enter complex number 2 (real and imaginary part): ");
        double real2 = scanner.nextDouble();
        double imag2 = scanner.nextDouble();

        MyComplex complex1 = new MyComplex(real1, imag1);
        MyComplex complex2 = new MyComplex(real2, imag2);

        System.out.println("Number 1 is: " + complex1);
        System.out.println(complex1 + " is " + (complex1.isReal() ? "" : "NOT ") + "a pure real number");
        System.out.println(complex1 + " is " + (complex1.isImaginary() ? "" : "NOT ") + "a pure imaginary number");

        System.out.println("Number 2 is: " + complex2);
        System.out.println(complex2 + " is " + (complex2.isReal() ? "" : "NOT ") + "a pure real number");
        System.out.println(complex2 + " is " + (complex2.isImaginary() ? "" : "NOT ") + "a pure imaginary number");

        System.out.println(complex1 + " is " + (complex1.equals(complex2) ? "" : "NOT ") + "equal to " + complex2);

        MyComplex sum = complex1.addNew(complex2);
        MyComplex difference = complex1.subtractNew(complex2);
        System.out.println(complex1 + " + " + complex2 + " = " + sum);
        System.out.println(complex1 + " - " + complex2 + " = " + difference);

        // Tính tích và thương của hai số phức
        MyComplex product = complex1.multiply(complex2);
        MyComplex quotient = complex1.divide(complex2);
        System.out.println(complex1 + " * " + complex2 + " = " + product);
        System.out.println(complex1 + " / " + complex2 + " = " + quotient);

        // Tính đối số và số liên hợp của số phức
        System.out.println("Argument of " + complex1 + " = " + complex1.argument());
        MyComplex conjugate = complex1.conjugate();
        System.out.println("Conjugate of " + complex1 + " = " + conjugate);
    }
}
