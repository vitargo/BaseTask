package com.github.crud.view;

import com.github.crud.utils.CheckForExitSwitch;

import java.util.Scanner;

public class ScannerWrapper {

    static Scanner SCANNER;

    public static String getString() {
        SCANNER = new Scanner(System.in);
        String scan = SCANNER.nextLine();
        CheckForExitSwitch.checkForCommand(scan);
        return scan;
    }

    public static long getLong() {
        long parsedLong = 0;
        SCANNER = new Scanner(System.in);
        String scan = SCANNER.nextLine();
        CheckForExitSwitch.checkForCommand(scan);
        try {
            parsedLong = Long.parseLong(scan);
        } catch (NumberFormatException e) {
            System.out.println("Please enter value (number)!");
            parsedLong = getLong();
        }
        return parsedLong;
    }

    public static int getInt() {
        int parsedInt = 0;
        SCANNER = new Scanner(System.in);
        String scan = SCANNER.nextLine();
        CheckForExitSwitch.checkForCommand(scan);
        try {
            parsedInt = Integer.parseInt(scan);
        } catch (NumberFormatException e) {
            System.out.println("Please enter value (number)!");
            parsedInt = getInt();
        }
        return parsedInt;
    }

    public static String getNext() {
        SCANNER = new Scanner(System.in);
        String scan = SCANNER.nextLine();
        CheckForExitSwitch.checkForCommand(scan);
        return scan;
    }
}
