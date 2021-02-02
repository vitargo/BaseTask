package com.github.basetask.conditionaloperators;

import java.util.Scanner;

public class ConditionalOperatorsTask4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number a");
        int a = scan.nextInt();
        System.out.println("Enter the number b");
        int b = scan.nextInt();
        System.out.println("Enter the number c");
        int c = scan.nextInt();

        System.out.println(maxSumOrMulti(a, b, c) + 3);
    }

    public static int maxSumOrMulti(int a, int b, int c){
        int d = a * b * c;
        int e = a + b + c;
        return Math.max(d, e);
    }
}
