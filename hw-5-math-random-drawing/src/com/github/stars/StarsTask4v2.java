package com.github.stars;

public class StarsTask4v2 {
    public static void main(String[] args) {
        int raw = 7;
        for(int i = 0; i < raw; i++){
            for(int j = 0; j < raw; j ++){
                if(i == i + j || i == raw - 1 || i == j){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
