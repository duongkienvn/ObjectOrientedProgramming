package hus.oop.lab1;

import java.util.Scanner;

public class Matrix {
    static Scanner scanner = new Scanner(System.in);
    public static void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(double[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean haveSameDimension(int[][] arr1, int[][] arr2) {
        return (arr1.length == arr2.length && arr1[0].length == arr2[0].length);
    }

    public static boolean haveSameDimension(double[][] arr1, double[][] arr2) {
        return (arr1.length == arr2.length && arr1[0].length == arr2[0].length);
    }

    public static int[][] add(int[][] arr1, int[][] arr2) {
        if(!haveSameDimension(arr1, arr2)) return null;
        final int NUM_ROWS = arr1.length;
        final int NUM_COLS = arr1[0].length;

        int arr[][] = new int[NUM_ROWS][NUM_COLS];
        for(int i = 0; i < NUM_ROWS; i++) {
            for(int j = 0; j < NUM_COLS; j++) {
                arr[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return arr;
    }

    public static double[][] add(double[][] arr1, double[][] arr2) {
        if(!haveSameDimension(arr1, arr2)) return null;

        final int NUM_ROWS = arr1.length;
        final int NUM_COLS = arr1[0].length;

        double[][] arr = new double[NUM_ROWS][NUM_COLS];
        for(int i = 0; i < NUM_ROWS; i++) {
            for(int j = 0; j < NUM_COLS; j++) {
                arr[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return arr;
    }

    public static int[][] subtract(int[][] arr1, int[][] arr2) {
        if(!haveSameDimension(arr1, arr2)) return null;

        final int NUM_ROWS = arr1.length;
        final int NUM_COLS = arr1[0].length;

        int arr[][] = new int[NUM_ROWS][NUM_COLS];
        for(int i = 0; i < NUM_ROWS; i++) {
            for(int j = 0; j < NUM_COLS; j++) {
                arr[i][j] = arr1[i][j] - arr2[i][j];
            }
        }
        return arr;
    }

    public static double[][] subtract(double[][] arr1, double[][] arr2) {
        if(!haveSameDimension(arr1, arr2)) return null;

        final int NUM_ROWS = arr1.length;
        final int NUM_COLS = arr1[0].length;

        double arr[][] = new double[NUM_ROWS][NUM_COLS];
        for(int i = 0; i < NUM_ROWS; i++) {
            for(int j = 0; j < NUM_COLS; j++) {
                arr[i][j] = arr1[i][j] - arr2[i][j];
            }
        }
        return arr;
    }
    public static int[][] multiply(int arr1[][], int arr2[][]){
        if(!haveSameDimension(arr1, arr2)) return null;
        int numberRowArr1 = arr1.length;
        int numberColArr1 = arr1[0].length;
        int numberRowArr2 = arr2.length;
        int numberColArr2 = arr2[0].length;
        int multiplyArr[][] = new int[numberRowArr1][numberColArr2];
        for(int row = 0; row < numberRowArr1; row++){
            for(int col = 0; col < numberColArr2; col++){
                multiplyArr[row][col] = 0;
                for(int k = 0; k < numberColArr1; k++){
                    multiplyArr[row][col] += arr1[row][k] * arr2[k][col];
                }
            }
        }
        return multiplyArr;
    }
    public static double[][] multiply(double arr1[][], double arr2[][]){
        if(!haveSameDimension(arr1, arr2)) return null;
        int numberRowArr1 = arr1.length;
        int numberColArr1 = arr1[0].length;
        int numberRowArr2 = arr2.length;
        int numberColArr2 = arr2[0].length;
        double multiplyArr[][] = new double[numberRowArr1][numberColArr2];
        for(int row = 0; row < numberRowArr1; row++){
            for(int col = 0; col < numberColArr2; col++){
                multiplyArr[row][col] = 0;
                for(int k = 0; k < numberColArr1; k++){
                    multiplyArr[row][col] += arr1[row][k] * arr2[k][col];
                }
            }
        }
        return multiplyArr;
    }
    public static void testMatrix(){
        System.out.println("Nhập số hàng của ma trận 1:");
        int rows1 = scanner.nextInt();
        System.out.println("Nhập số cột của ma trận 1:");
        int cols1 = scanner.nextInt();
        int[][] matrix1 = new int[rows1][cols1];
        System.out.println("Nhập các phần tử của ma trận 1:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Nhập số hàng của ma trận 2:");
        int rows2 = scanner.nextInt();
        System.out.println("Nhập số cột của ma trận 2:");
        int cols2 = scanner.nextInt();
        int[][] matrix2 = new int[rows2][cols2];
        System.out.println("Nhập các phần tử của ma trận 2:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Ma trận 1:");
        print(matrix1);
        System.out.println("Ma trận 2:");
        print(matrix2);

        System.out.println("Tổng của hai ma trận:");
        int[][] sum = add(matrix1, matrix2);
        if (sum != null) {
            print(sum);
        } else {
            System.out.println("Không thể tính tổng vì kích thước của hai ma trận không khớp.");
        }

        System.out.println("Hiệu của hai ma trận:");
        int[][] difference = subtract(matrix1, matrix2);
        if (difference != null) {
            print(difference);
        } else {
            System.out.println("Không thể tính hiệu vì kích thước của hai ma trận không khớp.");
        }

        System.out.println("Tích của hai ma trận:");
        int[][] product = multiply(matrix1, matrix2);
        if (product != null) {
            print(product);
        } else {
            System.out.println("Không thể tính tích vì số cột của ma trận 1 không bằng số hàng của ma trận 2.");
        }
    }
    public static void main(String[] args) {
        testMatrix();
    }
}
