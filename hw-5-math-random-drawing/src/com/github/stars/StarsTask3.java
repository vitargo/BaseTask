package com.github.stars;

public class StarsTask3 {
    public static void main(String[] args) {
        for (int j = 0; j < 7; j++) {
            System.out.print("*");
        }
        System.out.print("\n");
        for (int i = 0; i < 5; i++) {
            System.out.print("*");
            for (int sp = i; sp < 5; sp++) {
                System.out.print(" ");
            }
            System.out.print("*\n");
        }
        System.out.print("*");

    }
}
