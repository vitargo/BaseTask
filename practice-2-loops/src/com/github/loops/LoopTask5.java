package com.github.loops;

public class LoopTask5 {
    public static void main(String[] args) {
        int a = 1;
        int b = 100;
        System.out.println("Print numbers are multiples of the numbers 3 and 5 with whileLoop method : ");
        whileLoop(a,b);

        System.out.println("Print numbers are multiples of the numbers 3 and 5 with forLoop method: ");
        forLoop(a, b);
    }

    public static void whileLoop(int a, int b){
        int i = a;
        while(i < b+1){
            if((i%3 == 0) || (i%5 == 0)) {
                System.out.println(i);
            }
            i++;
        }
    }

    public static void forLoop(int a, int b){
        int i;
        for(i = a; i < b+1; i++){
            if((i%3 == 0) || (i%5 == 0)) {
                System.out.println(i);
            }
        }
    }
}
