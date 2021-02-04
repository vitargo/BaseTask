package com.github.randomizer;

import java.util.Scanner;

public class ScannerWrapper {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getNumber() {
        return SCANNER.nextInt();
    }

    public static String getCommand() {
        return SCANNER.next();
    }
}
