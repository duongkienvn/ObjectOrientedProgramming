package hus.oop.lab3;

import java.util.Scanner;

public class ExercisesOnRecursion {
    static Scanner sc = new Scanner(System.in);
    public static int factorial(int n){
        if(n == 0) return 1;
        return n * factorial(n - 1);
    }
    public static void testFactorial(){
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }
    public static int finonacci(int n){
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return finonacci(n - 1) + finonacci(n - 2);
    }
    public static void testFibonacci(){
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        System.out.println(finonacci(n));
    }
    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void testGcd(){
        System.out.print("Enter the value of a: ");
        int a = sc.nextInt();
        System.out.print("Enter the value of b: ");
        int b = sc.nextInt();
        System.out.println("GCD of a and b is: " + gcd(a, b));
    }
    public static int numberOfDigits(int n){
        if(n < 10)
            return 1;
        return 1 + numberOfDigits(n / 10);
    }
    public static int len(int n){
        if(n == 1)
            return 1;
        return len(n - 1) + numberOfDigits(n);
    }
    public static void testLength(){
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        int length = len(n);
        System.out.println("Length of S(" + n + "): " + length);
    }
    public static void main(String[] args) {
        testFactorial();
        testFibonacci();
        testGcd();
        testLength();

    }
}