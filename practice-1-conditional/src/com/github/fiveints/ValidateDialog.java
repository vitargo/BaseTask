package com.github.fiveints;

public class ValidateDialog {

    static int[] fiveints = new int[5];
    public static void validateDialog(){
        int a;
        int count = 0;
        do{
            System.out.println("Enter a number: ");
            a = ScannerWrapper.getNumber();
            fiveints[count] = a;
            count++;
        } while (count < fiveints.length);
    }

}
