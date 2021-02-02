package com.github.basetask.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysTask10HeapSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int[] sortedArray = heapSort(array, size);
        System.out.println("An array sorted with Heap Sort: " + Arrays.toString(array));

    }
    private static void heapify(int[] array, int n, int i){
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && array[l] > array[largest]){
            largest = l;
        }
        if (r < n && array[r] > array[largest]){
            largest = r;
        }
        if (largest != i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, n, largest);
        }
    }
    public static int[] heapSort(int[] array, int n){
        for (int i = n/2-1; i >= 0; i--){
            heapify(array, n, i);
        }
        for (int i = n-1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
        return array;
    }
}
