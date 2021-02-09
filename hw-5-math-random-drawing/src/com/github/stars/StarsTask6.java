package com.github.stars;

public class StarsTask6 {
    public static void main(String[] args) {
        for (int j = 0; j < 7; j++) {
            System.out.print("*");
        }
        System.out.print("\n");
        for(int i = 1; i < 7; i++){
            for (int sp1 = 0; sp1 < i; sp1++) {
                System.out.print(" ");
            }
            if(i < 6) {
                System.out.print("*");
            }
            for (int sp2 = i; sp2 < 5; sp2++){
                System.out.print(" ");
            }
            System.out.print("*\n");
        }

    }
}
