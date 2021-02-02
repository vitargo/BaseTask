package com.github.basetask.arrays;

import java.util.Scanner;

public class ArraysTask4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        System.out.println("An index of the maximal value in an array is " + indexMaxInArray(array));
    }
    public static int indexMaxInArray(int[] array){
        int indexMax = 0;
        for(int i = 1; i < array.length; i++){
            if(array[i] >= array[indexMax]){
                indexMax = i;
            }
        }
        return indexMax;
    }
}
