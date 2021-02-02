package com.github.basetask.conditionaloperators;

import java.util.Scanner;

public class ConditionalOperatorsTask5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the student's score:");
        int score = scan.nextInt();

        if(score < 0 || score > 100){
            System.out.println("Unacceptable student’s score");
        }

        System.out.println("Student’s result is " + studentResult(score));
    }
    public static String studentResult(int score){
        String result = null;
        if(score > -1 && score < 20){
            result = "F";
        } else if(score > 19 && score < 40){
            result = "E";
        } else if(score > 39 && score < 60){
            result = "D";
        } else if(score > 59 && score < 75){
            result = "C";
        } else if(score > 74 && score < 90){
            result = "B";
        } else if(score > 89 && score < 101) {
            result = "A";
        }
        return result;
    }
}
