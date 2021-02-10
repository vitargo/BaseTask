package com.github.stars;

public class StarsTask1 {
    public static void main(String[] args) {
        int raw = 7;
        for(int i = 0; i < raw; i++){
            for(int j = 0; j < raw; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
