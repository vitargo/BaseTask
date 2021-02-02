package com.github.basetask.arrays;

import java.util.Scanner;

public class ArraysTask7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        System.out.println("A number of an odd elements in the array is " + numberOfOddElements(array));
    }
    public static int numberOfOddElements(int[] array){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i]%2 != 0){
                count++;
            }
        }
        return count;
    }
}
