package hus.oop.lab1;

import java.util.Scanner;

public class MathLibraryHomework {
    static Scanner sc = new Scanner(System.in);

    public static double sin(double x, int numTerms) {
        if (x > 2 * Math.PI) {
            x = x - 2 * Math.PI * Math.floor(x / (2 * Math.PI));
        }
        double sin = x;
        double Si = x;
        for (int i = 2; i <= numTerms; i++) {
            Si *= (-1) * x * x / ((2 * i - 1) * (2 * i - 2));
            sin += Si;
        }
        return sin;
    }

    public static double cos(double x, int numTerms) {
        if (x > 2 * Math.PI) {
            x = x - 2 * Math.PI * Math.floor(x / (2 * Math.PI));
        }
        double cos = 1;
        double Ci = 1;
        for (int i = 2; i <= numTerms; i++) {
            Ci *= (-1) * x * x / ((2 * i - 2) * (2 * i - 3));
            cos += Ci;
        }
        return cos;
    }

    public static void testTrigonometric() {
        System.out.print("Enter the value of x: ");
        double x = sc.nextDouble();
        System.out.print("Enter the value of numTerms: ");
        int numTerms = sc.nextInt();

        System.out.println("Using Trigonometric Series Expansion:");
        System.out.println("sin(" + x + ") = " + sin(x, numTerms));
        System.out.println("cos(" + x + ") = " + cos(x, numTerms));

        System.out.println("\nUsing Math.sin() and Math.cos() methods:");
        System.out.println("sin(" + x + ") = " + Math.sin(x));
        System.out.println("cos(" + x + ") = " + Math.cos(x));
    }

    public static double specialSeries(double x, int numTerms) {
        double sum = x;
        double Sk = x;

        for (int i = 1; i <= numTerms; i++) {
            Sk *= (x * x * (2 * i - 1) * (2 * i - 1)) / (2 * i * (2 * i + 1));
            sum += Sk;
        }
        return sum;
    }

    public static void testSpecialSeries() {
        System.out.print("Enter x value: ");
        double x = sc.nextDouble();
        System.out.print("Enter numTerms value: ");
        int numTerms = sc.nextInt();
        System.out.println("The sum of the series is: " + specialSeries(x, numTerms));
    }

    public static void factorialInt(int num) {
        final int maxInt = Integer.MAX_VALUE;
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            if ((double) maxInt / factorial < i + 1) {
                System.out.println("The factorial of " + i + " is out of range");
            } else {
                factorial *= i;
                System.out.println("The factotial of " + i + " is " + factorial);
            }
        }
    }

    public static void factorialLong(int num) {
        final long maxLong = Long.MAX_VALUE;
        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            if ((double) maxLong / factorial < i + 1) {
                System.out.println("The factorial of " + i + " is out of range");
            } else {
                factorial *= i;
                System.out.println("The factotial of " + i + " is " + factorial);
            }
        }
    }

    public static void testFactorial() {
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        factorialInt(num);
        factorialLong(num);
    }

    public static void fibonacciInt(int num) {
        int maxInt = Integer.MAX_VALUE;
        int fibo[] = new int[num];
        fibo[0] = 1;
        fibo[1] = 1;
        System.out.println("F(0) = 1 \nF(1) = 1");
        for (int i = 2; i <= num; i++) {
            if (maxInt - fibo[i - 1] < fibo[i - 2]) {
                System.out.print("F(" + i + ") is out of the range of int");
            } else {
                fibo[i] = fibo[i - 2] + fibo[i - 1];
                System.out.println("F(" + i + ") = " + fibo[i]);
            }
        }
    }

    public static void testFibonacciInt() {
        System.out.print("Enter the number: ");
        int number = sc.nextInt();
        fibonacciInt(number);
    }

    public static int converToDecimal(String num, int radix) {
        int decimal = 0;
        for (int charNum = 0; charNum < num.length(); charNum++) {
            char currentChar = num.charAt(charNum);
            int digit;
            if (Character.isLetter(currentChar)) {
                digit = currentChar - 'A' + 10;
            } else {
                digit = currentChar - '0';
            }
            decimal += digit * Math.pow(radix, num.length() - charNum - 1);
        }
        return decimal;
    }

    public static String reverseString(String inStr) {
        int intStrlen = inStr.length();
        String result = "";
        for (int charIdx = intStrlen - 1; charIdx >= 0; charIdx--) {
            result += inStr.charAt(charIdx);
        }
        return result;
    }

    public static String convertFromDecimal(int decimal, int radix) {
        String result = "";
        while (decimal != 0) {
            int remainder = decimal % radix;
            char digit = (char) (remainder < 10 ? (remainder + '0') : (remainder - 'A' + 10));
            result += digit;
            decimal /= radix;
        }

        return reverseString(result);
    }

    public static String toRadix(String in, int inRadix, int outRadix) {
        int decimal = converToDecimal(in, inRadix);
        return convertFromDecimal(decimal, outRadix);

    }

    public static void testNumberConversion() {
        System.out.print("Enter a number and radix: ");
        String in = sc.nextLine();
        System.out.print("Enter the input radix: ");
        int inRadix = sc.nextInt();
        System.out.print("Enter the output radix: ");
        int outRadix = sc.nextInt();
        System.out.println(in + " in radix " + inRadix + " is " + toRadix(in, inRadix, outRadix)
                + " in radix " + outRadix);
    }

    public static void main(String[] args) {
        testTrigonometric();
        testSpecialSeries();
        testFactorial();
        testFibonacciInt();
        testNumberConversion();
    }
}
