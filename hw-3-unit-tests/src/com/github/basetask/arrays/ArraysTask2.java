package com.github.basetask.arrays;

import java.util.Scanner;

public class ArraysTask2 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println("Maximal value in an array is " + maxInArray(array));
    }
    public static int maxInArray(int[] array){
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array [i];
            }
        }
        return max;
    }
}
