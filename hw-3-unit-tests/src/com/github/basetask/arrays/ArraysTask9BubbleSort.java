package com.github.basetask.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysTask9BubbleSort {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int[] sortedArray = bubbleSort(array);
        System.out.println("An array sorted with Bubble Sort: " + Arrays.toString(sortedArray));
    }
    public static int[] bubbleSort(int[] array){
        int size = array.length;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size-i-1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
