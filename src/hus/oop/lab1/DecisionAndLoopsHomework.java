package hus.oop.lab1;

import java.util.Random;
import java.util.Scanner;

public class DecisionAndLoopsHomework {
    public static void guessNumber() {
        Scanner sc = new Scanner(System.in);
        final int SECRET_NUMBER = (int) (Math.random() * 100);
        guessNumber(SECRET_NUMBER, sc);
    }

    public static void guessNumber(int number, Scanner sc) {
        System.out.println("Key in your guess: ");
        int key = sc.nextInt();
        int counntTrials = 1;
        while (key != number) {
            if (key > number) {
                System.out.println("Try lower ");
                key = sc.nextInt();
                counntTrials++;
            } else {
                System.out.println("Try higher ");
                key = sc.nextInt();
                counntTrials++;
            }
        }
        System.out.println("You got it in " + counntTrials + " trials!");
    }

    public static void guessWord() {
        Scanner sc = new Scanner(System.in);
        int maxLength = 10;
        Random random = new Random();
        String guessingString = "";
        char chars[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        while (guessingString.length() < maxLength) {
            char randomChar = chars[random.nextInt(chars.length)];
            guessingString += randomChar;
        }
        guessWord(guessingString, sc);
    }

    public static void guessWord(String guessedString, Scanner sc) {
        int countTrials = 0;
        System.out.print("Key in one character or your guess word: ");
        char chars[] = guessedString.toCharArray();
        String temp = "";
        for (int i = 0; i < guessedString.length(); i++) {
            temp += "_";
        }
        while (!temp.equals(guessedString)) {
            countTrials++;
            String key = sc.nextLine();
            if (key.length() == 1) {
                boolean check = false;
                System.out.print("Trials " + countTrials + ": ");
                for (int i = 0; i < chars.length; i++) {
                    if (String.valueOf(chars[i]).equals(key)) {
                        check = true;
                        temp = temp.substring(0, i) + key + temp.substring(i + 1);
                    }
                }
                if (check) {
                    System.out.println(temp);
                    System.out.print("Key in one character or your guess word: ");
                } else {
                    System.out.println(key + " you enter doesn't apear in the guessedString");
                    System.out.println("Try again!");
                    System.out.print("Key in one character or your guess word: ");
                }

            } else if (key.length() == guessedString.length()) {
                if (key.equals(guessedString)) {
                    temp = guessedString;
                } else {
                    System.out.println("Incorrect guess. Try again.");
                }
            } else {
                System.out.println("Please enter only one character or your guess word of the same length as the secret word.");
            }
        }
        System.out.println("Congratulation!");
        System.out.println("You got in " + countTrials + " trials");
    }

    public static void main(String[] args) {
        guessNumber();
        guessWord();
    }
}
