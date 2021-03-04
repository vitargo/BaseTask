package com.github.samename;

public class ValidateDialog {

    static String name1 = null;
    static String name2 = null;

    public static void validateDialog(){
        System.out.println("Enter a first name: ");
        name1 = ScannerWrapper.getString();
        System.out.println("Enter a second name: ");
        name2 = ScannerWrapper.getString();
    }

}
