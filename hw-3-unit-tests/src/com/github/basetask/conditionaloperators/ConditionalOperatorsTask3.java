package com.github.basetask.conditionaloperators;

import java.util.Scanner;

public class ConditionalOperatorsTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number a");
        int a = scan.nextInt();
        System.out.println("Enter the number b");
        int b = scan.nextInt();
        System.out.println("Enter the number c");
        int c = scan.nextInt();

        System.out.println ("The sum of the positive integers is " + sumPositiveInt(a, b, c));
    }

    public static int sumPositiveInt(int a, int b, int c){
        int d = 0;
        if(a > 0){
            d = d + a;
        }
        if(b > 0){
            d = d + b;
        }
        if(c > 0){
            d = d + c;
        }
        return d;
    }
}
