package com.github.math;

import java.util.Arrays;
import java.util.Scanner;

public class MathTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter  number of amount of Fibonacci numbers: ");
        int size = scan.nextInt();
        int[] fibonacci = new int[size];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for(int i = 2; i < size; i++){
            fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
        }
        System.out.println("The Fibonacci sequence is " + Arrays.toString(fibonacci));
    }
}
