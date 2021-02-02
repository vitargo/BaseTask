package com.github.basetask.arrays;

import java.util.Scanner;

public class ArraysTask6 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int[] reverse = reverseArray(array);
        System.out.println("An array after reverse: " + java.util.Arrays.toString(reverse));
    }
    public static int[] reverseArray(int[] array) {
        int size = array.length;
        for (int i = 0; i < size/2; i++) {
            int temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
        return array;
    }
}
