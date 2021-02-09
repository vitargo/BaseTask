package com.github.stars;

public class StarsTask8 {
    public static void main(String[] args) {
        int raw = 7;
        for (int j = 0; j < raw; j++) {
            System.out.print("*");
        }
        System.out.print("\n");
        for (int i = 0; i < raw-1; i++) {
            if (i < raw/2) {
                for (int sp1 = 0; sp1 < i + 1; sp1++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                if (i == raw/2-1) {
                    System.out.print("\n");
                }
                for (int sp2 = raw/2-1; sp2 > i; sp2--) {
                    System.out.print(" ");
                }
                for(int k = raw-3; k > raw/2+i; k--){
                    System.out.print(" ");
                }
                if (i != raw/2 - 1) {
                    System.out.print("*\n");
                }
            } else {
                System.out.print("\n");
            }
        }
    }
}
