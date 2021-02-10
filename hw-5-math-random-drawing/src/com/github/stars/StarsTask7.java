package com.github.stars;

public class StarsTask7 {
    public static void main(String[] args) {
        int raw = 7;
        for (int i = 0; i < raw; i++) {
            if (i < raw/2+1) {
                for (int sp1 = 0; sp1 < i; sp1++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                if (i == raw/2) {
                    System.out.print("\n");
                }
                for (int sp2 = raw/2; sp2 > i; sp2--) {
                    System.out.print(" ");
                }
                if(raw%2==0) {
                    for (int p = raw - 1; p > raw / 2 + i; p--) {
                        System.out.print(" ");
                    }
                }else {
                    for(int p = raw-2; p > raw/2+i; p--) {
                        System.out.print(" ");
                    }
                }
                if (i != raw/2) {
                    System.out.print("*\n");
                }
            } else {
                for (int sp1 = raw/2-1; sp1 > i - ((raw/2)+1); sp1--) {
                    System.out.print(" ");
                }
                System.out.print("*");

                for (int sp2 = 0; sp2 < i - raw/2; sp2++) {
                    System.out.print(" ");
                }
                if(i > raw/2+1){
                    for(int k = raw/2+1; k < i; k++){
                        System.out.print(" ");
                    }
                }
                System.out.print("*\n");
            }
        }
    }
}
