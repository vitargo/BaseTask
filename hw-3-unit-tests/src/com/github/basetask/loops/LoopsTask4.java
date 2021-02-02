package com.github.basetask.loops;

import java.util.Scanner;

public class LoopsTask4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scan.nextInt();

        System.out.println("Factorial of a number is " + factorialFunc(number));
    }
    public static long factorialFunc(int number){
        long f = 1L;
        for(int i = 1; i <= number; i++){
            f = f * i;
        }
        return f;
    }
}
