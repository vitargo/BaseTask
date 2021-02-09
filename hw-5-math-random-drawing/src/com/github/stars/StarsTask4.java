package com.github.stars;

public class StarsTask4 {
    public static void main(String[] args) {
        System.out.print("*\n");
        for (int i = 5; i > 0; i--) {
            System.out.print("*");
            for (int sp = 5; sp > i; sp--) {
                System.out.print(" ");
            }
            System.out.print("*\n");
        }
        for (int j = 0; j < 7; j++) {
            System.out.print("*");
        }
    }
}

