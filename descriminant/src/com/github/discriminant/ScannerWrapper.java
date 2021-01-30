package com.github.discriminant;

import java.util.Scanner;

public class ScannerWrapper {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getNumber() {
        return SCANNER.nextInt();
    }
}
