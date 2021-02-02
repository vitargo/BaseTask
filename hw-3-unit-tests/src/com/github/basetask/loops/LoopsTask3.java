package com.github.basetask.loops;

import java.util.Scanner;

public class LoopsTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number;
        do {
            System.out.print("Enter a valid number: ");
            number = scan.nextInt();
        } while (number < 0);

        System.out.println("Cube root to the nearest whole number is " + cubeResult(number));
    }

    public static int cubeResult(int number) {
        int a = 1;
        int b = number / 2;
        int c = 0;
        if (number == 0 || number == 1) {
            return number;
        }
        while (a <= b) {
            c = a + (b - a) / 2;
            if (c == number / c) {

                break;
            }
            if (c < number / c) {
                a = c + 1;
            } else {
                b = c - 1;
            }
        }
        return c;
    }
}


