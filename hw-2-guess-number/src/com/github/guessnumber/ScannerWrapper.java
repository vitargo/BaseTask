package com.github.guessnumber;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerWrapper {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getNumber() {
        return SCANNER.nextInt();
    }
    public static String callScan() {
        return SCANNER.next();
    }
    public static boolean getExit() {
        return SCANNER.hasNext("exit");
    }

    public static boolean check() {
        return SCANNER.hasNextInt();
    }

}
