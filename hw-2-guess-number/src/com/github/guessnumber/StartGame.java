package com.github.guessnumber;

import java.util.Scanner;

public class StartGame {

    public static void game(int min, int max, int attempt) {
        int tryNumber = 0;
        int count = 0;
        int priorAttempt = 0;
        int guessNumber = RandomNumber.getRandomNumberInRange(min, max);
        System.out.println("Hi, I am guessing a number from " + min + " to " + max + ". Try to guess it in " + attempt + " tries! ");
        System.out.println();

        do {
            System.out.println("Enter a number and press Enter: ");
            do {
            while (!ScannerWrapper.check()) {
                if (ScannerWrapper.getExit()) {
                    System.exit(0);
                }
                System.out.println("Please, enter a number.");
                ScannerWrapper.callScan();
            }
            tryNumber = ScannerWrapper.getNumber();
            if (tryNumber> max || tryNumber < min){
                System.out.println("Please, enter a number within a range.");
            }
        } while (tryNumber > max || tryNumber < min);

            count++;
            if (tryNumber == guessNumber) {
                if (count == 1) {
                    System.out.println("Congratulations! You guess the number оn " + count + " attempt.");
                    System.out.println();
                } else {
                    System.out.println("Congratulations! You guess the number оn " + count + " attempts.");
                    System.out.println();
                }
            System.exit(0);
            }
            if (count != 1) {
                if (tryNumber - guessNumber >= priorAttempt - guessNumber) {
                    System.out.println("Guessed wrong, but closer!!! You have " + (attempt - count) + " attempt(s).");
                    System.out.println();
                } else {
                    System.out.println("Guessed wrong, but further!!! You have " + (attempt - count) + " attempt(s).");
                    System.out.println();
                }
            }
            priorAttempt = tryNumber;
        } while (count != attempt);

        System.exit(0);
    }
}

