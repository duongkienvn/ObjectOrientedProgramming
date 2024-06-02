package hus.oop.lab1;

import java.util.Scanner;

public class NestedLoopsExercise {
    static Scanner sc = new Scanner(System.in);
    public static void squarePattern(int n){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }
    public static void testSquarePattern(){
        System.out.print("Enter the size: ");
        int size = sc.nextInt();
        while (size <= 0){
            System.out.println("Please enter a positive integer!");
            System.out.print("Enter the size: ");
            size = sc.nextInt();
        }
        squarePattern(size);
    }
    public static void checkerPattern(int n){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(row % 2 == 1){
                    if(col == 0) System.out.print(" ");
                    else System.out.print("# ");
                }
                else{
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }
    public static void testCheckerPattern(){
        System.out.print("Enter the size: ");
        int size = sc.nextInt();
        while (size <= 0){
            System.out.println("Please enter a positive integer!");
            System.out.print("Enter the size: ");
            size = sc.nextInt();
        }
        checkerPattern(size);
    }

    public static void timeTable(int n){
       for(int row = 0; row <= n; row++){
           for(int col = 0; col <= n; col++){
               if(row == 0 && col == 0){
                   System.out.printf("%2c |", '*');
               }
               if(row == 0){
                   for(int column1 = 1; column1 <= n; column1++){
                       System.out.printf("%4d", column1);
                   }
                   System.out.println();
                   for(int idx = 0; idx < 4 * n + 4; idx++){
                       System.out.print("-");
                   }
                   break;
               }
               else{
                   System.out.printf("%2d |", row);
                   for(int column2 = 1; column2 <= n; column2++){
                       System.out.printf("%4d", row * column2);
                   }
                   break;
               }
           }
           System.out.println();
       }
    }
    public static void testTimeTable(){
        System.out.print("Enter the size: ");
        int size = sc.nextInt();
        while (size <= 0){
            System.out.println("Please enter a positive integer!");
            System.out.print("Enter the size: ");
            size = sc.nextInt();
        }
        timeTable(size);
    }
    public static void triangularPatternA(int n){
        for(int row = 0; row < n; row++){
            for(int col = 0; col <= row; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void triangularPatternB(int n){
        for(int row = n - 1; row >= 0; row--){
            for(int col = 0; col <= row; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void triangularPatternC(int n){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < row; col++){
                System.out.print("  ");
            }
            for(int col = row; col < n; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void triangularPatternD(int n){
        for(int row = 0; row < n; row++){
            for(int col = n - 1; col > row; col--){
                System.out.print("  ");
            }
            for(int col = 0; col <= row; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }
    public static void testTriangularPattern(){
        System.out.print("Enter the size: ");
        int size = sc.nextInt();
        while (size <= 0){
            System.out.println("Please enter a positive integer!");
            System.out.print("Enter the size: ");
            size = sc.nextInt();
        }
        triangularPatternA(size);
        triangularPatternB(size);
        triangularPatternC(size);
        triangularPatternD(size);
    }
    public static void boxPatternA(int n){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(row == 0 || row == n - 1){
                    System.out.print("# ");
                }
                else if(col == 0 || col == n - 1 ){
                    System.out.print("# ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void boxPatternB(int n){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(row == 0 || row == n - 1){
                    System.out.print("# ");
                }
                else if(row == col){
                    System.out.print("# ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void boxPatternC(int n){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(row == 0 || row == n - 1){
                    System.out.print("# ");
                }
                else if(row == n - col - 1){
                    System.out.print ("# ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void boxPatternD(int n){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(row == 0 || row == n - 1){
                    System.out.print("# ");
                }
                else if(row == col || row == n - col - 1){
                    System.out.print("# ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void testBoxPattern(){
        System.out.print("Enter the size: ");
        int size = sc.nextInt();
        while (size <= 0){
            System.out.println("Please enter a positive integer!");
            System.out.print("Enter the size: ");
            size = sc.nextInt();
        }
        boxPatternA(size);
        boxPatternB(size);
        boxPatternC(size);
        boxPatternD(size);
    }
    public static void hillPatternA(int n){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n - row - 1; col++){
                System.out.print("  ");
            }
            for(int col = 0; col < 2 * row + 1; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void hillPatternB(int n){
        for(int row = n - 1; row >= 0; row--){
            for(int col = 0; col < n - row -1; col++){
                System.out.print("  ");
            }
            for(int col = 0; col < 2 * row + 1; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void hillPatternC(int n){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n - row - 1; col++){
                System.out.print("  ");
            }
            for(int col = 0; col < 2 * row + 1; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
        for(int row = n - 2; row >= 0; row--){
            for(int col = 0; col < n - row - 1; col++){
                System.out.print("  ");
            }
            for(int col = 0; col < 2 * row + 1; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void hillPatternD(int n){
        for(int row = 1; row <= 2 * n - 1; row++){
            for(int col = 1; col <= 2 * n - 1; col++){
                if(row < n){
                    if(col > n - row + 1&& col < n + row - 1){
                        System.out.print("  ");
                    }
                    else{
                        System.out.print("# ");
                    }
                }
                else if(row == n){
                    if(col == 1 || col == 2 * n - 1){
                        System.out.print("# ");
                    }
                    else {
                        System.out.print("  ");
                    }
                }
                else{
                    if(col > row - n + 1 && col < 3 * n - row - 1){
                        System.out.print("  ");
                    }
                    else{
                        System.out.print("# ");
                    }
                }
            }
            System.out.println();
        }
    }
    public static void testHillPattern(){
        System.out.print("Enter the rows: ");
        int rows = sc.nextInt();
        while (rows <= 0){
            System.out.println("Please enter a positive integer!");
            System.out.print("Enter the size: ");
            rows = sc.nextInt();
        }
        hillPatternA(rows);
        hillPatternB(rows);
        hillPatternC(rows);
        hillPatternD(rows);
    }
    public static void main(String[] args) {
        testSquarePattern();
        testCheckerPattern();
        testTimeTable();
        testTriangularPattern();
        testBoxPattern();
        testHillPattern();
    }
}
