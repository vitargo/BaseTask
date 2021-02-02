package com.github.basetask.arrays;

import java.util.Scanner;

public class ArraysTask5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        System.out.println("A sum of odd-index array elements is " + sumOfOddIndexElement(array));
    }
    public static int sumOfOddIndexElement(int[] array){
        int sumOddIndex = 0;
        for(int i = 0; i < array.length; i++){
            if(i % 2 != 0){
                sumOddIndex = sumOddIndex + array[i];
            }
        }
        return sumOddIndex;
    }
}
