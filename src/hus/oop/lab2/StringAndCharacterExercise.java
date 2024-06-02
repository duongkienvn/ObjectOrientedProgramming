package hus.oop.lab2;

import java.util.Scanner;

public class StringAndCharacterExercise {
    static Scanner sc = new Scanner(System.in);
    public static String reverseString(String inStr){
        int intStrlen = inStr.length();
        String result = "";
        for(int charIdx = intStrlen - 1; charIdx >= 0; charIdx--){
            result += inStr.charAt(charIdx);
        }
        return result;
    }
    public static void testReverseString(){
        System.out.print("Enter a string: ");
        String inStr = sc.nextLine();
        System.out.println("The reverse of String " + inStr + " is " + reverseString(inStr));
    }
    public static int countVowels(String inStr){
        inStr = inStr.toLowerCase();
        int result = 0;
        int inStrLength = inStr.length();
        for(int charIdx = inStrLength - 1; charIdx >= 0; charIdx--) {
            char vowels = inStr.charAt(charIdx);
            if (vowels == 'u' || vowels == 'e' || vowels == 'o' || vowels == 'a' || vowels == 'i') {
                result++;
            }
        }
        return result;
    }
    public static int countDigits(String inStr){
        int result = 0;
        int inStrLength = inStr.length();
        for(int charIdx = inStrLength - 1; charIdx >= 0; charIdx--){
            char digit = inStr.charAt(charIdx);
            if(digit >= '0' && digit <= '9'){
                result++;
            }
        }
        return result;
    }
    public static double mathRound(double number){
        return Math.round(number * 100.0) / 100.0;
    }
    public static void testCountVowelsDigits(){
        System.out.print("Enter a String: ");
        String inStr = sc.nextLine();
        int inStrLength = inStr.length();
        System.out.println("Number of vowels: " + countVowels(inStr) +
                " (" + mathRound((double)countVowels(inStr) / inStrLength * 100) + "%)");
        System.out.println("Number of digits: " + countDigits(inStr) +
                " (" + mathRound((double)countDigits(inStr) / inStrLength * 100) + "%)");
    }
    public static String phoneKeyPad(String inStr){
        inStr = inStr.toLowerCase();
        String result = "";
        int inStrLength = inStr.length();
        for(int charIdx = 0; charIdx < inStrLength; charIdx++){
            char inChar = inStr.charAt(charIdx);
            switch (inChar){
                case 'a':
                case 'b':
                case 'c':
                    result += "2";
                    break;
                case 'd':
                case 'e':
                case 'f':
                    result += "3";
                    break;
                case 'g':
                case 'h':
                case 'i':
                    result += "4";
                    break;
                case 'j':
                case 'k':
                case 'l':
                    result += "5";
                    break;
                case 'm':
                case 'n':
                case 'o':
                    result += "6";
                    break;
                case 'p':
                case 'q':
                case 'r':
                case 's':
                    result += "7";
                    break;
                case 't':
                case 'u':
                case 'v':
                    result += "8";
                    break;
                default:
                    result += "9";
                    break;
            }
        }
        return result;
    }
    public static void testPhoneKeyPad(){
        System.out.print("Enter a String: ");
        String inStr = sc.nextLine();
        System.out.println("PhoneKeyPad of String " + inStr + " is " + phoneKeyPad(inStr));
    }
    public static String cipherCaesarCode(String inStr){
        inStr = inStr.toUpperCase();
        String result = "";
        int n = 3;
        int inStrLength = inStr.length();
        for(int charIdx = 0; charIdx < inStrLength; charIdx++){
            char currentChar = inStr.charAt(charIdx);
            int check = 0;
            switch (currentChar){
                case 'X':
                    currentChar = 'A';
                    check = 1;
                    break;
                case 'Y':
                    currentChar = 'B';
                    check = 1;
                    break;
                case 'Z':
                    currentChar = 'C';
                    check = 1;
                    break;
            }
            if(check == 0)
                result += (char) (currentChar + n);
            else
                result += currentChar;
        }
        return result;
    }
    public static void testCipherCaesarCode(){
        System.out.print("Enter a plain text string : ");
        String inStr = sc.nextLine();
        System.out.println("The cipher text string is " + cipherCaesarCode(inStr));
    }
    public static String decipherCaesarCode(String inStr){
        inStr = inStr.toUpperCase();
        String result = "";
        final int n = 3;
        int inStrLength = inStr.length();
        for(int charIdx = 0; charIdx < inStrLength; charIdx++){
            char currentChar = inStr.charAt(charIdx);
            boolean check = false;
            if(currentChar == 'A'){
                check = true;
                currentChar = 'X';
            }
            else if(currentChar == 'B'){
                check = true;
                currentChar = 'Y';
            }
            else if(currentChar == 'C'){
                check = true;
                currentChar = 'Z';
            }
            if(check) result += currentChar;
            else result += (char) (currentChar - n);
        }
        return result;
    }
    public static void testDecipherCaesarCode(){
        System.out.print("Enter a plain text string : ");
        String inStr = sc.nextLine();
        System.out.println("The decipher text string is " + decipherCaesarCode(inStr));
    }
    public static boolean isHexString(String hexStr){
        int hexStrLength = hexStr.length();
        hexStr = hexStr.toLowerCase();
        for(int charIdx = 0; charIdx < hexStrLength; charIdx++){
            char currentChar = hexStr.charAt(charIdx);
            if(currentChar < '0' || currentChar > '9' && currentChar < 'a' || currentChar > 'f'){
                return false;
            }
        }
        return true;

    }
    public static void testHexString(){
        System.out.print("Enter a hex string: ");
        String hexStr = sc.nextLine();
        if(isHexString(hexStr)){
            System.out.println(hexStr + " is a hex string");
        }
        else
            System.out.println(hexStr + " is NOT a hex string");
    }
    public static  int binaryToDecimal(String binStr){
        int result = 0;
        int binStrLength = binStr.length();
        int idx = 0;
        for(int i = binStrLength - 1; i >= 0; i--){
            char currentChar = binStr.charAt(i);
            result += (currentChar - '0') * Math.pow(2, idx);
            idx++;
        }
        return result;
    }
    public static boolean checkBinary(String binStr){
        int binStrLength = binStr.length();
        for(int i = 0; i < binStrLength; i++){
            if(binStr.charAt(i) > '1' || binStr.charAt(i) < '0'){
                return false;
            }
        }
        return true;
    }
    public static void testBinaryToDecimal(){
        System.out.print("Enter a Binary string: ");
        String binStr = sc.nextLine();
        if(checkBinary(binStr)){
            System.out.println("The equivalent decimal number for binary " +
                    binStr + " is: " + binaryToDecimal(binStr));
        }
        else{
            System.out.println("error: invalid binary string " + binStr);
        }
    }
    public static int hexadecimalToDecimal(String hexStr){
        hexStr = hexStr.toLowerCase();
        int hexStrLength = hexStr.length();
        int result = 0;
        int idx = 0;

        for(int i = hexStrLength - 1; i >= 0; i--){
            boolean check = false;
            int tmp = 0;
            char currentChar = hexStr.charAt(i);
            if(currentChar == 'a'){
                check = true;
                tmp = 10;
            }
            else if(currentChar == 'b'){
                check = true;
                tmp = 11;
            }
            else if(currentChar == 'c'){
                check = true;
                tmp = 12;
            }
            else if(currentChar == 'd'){
                check = true;
                tmp = 13;
            }
            else if(currentChar == 'e'){
                check = true;
                tmp = 14;
            }
            else if(currentChar == 'f'){
                check = true;
                tmp = 15;
            }
            if(check){
                result += tmp * Math.pow(16, idx);
                idx++;
            }
            else{
                result += (currentChar - '0') * Math.pow(16, idx);
                idx++;
            }
        }
        return result;
    }
    public static boolean checkHexadecimal(String hexStr){
        int hexStrLength = hexStr.length();
        for(int i = 0; i < hexStrLength; i++){
            char currentChar = hexStr.charAt(i);
            if(currentChar < '0' || currentChar > '9' && currentChar < 'a' || currentChar > 'f'){
                return false;
            }
        }
        return true;
    }
    public static void testHexadecimalToDecimal(){
        System.out.print("Enter a Hexadecimal string: ");
        String hexStr = sc.nextLine();
        if(checkHexadecimal(hexStr)){
            System.out.println("The equivalent decimal number for hexadecimal "
                    + hexStr + " is: " + hexadecimalToDecimal(hexStr));
        }
        else{
            System.out.println("error: invalid hexadecimal string " + hexStr);
        }
    }
    public static boolean isValidOctal(String octalStr){
        for(char c: octalStr.toCharArray()){
            if(c < '0' || c > '7'){
                return false;
            }
        }
        return true;
    }
    public static int octalToDecimal(String octalStr){
        int octalStrLength = octalStr.length();
        int decimal = 0;
        for(int i = 0; i < octalStrLength; i++){
            int digit = octalStr.charAt(i) - '0';
            decimal = decimal * 8 + digit;
        }
        return decimal;
    }
    public static void testOctalToDecimal(){
        System.out.print("Enter an Octal string: ");
        String octalStr = sc.nextLine();
        if(isValidOctal(octalStr)){
            System.out.println("The equivalent decimal number " + octalStr + " is: " + octalToDecimal(octalStr));
        }
        else{
            System.out.println("error: invalid octal string" + octalStr);
        }
    }
    public static int radixNToDecimal(String radixNStr, int radix){
        int decimal = 0;
        int radixNStrLength = radixNStr.length();
        for(int i = 0; i < radixNStrLength; i++){
            char c = radixNStr.charAt(i);
            int digit;
            if(Character.isDigit(c)){
                digit = c - '0';
            }
            else{
                digit = Character.toUpperCase(c) - 'A' + 10;
            }
            decimal += digit * Math.pow(radix, radixNStrLength - i - 1);
        }
        return decimal;
    }
    public static void testRadixNToDecimal(){
        System.out.print("Enter the radix ");
        int radix = sc.nextInt();
        System.out.print("Enter the string ");
        sc.nextLine();
        String str = sc.nextLine();
        System.out.println("Enter the string " + str + " is: " + radixNToDecimal(str, radix));
    }

    public static void main(String[] args) {
        testReverseString();
        testCountVowelsDigits();
        testPhoneKeyPad();
        testCipherCaesarCode();
        testDecipherCaesarCode();
        testHexString();
        testBinaryToDecimal();
        testHexadecimalToDecimal();
        testOctalToDecimal();
        testRadixNToDecimal();
    }
}
