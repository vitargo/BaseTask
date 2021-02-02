package com.github.basetask.conditionaloperators;
import java.util.Scanner;

public class ConditionalOperatorsTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number a");
        int a = scan.nextInt();
        System.out.println("Enter the number b");
        int b = scan.nextInt();

        System.out.println("Result is " + multipleResult(a, b));
    }

    public static int multipleResult(int a, int b) {
        int c;
        if(a % 2 == 0){
            c = a * b;
        } else {
            c = a + b;
        }
        return c;
    }
}
