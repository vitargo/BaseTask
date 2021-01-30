package com.github.randomizer;

public class ValidateDialog {
    static int min;
    static int max;

    public static void validateDialog (){
        do {
            System.out.println("Enter a minimal value of a range (inclusive): ");
            min = ScannerWrapper.getNumber();

        } while(min < 1 || min > 501);

        do {
            System.out.println("Enter a maximal value of a range (exclusive): ");
            max = ScannerWrapper.getNumber();
        } while(max < min || max > 501);
    }
}
