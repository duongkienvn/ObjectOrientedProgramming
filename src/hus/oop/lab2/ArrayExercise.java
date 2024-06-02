package hus.oop.lab2;

import java.util.Scanner;

public class ArrayExercise {
    public static int[] createArray(Scanner in){
        final int NUM_ITEMS;
        int items[];
        System.out.print("Enter the number of items: ");
        NUM_ITEMS = in.nextInt();
        items = new int[NUM_ITEMS];

        if(items.length > 0){
            System.out.print("Enter the value of all items (separate by space): ");
            for(int i = 0; i < NUM_ITEMS; i++){
                items[i] = in.nextInt();
            }
        }
        return items;
    }
    public static void printArray(int[] arr){
        System.out.print("The value are: ");
        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                System.out.print("[" + arr[i]);
            }
            else{
                System.out.print(", " + arr[i]);
            }
        }
        System.out.print("]");
    }
    public static int[] generateStudentGrades(Scanner in){
        System.out.print("Enter the number of students: ");
        int numStudents = in.nextInt();
        int gradeStudents[] = new int[numStudents];
        for(int i = 0; i < gradeStudents.length; i++){
            int tmp = i + 1;
            System.out.print("Enter the grade for student " + tmp + ": ");
            gradeStudents[i] = in.nextInt();
        }
        return gradeStudents;
    }
    public static void simpleGradesStatistics(int gradeStudents[]){
        int minGrade = Integer.MAX_VALUE;
        int maxGrade = Integer.MIN_VALUE;
        int sumGrades = 0;
        double average = 0;
        for(int i = 0; i < gradeStudents.length; i++){
            sumGrades += gradeStudents[i];
            if(minGrade > gradeStudents[i]){
                minGrade = gradeStudents[i];
            }
            if(maxGrade < gradeStudents[i]){
                maxGrade = gradeStudents[i];
            }
        }
        System.out.printf("The average is: %.2f\n", (double) sumGrades / gradeStudents.length);
        System.out.println("The maximum is: " + maxGrade);
        System.out.println("The minimum is: " + minGrade);
    }
    public static String hexadecimalToBinary(String hexStr){
        hexStr = hexStr.toUpperCase();
        int hexStrLength = hexStr.length();
        final String HEX_BITS[] = {"0000", "0001", "0010", "0011",
                "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011",
                "1100", "1101", "1110", "1111"};
        String result = "";
        for(int i = 0; i < hexStrLength; i++){
            char currentChar = hexStr.charAt(i);
            if(currentChar >= 'A' && currentChar <= 'F'){
                result += HEX_BITS[currentChar - 'A' + 10] + " ";
            }
            else{
                result += HEX_BITS[currentChar - '0'] + " ";
            }
        }
        return result;
    }
    public static void testHexadecimalToBinary(Scanner sc){
        System.out.print("Enter a Hexadecimal string ");
        String hexStr = sc.nextLine();
        System.out.println("The equivalent binary for hexadecimal " + hexStr + " is: " + hexadecimalToBinary(hexStr));
    }
    public static String reverseString(String inStr){
        int intStrlen = inStr.length();
        String result = "";
        for(int charIdx = intStrlen - 1; charIdx >= 0; charIdx--){
            result += inStr.charAt(charIdx);
        }
        return result;
    }
    public static String decimalToHexadecimal(int positiveInteger){
        String result = "";
        while(positiveInteger != 0){
            boolean check = false;
            int r = positiveInteger % 16;
            switch (r){
                case 10:
                    result += "A";
                    check = true;
                    break;
                case 11:
                    result += "B";
                    check = true;
                    break;
                case 12:
                    result += "C";
                    check = true;
                    break;
                case 13:
                    result += "D";
                    check = true;
                    break;
                case 14:
                    result += "E";
                    check = true;
                    break;
                case 15:
                    result += "F";
                    check = true;
                    break;
            }
            if(!check) result += r;
            positiveInteger /= 16;
        }
        return reverseString(result);
    }
    public static void testDecimalToHexadecimal(Scanner sc){
        System.out.print("Enter a decimal number ");
        int positiveInteger = sc.nextInt();
        System.out.println("The equivalent hexadecimal number is " + decimalToHexadecimal(positiveInteger));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int items[] = createArray(sc);
        printArray(items);

        int gradeStudents[] = generateStudentGrades(sc);
        simpleGradesStatistics(gradeStudents);
        testHexadecimalToBinary(sc);
        testDecimalToHexadecimal(sc);

    }
}
