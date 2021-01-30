package com.github.discriminant;

public class DiscriminantDialog {
    static int a;
    static int b;
    static int c;

    static void discriminantDialog(){

        System.out.println("Enter a: ");
        a = ScannerWrapper.getNumber();
        System.out.println("Enter b: ");
        b = ScannerWrapper.getNumber();
        System.out.println("Enter c: ");
        c = ScannerWrapper.getNumber();
    }
}
