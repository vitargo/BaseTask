package com.github.seasons;

public class ValidateDialog {

    static int month;
    public static void validateDialog(){
        do{
            System.out.println("Enter a month number: ");
            month = ScannerWrapper.getNumber();
        } while (month < 1 || month > 12);
    }

}
