package hus.oop.lab1;

import java.util.Scanner;

public class StringAndCharacterHomework {
    static Scanner sc = new Scanner(System.in);
    public static String exchangeCipher(String inStr){
        String result = "";
        inStr = inStr.toUpperCase();
        for(int charInStr = 0; charInStr < inStr.length(); charInStr++){
            char currentChar = inStr.charAt(charInStr);
            int ascii = currentChar - 'A';
            char newChar = (char) ('A' + (25 - ascii));
            result += newChar;
        }
        return result;
    }
    public static void testExchangeCipher(){
        System.out.print("Enter the plaintext string: ");
        String plaintext = sc.nextLine();
        System.out.println("The ciphertext string is: "
                + exchangeCipher(plaintext));
    }
    public static boolean isPalindromicWord(String inStr){
        inStr = inStr.toLowerCase();
        int len = inStr.length();
        int left = 0, right = len - 1;
        while(left < right){
            if(inStr.charAt(left) != inStr.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public static void testPalindromicWord(){
        System.out.print("Enter the word: ");
        String word = sc.nextLine();
        if(isPalindromicWord(word)){
            System.out.println("xxx");
        }
        else{
            System.out.println("|");
        }
    }
    public static boolean isPalindromicPhrase(String inStr){
        inStr = inStr.toLowerCase();
        inStr = inStr.replaceAll("[,\\.\\s\\!\\?\\-\\']+", "");
        int len = inStr.length();
        int left = 0, right = len - 1;
        while (left < right){
            if(inStr.charAt(left) != inStr.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public static void testPalindromicPhrase(){
        System.out.print("Enter the phrase: ");
        String phrase = sc.nextLine();
        if(isPalindromicPhrase(phrase)){
            System.out.println("xxx");
        }
        else{
            System.out.println("|");
        }
    }
    public static void main(String[] args) {
        testExchangeCipher();
        testPalindromicWord();
        testPalindromicPhrase();
    }
}
