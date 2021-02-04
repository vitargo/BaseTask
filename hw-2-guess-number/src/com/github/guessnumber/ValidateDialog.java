package com.github.guessnumber;

public class ValidateDialog {
    static int min;
    static int max;
    static int attempt;

    public static void validateDialog (){
        do {
            System.out.println("Enter a minimal value of a range (inclusive): ");
            while (!ScannerWrapper.check()) {
                System.out.println("Please, enter a number, not text.");
                ScannerWrapper.callScan();
                if (ScannerWrapper.getExit()) {
                    System.exit(0);
                }
            }
            min = ScannerWrapper.getNumber();
        } while(min < 1 || min > 201);

        do {
            System.out.println("Enter a maximal value of a range (exclusive): ");
            while (!ScannerWrapper.check()) {
                System.out.println("Please, enter a number, not a text.");
                ScannerWrapper.callScan();
                if (ScannerWrapper.getExit()) {
                    System.exit(0);
                }
            }
            max = ScannerWrapper.getNumber();
        } while(max < min || max > 201);

        do {
            System.out.println("Enter a number of tries: ");
            while (!ScannerWrapper.check()) {
                System.out.println("Please, enter a number, not a text.");
                ScannerWrapper.callScan();
                if (ScannerWrapper.getExit()) {
                    System.exit(0);
                }
            }
            attempt = ScannerWrapper.getNumber();
            if(attempt > (max-min) && attempt < 15){
                System.out.println("Number of attempts exceeding range.");
            }
        } while(attempt < 1 || attempt > 15 || attempt > (max-min));
    }
}
