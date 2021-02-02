package com.github.basetask.methods;

import java.util.Scanner;

public class MethodsTask1 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number of the day of the week: ");
        int day = scan.nextInt();
        if(day < 0 || day > 7) {
            System.out.println("Wrong number of the day of the week.");
        } else {
            System.out.println(dayName(day));
        }
    }

    public static String dayName(int day) {
    String dayWeek = null;
        switch(day){
            case 1:
                dayWeek = "Monday";
                break;
            case 2:
                dayWeek = "Tuesday";
                break;
            case 3:
                dayWeek = "Wednesday";
                break;
            case 4:
                dayWeek = "Thursday";
                break;
            case 5:
                dayWeek = "Friday";
                break;
            case 6:
                dayWeek = "Saturday";
                break;
            case 7:
                dayWeek = "Sunday";
                break;
        }
        return dayWeek;
    }
}
