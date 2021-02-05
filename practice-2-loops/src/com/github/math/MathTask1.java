package com.github.math;

import java.util.Scanner;

public class MathTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scan.nextInt();
        System.out.println("The sum of number's digits is " + sumOfDigits(number));
        System.out.println("The result of multiplication of digits is " + multiplyOfDigits(number));
        System.out.println("The biggest digit is " + bigestNumber(number));
    }

    public static int sumOfDigits(int number){
        int sum = 0;
        while(number%10 != 0){
            sum = sum + (number%10);
            number = number/10;
        }
        return sum;
    }

    public static int multiplyOfDigits(int number){
        int result = 0;
        while(number%10 != 0){
            result = result + (number%10);
            number = number/10;
        }
        return result;
    }

    public static int bigestNumber(int number){
        int big = 0;
        while(number%10 != 0){
            if(big < (number%10)){
                big = number%10;
            }
            number = number/10;
        }
        return big;
    }
}
