package com.github.basetask.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysTask10ShellSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int[] sortedArray = shellSort(array, size);
        System.out.println("An array sorted with Shell Sort: " + Arrays.toString(sortedArray));
    }
    public static int[] shellSort(int[] array, int n){
        for(int gap = n/2; gap > 0; gap = gap/2){
            for (int i = gap; i < n; i++){
                int temp = array[i];
                int j;
                for(j = i; j >= gap && array[j-gap] > temp; j = j-gap){
                    array[j] = array[j-gap];
                }
                array[j] = temp;
            }
        }
        return array;
    }
}
