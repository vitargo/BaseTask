package com.github.conversion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConversionFunction {
    public static void main(String[] args) {

        System.out.println("Integer to String: " + convertIntToString(123));
        System.out.println("Test: " + convertIntToString(100) + 100);

        System.out.println("Real number to String: " + convertRealToString(23.343466890675646756));
        System.out.println("Test: " + convertRealToString(100.111) + 100);

        System.out.println("String to Integer: " + convertStringToInt("123.23"));
        System.out.println("Test: " + (convertStringToInt("100") + 100));

        System.out.println("String to Real number: " + convertStringToReal("567890.5635645"));
        System.out.println("Test: " + (convertStringToReal("100.111") + 100d));
    }

    public static String convertIntToString(int number){
        return Integer.toString(number);
    }

    public static String convertRealToString(Object o){
        return String.valueOf(o);
    }

    public static int convertStringToInt(String number) {
        if(number == null){
            throw new NumberFormatException ("String is null!");
        }
        if(!number.matches("(-*)(\\d+)")){
            throw new NumberFormatException("String hasn't digits!");
        }
        return Integer.parseInt(number);
    }

    public static double convertStringToReal(String number){
        if(number == null){
            throw new NumberFormatException ("String is null!");
        }
        if(!number.matches("(-*)(\\d+)\\.(\\d+)")){
            throw new NumberFormatException("String hasn't digits!");
        }
        return Double.parseDouble(number);
    }
}
