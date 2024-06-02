package hus.oop.lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExerciesOnAlgorithms_NumberTheory {
    static Scanner sc = new Scanner(System.in);
    public static boolean isPerfect(int aPosInt){
        if(aPosInt <= 1) return false;
        int sum = 1;
        for(int i = 2; i <= aPosInt / 2; i++){
            if(aPosInt % i == 0){
                sum += i;
            }
        }
        return sum == aPosInt;
    }
    public static boolean isDeficient(int aPosInt){
        int sum = 1;
        for(int i = 2; i <= aPosInt / 2; i++){
            if(aPosInt % i == 0){
                sum += i;
            }
        }
        return sum < aPosInt;
    }
    public static void testIsPerfect(){
        System.out.print("Enter the a positive integer: ");
        int aPosInt = sc.nextInt();
        if(isPerfect(aPosInt)){
            System.out.println(aPosInt + " is a perfect number");
        }
        else{
            System.out.println(aPosInt + " is not a perfect number");
        }
    }
    public static void testIsDeficiency(){
        System.out.print("Enter the a positive integer: ");
        int aPosInt = sc.nextInt();
        if(isDeficient(aPosInt)){
            System.out.println(aPosInt + " is a deficiency number");
        }
        else{
            System.out.println(aPosInt + " is not a deficiency number");
        }
    }
    public static void PerfectNumberList(){
        System.out.print("Enter the upper bound: ");
        int upperBound = sc.nextInt();
        int temp = upperBound;
        ArrayList<Integer> listPerfect = new ArrayList<>();
        ArrayList<Integer> listNeitherDeficiencyNotPerfect = new ArrayList<>();
        int countPerfect = 0;
        int countNeitherDeficiencyNotPerfect = 0;
        for(int i = 2; i <= upperBound; i++){
            if(isPerfect(i)){
                countPerfect++;
                listPerfect.add(i);
            }
            else if(!isDeficient(i) && !isPerfect(i)){
                countNeitherDeficiencyNotPerfect++;
                listNeitherDeficiencyNotPerfect.add(i);
            }
        }
        System.out.println(countPerfect);
        System.out.println(countNeitherDeficiencyNotPerfect);
        System.out.println("These numbers are perfect: ");
        for(int perfect: listPerfect){
            System.out.print(perfect + " ");
        }
        System.out.println();
        double percentPerfect = (double) countPerfect / upperBound * 100;
        System.out.printf("[ %d perfect numbers found %.2f%%) ]", countPerfect, percentPerfect);

        System.out.println();
        double percentNumber = (double) countNeitherDeficiencyNotPerfect / upperBound * 100;
        System.out.println("These numbers are neither deficient nor perfect :");
        for(int number: listNeitherDeficiencyNotPerfect){
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.printf("[ %d numbers found %.2f%%) ]", countNeitherDeficiencyNotPerfect, percentNumber);
    }
    public static boolean isPrime(int aPosInt){
        for(int i = 2; i <= Math.sqrt(aPosInt); i++){
            if(aPosInt % i == 0)
                return false;
        }
        return aPosInt > 1;
    }
    public static void PrimeList(){
        System.out.print("Enter the upper bound: ");
        int upperbound = sc.nextInt();
        ArrayList<Integer> primeList = new ArrayList<>();
        int countPrime = 0;
        for(int i = 1; i <= upperbound; i++){
            if(isPrime(i)){
                primeList.add(i);
                countPrime++;
            }
        }
        double percentPrime = (double) countPrime / upperbound * 100;
        System.out.println("");
        for(int prime: primeList){
            System.out.print(prime + " ");
        }
        System.out.println();
        System.out.printf("[%d primes found (%.2f%%)]", countPrime, percentPrime);
    }
    public static boolean isProductOfPrimeFactors(int aPosInt){
        int product = 1;
        for(int i = 1; i < aPosInt; i++){
            if(isPrime(i) && aPosInt % i == 0){
                product *= i;
            }
        }
        return product == aPosInt;
    }

    public static void PerfectPrimeFactorLis(){
        System.out.print("Enter the upper bound: ");
        int upperbound = sc.nextInt();
        int countPrimeFactor = 0;
        ArrayList<Integer> listPrimeFactor = new ArrayList<>();
        for(int i = 2; i <= upperbound; i++){
            if(isProductOfPrimeFactors(i)){
                countPrimeFactor++;
                listPrimeFactor.add(i);
            }
        }
        System.out.println("These numbers are equal to the product of prime factors: ");
        for(int primeFactor: listPrimeFactor){
            System.out.print(primeFactor + " ");
        }
        double percentPrimeFactor = (double) countPrimeFactor / upperbound * 100;
        System.out.println();
        System.out.printf("[%d numbers found (%.2f%%)]", countPrimeFactor, percentPrimeFactor);
    }
    public static int gcd(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    public static void testGcd(){
        System.out.print("Enter the value of a: ");
        int a = sc.nextInt();
        System.out.print("Enter the value of b: ");
        int b = sc.nextInt();
        System.out.println("GCD of a and b is: " + gcd(a, b));
    }
    public static void main(String[] args) {
        PerfectNumberList();
        testIsDeficiency();
        PrimeList();
        PerfectPrimeFactorLis();
        testGcd();
    }
}