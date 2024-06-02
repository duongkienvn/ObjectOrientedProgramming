package hus.oop.lab2;

import java.util.Arrays;
import java.util.Scanner;

public class MethodExercise {
    public static int exponent(int base, int exp){
        int product = 1;
        for(int i = 1; i <= exp; i++){
            product *= base;
        }
        return product;
    }
    public static void testExponent(Scanner sc){
        System.out.print("Enter the base: ");
        int base = sc.nextInt();
        System.out.print("Enter the exponent: ");
        int exp = sc.nextInt();
        System.out.println(base + " raises to the power of " + exp + " is: " + exponent(base, exp));
    }
    public static boolean hasEight(int number){
        while (number != 0){
            int r = number % 10;
            if(r == 8) return true;
            number /= 10;
        }
        return false;
    }
    public static int testMagicSum(Scanner in){
        final int SETINEL = -1;
        int number = 0;
        int sum = 0;
        while (number != SETINEL){
            System.out.print("Enter a positive integer ( or −1 to end ) : ");
            number = in.nextInt();
            if(hasEight(number)){
                sum += number;
            }
        }
        System.out.print("The magic sum is: ");
        return sum;
    }
    public static void print(int array[]){
        int arrLength = array.length;
        for(int i = 0; i < arrLength; i++){
            if(i == 0){
                System.out.print("[" + array[i]);
            }
            else{
                System.out.print(", " + array[i]);
            }
        }
        System.out.println("]");
    }
    public static void print(double array[]){
        int arrLength = array.length;
        for(int i = 0; i < arrLength; i++){
            if(i == 0){
                System.out.print("[" + array[i]);
            }
            else{
                System.out.print(", " + array[i]);
            }
        }
        System.out.print("]");
    }
    public static void print(float array[]){
        int arrLength = array.length;
        for(int i = 0; i < arrLength; i++){
            if(i == 0){
                System.out.print("[" + array[i]);
            }
            else{
                System.out.print(", " + array[i]);
            }
        }
        System.out.print("]");
    }
    public static void testPrint(Scanner sc){
        System.out.print("Enter the array length: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        //double arr[] = new double[n];
        //float arr[] = new float[n];
        for(int i = 0; i < n; i++){
            int idx = i + 1;
            System.out.print("Element " + idx + "th: ");
            arr[i] = sc.nextInt();
            //arr[i] = sc.nextDouble();
            //arr[i] = sc.nextFloat();
        }
        System.out.print("Array: ");
        print(arr);
    }
    public static String arrayToString(int array[]){
        int arrLength = array.length;
        String result = "";
        for(int i = 0; i < arrLength; i++){
            if(i == 0){
                result += "[" + array[i];
            }
            else{
                result += ", " + array[i];
            }
        }
        result += "]";
        return result;
    }
    public static void testArrayToString(Scanner sc){
        System.out.print("Enter the array length: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            int idx = i + 1;
            System.out.print("Element " + idx + "th: ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Array after converting into String: ");
        System.out.println(arrayToString(arr));
    }
    public static boolean contains(int array[], int key){
        int arrLength = array.length;
        int left = 0, right = arrLength - 1;
        Arrays.sort(array);
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(array[mid] == key)
                return true;
            else if(array[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
    public static void testContains(Scanner sc){
        System.out.print("Enter the array length: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            int idx = i + 1;
            System.out.print("Element " + idx + "th: ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the key: ");
        int key = sc.nextInt();
        if(contains(arr, key)){
            System.out.println(key + " contains in array");
        }
        else
            System.out.println(key + " doesn't contain in array");
    }
    public static int search(int array[], int key){
        int arrayLength = array.length;
        for(int i = 0; i < arrayLength; i++){
            if(array[i] == key)
                return i;
        }
        return -1;
    }
    public static void testSearch(Scanner sc){
        System.out.print("Enter the array length: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            int idx = i + 1;
            System.out.print("Element " + idx + "th: ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the key: ");
        int key = sc.nextInt();
        System.out.println("Index of key in array is: " + search(arr, key));
    }
    public static boolean equals(int array1[], int array2[]){
        int arr1Length = array1.length;
        int arr2Length = array2.length;
        if(arr1Length != arr2Length)
            return false;
        for(int i = 0; i < arr1Length; i++){
            if(array1[i] != array2[i])
                return false;
        }
        return true;
    }
    public static void testEquals(Scanner sc){
        System.out.print("Enter the array1 length: ");
        int arr1Length = sc.nextInt();
        int arr1[] = new int[arr1Length];
        for(int i = 0; i < arr1Length; i++){
            int idx = i + 1;
            System.out.print("Element " + idx + "th: ");
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter the array2 length: ");
        int arr2Length = sc.nextInt();
        int arr2[] = new int[arr2Length];
        for(int i = 0; i < arr2Length; i++){
            int idx = i + 1;
            System.out.print("Element " + idx + "th: ");
            arr2[i] = sc.nextInt();
        }
        if(equals(arr1, arr2)){
            System.out.println("arr1 equals arr2");
        }
        else
            System.out.println("arr1 is different from arr2");
    }
    public static int[] copyOf(int array[]){
        int arrCopy[] = new int[array.length];
        for(int i = 0; i < array.length; i++){
            arrCopy[i] = array[i];
        }
        return arrCopy;
    }
    public static void testArrayCopyOf(Scanner sc){
        System.out.print("Enter the array length: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            int idx = i + 1;
            System.out.print("Element " + idx + "th: ");
            arr[i] = sc.nextInt();
        }
        int arrCopy[] = copyOf(arr);
        System.out.print("Array copy is: ");
        print(arrCopy);
    }
    public static boolean swap(int array1[], int array2[]){
        if(array1.length != array2.length)
            return false;
        for(int i = 0; i < array1.length; i++){
            int tmp = array1[i];
            array1[i] = array2[i];
            array2[i] = tmp;
        }
        return true;
    }
    public static void testSwap(Scanner sc){
        System.out.print("Enter the array1 length: ");
        int arr1Length = sc.nextInt();
        int arr1[] = new int[arr1Length];
        for(int i = 0; i < arr1Length; i++){
            int idx = i + 1;
            System.out.print("Element " + idx + "th: ");
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter the array2 length: ");
        int arr2Length = sc.nextInt();
        int arr2[] = new int[arr2Length];
        for(int i = 0; i < arr2Length; i++){
            int idx = i + 1;
            System.out.print("Element " + idx + "th: ");
            arr2[i] = sc.nextInt();
        }
        if(swap(arr1, arr2)){
            System.out.println("After swapping:");
            System.out.print("Array 1: ");
            print(arr1);
            System.out.print("Array 2: ");
            print(arr2);
        }
        else{
            System.out.println("Arrays have different lengths, swapping failed.");
        }
    }
    public static void reverse(int array[]){
        int arrLength = array.length;
        int l = 0, r = arrLength - 1;
        while(l < r){
            int tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
            l++; r--;
        }
    }
    public static void testReverse(Scanner sc){
        System.out.print("Enter the array length: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            int idx = i + 1;
            System.out.print("Element " + idx + "th: ");
            arr[i] = sc.nextInt();
        }
        reverse(arr);
        System.out.print("Array after reversing is: ");
        print(arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testExponent(sc);
        System.out.println(testMagicSum(sc));
        testPrint(sc);
        testArrayToString(sc);
        testContains(sc);
        testSearch(sc);
        testEquals(sc);
        testArrayCopyOf(sc);
        testSwap(sc);
        testReverse(sc);

    }
}
