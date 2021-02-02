package com.github.basetask.loops;

import java.util.Scanner;

public class LoopsTask5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scan.nextInt();
        number = Math.abs(number);
        System.out.println("Sum of the number's digits is " + sumNumberDigits(number));
    }
    public static int sumNumberDigits(int number){
        int sum = 0;
        while(number > 0){
            int i = number%10;
            sum = sum + i;
            number = number/10;

            if(number == 0){
                break;
            }
        }
        return sum;
    }
}
