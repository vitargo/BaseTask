package com.github.basetask.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysTask10QuickSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int[] sortedArray = quickSort(array, 0, size-1);

        System.out.println("An array sorted with Quick Sort: " + Arrays.toString(sortedArray));
    }
    public static int partition(int array[], int low, int high){
        int pi = array[high];
        int i = low-1;
        for (int j = low; j < high; j++){
            if (array[j] <= pi){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }
    public static int[] quickSort(int[] array, int low, int high) {
        if (low < high){
            int pi = partition(array, low, high);
            quickSort(array, low, pi-1);
            quickSort(array, pi+1, high);
        }
        return array;
    }
}

