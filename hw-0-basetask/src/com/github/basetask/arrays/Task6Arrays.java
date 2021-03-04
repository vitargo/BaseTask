package com.github.basetask.arrays;

import java.util.Scanner;

public class Task6Arrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        for(int i = 0; i < size/2; i++){
            int temp = array[i];
            array[i] = array[size-1-i];
            array[size-1-i] = temp;
        }
        System.out.println("An array after reverse: " + java.util.Arrays.toString(array));
        }
    }

