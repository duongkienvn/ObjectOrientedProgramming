package hus.oop.lab1;

import java.util.Scanner;

public class ArrayHomework {
    public static void printArrayStars(Scanner in) {
        final int NUM_ITEMS;
        int items[];

        System.out.print("Enter the number of items: ");
        NUM_ITEMS = in.nextInt();
        items = new int[NUM_ITEMS];
        System.out.print("Enter the value of all items (separated by space): ");
        for (int i = 0; i < NUM_ITEMS; i++) {
            items[i] = in.nextInt();
        }
        for (int i = 0; i < NUM_ITEMS; i++) {
            System.out.print(i + ": ");
            for (int starNo = 0; starNo < items[i]; starNo++) {
                System.out.print("*");
            }
            System.out.println("(" + items[i] + ")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printArrayStars(sc);
    }

}
