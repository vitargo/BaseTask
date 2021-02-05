package com.github.math;

import java.util.Arrays;
import java.util.Scanner;

public class MathTask4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a size of random array of numbers: ");
        int size = scan.nextInt();
        int[] randomArray = new int[size];
        System.out.println("Enter an array of numbers: ");
        for (int i = 0; i < size; i++) {
            randomArray[i] = scan.nextInt();
        }
        System.out.println("Enter a result of sum of two number from the array: ");
        int result = scan.nextInt();
        int[] pairsArray = pairsFinder(randomArray, size, result);

        System.out.println("The pair of numbers is: ");
        for (int i = 1; i < pairsArray[0]; i = i+2) {
            System.out.println(pairsArray[i] + " + " + pairsArray[i + 1] + " = " + result);
        }
    }
    public static int[] pairsFinder(int[] randomArray, int size, int result){
        int[] pairs = new int[(size*(size-1))/2+2];
        int k = 1;
        int count = 0;
        for(int i = 0; i < size; i++){
            for(int j = i+1; j < size; j++){
                if(randomArray[i] + randomArray[j] == result) {
                    pairs[k]= randomArray[i] ;
                    pairs[k+1] = randomArray[j];
                    k = k+2;
                    count= count+2;
                }
            }
        }
        pairs[0] = count;
        return pairs;
    }
}
