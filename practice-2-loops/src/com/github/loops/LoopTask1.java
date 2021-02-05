package com.github.loops;

public class LoopTask1 {
    public static void main(String[] args) {
        int a = 0;
        int b = -10;
        System.out.println("Print with whileLoop method: ");
        whileLoop(a,b);

        System.out.println("Print with forLoop method: ");
        forLoop(a, b);
    }

    public static void whileLoop(int a, int b){
        int i = a;
        while(i > b-1){
            System.out.println(i);
            i--;
        }
    }

    public static void forLoop(int a, int b){
        int i;
        for(i = a; i > b-1; i--){
            System.out.println(i);
        }
    }
}
