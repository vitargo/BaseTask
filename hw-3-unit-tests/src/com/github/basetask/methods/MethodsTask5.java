package com.github.basetask.methods;

import java.util.Scanner;

public class MethodsTask5 {
    public static void main(String args[]){

        long max = 1000000000000L;

        Scanner scan = new Scanner(System.in);
        long num;
        do {
            System.out.println("Enter a number from 0 till 999 billions: ");
            num = scan.nextLong();
        } while(num < -1 && num > max);

        if(num > -1 && num < 1000){
            System.out.println(numAsText(num));
        } else if(num > 999 && num < 1000000){
            System.out.println(thousandAsText(num));
        } else if(num > 999999 && num < 1000000000){
            System.out.println(millionAsText(num));
        } else if(num > 999999999 && num < max){
            System.out.println(billionAsText(num));
        }

    }
    static String numAsText(long b){
        String[] belowTwentyArray = {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] tensArray = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        String[] hundredsArray = {"one hundred","two hundreds","three hundreds","four hundreds","five hundreds","six hundreds","seven hundreds","eight hundreds","nine hundreds"};
        int a = (int) b;
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
            if(number !=0){
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
            } else if(tens == 1){
                name = hundredsArray[hundred-1] + " " + belowTwentyArray[tens2];
            } else if(number ==0){
                name = hundredsArray[hundred-1] + " " + tensArray[tens-2];
            } else if(tens == 0){
                name = hundredsArray[hundred-1] + " " + belowTwentyArray[number];
            } else {
                name = hundredsArray[hundred-1] + " " + tensArray[tens-2] + " " + belowTwentyArray[number];
            }
        }
        return name;
    }
    static String thousandAsText(long b){
        int a = (int) b;
        int first = a/1000;
        int second = a%1000;
        String thousand = null;
        if(first == 0){
            thousand = numAsText(second);
        } else if (first == 1 && second == 0){
            thousand = numAsText(first) + " " + "thousand";
        } else if (second == 0){
            thousand = numAsText(first) + " " + "thousands";
        } else if(first == 1){
            thousand = numAsText(first) + " " + "thousand" + " " + numAsText(second);
        } else {
            thousand = numAsText(first) + " " + "thousands" + " " + numAsText(second);
        }
        return thousand;
    }

    static String millionAsText(long b){
        long first = b/1000000;
        long second = b%1000000;
        String million = null;
        if(first == 0){
            million = thousandAsText(second);
        } else if(first == 1 && second == 0){
            million = numAsText(first) + " " + "million";
        } else if(second == 0){
            million = numAsText(first) + " " + "millions";
        } else if(first == 1){
            million = numAsText(first) + " " + "million" + " " + thousandAsText(second);
        } else {
            million = numAsText(first) + " " + "millions" + " " + thousandAsText(second);
        }
        return million;
    }

    static String billionAsText(long b){
        long first = b/1000000000;
        long second = b%1000000000;
        String billion = null;
        if(first == 1 && second == 0){
            billion = numAsText(first) + " " + "billion";
        } else if (second == 0){
            billion = numAsText(first) + " " + "billions";
        } else if(first == 1){
            billion = numAsText(first) + " " + "billion" + " " + millionAsText(second);
        } else {
            billion = numAsText(first) + " " + "billions" + " " + millionAsText(second);
        }
        return billion;
    }
}
