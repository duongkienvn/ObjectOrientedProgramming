package hus.oop.lab3;

import java.util.Arrays;
import java.util.Scanner;

public class ExercisesOnAlgorithms_SortingAndSearching {
    static Scanner sc = new Scanner(System.in);

    public static boolean linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return true;
        }
        return false;
    }

    public static int linearSearchIndex(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    public static void testLinearSearch() {
        System.out.print("Enter the number of array: ");
        int numbers = sc.nextInt();
        int arr[] = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the key: ");
        int key = sc.nextInt();
        System.out.println(linearSearch(arr, key));
        System.out.println(linearSearchIndex(arr, key));

    }

    public static boolean binarySearch(int arr[], int key, int fromIdx, int toIdx) {
        Arrays.sort(arr);
        if (fromIdx > toIdx) {
            return false;
        }
        int mid = fromIdx + (toIdx - fromIdx) / 2;
        if (arr[mid] == key)
            return true;
        else if (arr[mid] < key)
            return binarySearch(arr, key, mid + 1, toIdx);
        else
            return binarySearch(arr, key, fromIdx, mid - 1);
    }

    public static boolean binarySearch(int arr[], int key) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key)
                return true;
            else if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public static void testBinarySearch() {
        System.out.print("Enter the number of array: ");
        int numbers = sc.nextInt();
        int arr[] = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the key: ");
        int key = sc.nextInt();
        System.out.println(binarySearch(arr, key));
        System.out.println(binarySearch(arr, key, 0, arr.length - 1));
    }

    public static void bubbleSort(int arr[]) {
        int arrLength = arr.length;
        for (int i = 0; i < arrLength - 1; i++) {
            for (int j = 0; j < arrLength - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int arr[]) {
        int arrLength = arr.length;
        for (int i = 0; i < arrLength - 1; i++) {
            int min_Idx = i;
            for (int j = i + 1; j < arrLength; j++) {
                if (arr[min_Idx] > arr[j]) {
                    min_Idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_Idx];
            arr[min_Idx] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        int arrLength = arr.length;
        for (int i = 1; i < arrLength; i++) {
            int key = arr[i];
            int idx = i - 1;
            while (idx >= 0 && key < arr[idx]) {
                arr[idx + 1] = arr[idx];
                idx--;
            }
            arr[idx + 1] = key;
        }
    }

    public static void testBubbleSort() {
        System.out.print("Enter the number of array: ");
        int numbers = sc.nextInt();
        int arr[] = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            arr[i] = sc.nextInt();
        }
        bubbleSort(arr);
        System.out.println("Array aftering sorting:");
        for (int idx : arr) {
            System.out.print(idx + " ");
        }
        System.out.println();
    }

    public static void testSelectionSort() {
        System.out.print("Enter the number of array: ");
        int numbers = sc.nextInt();
        int arr[] = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        System.out.println("Array aftering sorting:");
        for (int idx : arr) {
            System.out.print(idx + " ");
        }
        System.out.println();
    }

    public static void testInsertionSort() {
        System.out.print("Enter the number of array: ");
        int numbers = sc.nextInt();
        int arr[] = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            arr[i] = sc.nextInt();
        }
        insertionSort(arr);
        System.out.println("Array aftering sorting:");
        for (int idx : arr) {
            System.out.print(idx + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        testLinearSearch();
        testBinarySearch();
        testBubbleSort();
        testSelectionSort();
        testInsertionSort();

    }
}