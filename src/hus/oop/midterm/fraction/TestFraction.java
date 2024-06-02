package hus.oop.midterm.fraction;

import java.util.*;

public class TestFraction {
    private List<Fraction> fractions;

    public TestFraction() {
        fractions = new LinkedList<>();
    }

    public TestFraction(List<Fraction> data) {
        fractions = data;
    }

    public Fraction getSecondLargestValue() {
        sortByValue(fractions);
        return fractions.get(fractions.size() - 2);
    }

    public static void print(List<Fraction> list) {
        for (Fraction fraction : list) {
            System.out.println(fraction);
        }
    }

    public static List<Fraction> sortByDenominator(List<Fraction> list) {
        List<Fraction> myList = new LinkedList<>(list);
        Collections.sort(myList, new Comparator<Fraction>() {
            @Override
            public int compare(Fraction o1, Fraction o2) {
                return o1.getDenominator() - o2.getDenominator();
            }
        });
        return myList;
    }

    public static List<Fraction> sortByValue(List<Fraction> list) {
        List<Fraction> myList = new LinkedList<>(list);
        Collections.sort(myList);
        return myList;
    }

    public static List<Fraction> generateRandomFractions(int n) {
        List<Fraction> fractions = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int numerator = random.nextInt(1000) + 1; // Số ngẫu nhiên từ 1 đến 1000
            int denominator = random.nextInt(1000) + 1;
            fractions.add(new Fraction(numerator, denominator));
        }
        return fractions;
    }

    public static void main(String[] args) {
        List<Fraction> fractions = generateRandomFractions(30);
        TestFraction test = new TestFraction(fractions);

        System.out.println("Original list:");
        test.print(fractions);

        System.out.println("\nSorted by value:");
        test.sortByValue(fractions);
        test.print(fractions);

        System.out.println("\nSorted by denominator:");
        test.sortByDenominator(fractions);
        test.print(fractions);

        System.out.println("\nSecond largest value:");
        Fraction secondLargest = test.getSecondLargestValue();
        if (secondLargest != null) {
            System.out.println(secondLargest);
        } else {
            System.out.println("List does not contain enough elements.");
        }
    }
}
