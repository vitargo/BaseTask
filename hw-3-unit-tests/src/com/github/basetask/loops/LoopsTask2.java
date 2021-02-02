package com.github.basetask.loops;

import java.util.Scanner;

public class LoopsTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number;
        do {
            System.out.print("Enter a number: ");
            number = scan.nextInt();
        } while (number < 1);
        if (number == 1) {
            System.out.println("Number is a simple.");
            return;
        }
        if (simpleNumber(number)) {
            System.out.println("Number isn't a simple.");
        } else {
            System.out.println("Number is a simple.");
        }
    }
    public static boolean simpleNumber(int number){
        boolean m = false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                m = true;
                break;
            }
        }
        return m;
    }
}
