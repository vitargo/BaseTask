package com.github.basetask.methods;

import java.util.Scanner;

public class MethodsTask2 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int num;
        do {
            System.out.print("Enter a number from 0 till 999: ");
            num = scan.nextInt();
        } while(num < -1 && num > 1000);

        System.out.println(numAsText(num));
    }
    static String numAsText(int a){
        String[] belowTwentyArray = {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] tensArray = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        String[] hundredsArray = {"one hundred","two hundreds","three hundreds","four hundreds","five hundreds","six hundreds","seven hundreds","eight hundreds","nine hundreds"};

        int number;
        int tens;
        int tens2;
        int hundred;
        String name = null;

        if(a < 20){
            name = belowTwentyArray[a];
        } else if(a > 19 && a < 100){
            tens = a/10;
            number = a%10;
            if(number != 0){
                name = tensArray[tens-2] + " " + belowTwentyArray[number];
            } else {
                name = tensArray[tens-2];
            }
        } else if(a > 99 && a < 1000){
            hundred = a/100;
            tens = (a/10)%10;
            number = a%10;
            tens2 = a%100;
            if(tens == 0 && number == 0){
                name = hundredsArray[hundred-1];
            } else if(number == 0){
                name = hundredsArray[hundred-1] + " " + tensArray[tens-2];
            } else if(tens == 1){
                name = hundredsArray[hundred-1] + " " + belowTwentyArray[tens2];
            } else if(tens == 0){
                name = hundredsArray[hundred-1] + " " + belowTwentyArray[number];
            } else {
                name = hundredsArray[hundred-1] + " " + tensArray[tens-2] + " " + belowTwentyArray[number];
            }
        }
        return name;
    }
}
