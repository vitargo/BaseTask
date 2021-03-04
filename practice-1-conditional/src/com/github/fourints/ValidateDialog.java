package com.github.fourints;

public class ValidateDialog {

    static int[] fourints = new int[4];
    public static void validateDialog(){
        int a;
        int count = 0;
        do{
            System.out.println("Enter a number: ");
            a = ScannerWrapper.getNumber();
            fourints[count] = a;
            count++;
        }while (count < fourints.length);
    }

}
