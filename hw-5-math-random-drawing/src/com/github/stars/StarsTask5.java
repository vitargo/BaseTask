package com.github.stars;

public class StarsTask5 {
    public static void main(String[] args) {
        for(int i = 0; i < 6; i++){
            for (int sp1 = 6; sp1 > i; sp1--) {
                System.out.print(" ");
             }
            if(i > 0) {
                System.out.print("*");
            }
            for (int sp2 = 1; sp2 < i; sp2++){
                System.out.print(" ");
            }
            System.out.print("*\n");
        }
        for (int j = 0; j < 7; j++) {
            System.out.print("*");
        }
    }
}
