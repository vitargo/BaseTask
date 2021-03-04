package com.github.samename;

import java.util.Scanner;

public class ScannerWrapper {
    private static final Scanner SCANNER = new Scanner (System.in);

    public static String getString(){
        return SCANNER.next();
    }


}
