package com.github.stars;

public class StarsTask9 {
    public static void main(String[] args) {

        int raw = 7;

        for (int i = 0; i < raw-1; i++) {
            if (i < raw/2) {
                System.out.print("\n");
            } else {
                for (int sp1 = raw-1; sp1 > i; sp1--) {
                    System.out.print(" ");
                }
                System.out.print("*");
                if (i == raw/2) {
                    System.out.print("\n");
                }
                for (int sp2 = raw/2; sp2 < i; sp2++) {
                    System.out.print(" ");
                }
                if(i > raw/2+1){
                    for(int k = raw/2+1; k < i; k++){
                        System.out.print(" ");
                    }
                }
                if (i > raw/2) {
                    System.out.print("*\n");
                }
            }
        }
        for (int j = 0; j < raw; j++) {
            System.out.print("*");
        }
    }
}
