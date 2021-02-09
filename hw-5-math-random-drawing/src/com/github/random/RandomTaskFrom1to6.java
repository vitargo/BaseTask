package com.github.random;

import java.util.Arrays;
import java.util.Random;

public class RandomTaskFrom1to6 {
    public static void main(String[] args) {

        System.out.println("Task 1. Random number: " + oneRandomNun());

        System.out.println("Task 2. Ten random numbers: " + Arrays.toString(severalRandomNum(10)));

        System.out.println("Task 3. Ten random numbers in range from 0 to 10: " + Arrays.toString(severalRandomNumInRange(10, 0, 10)));

        System.out.println("Task 4. Ten random numbers in range from 20 to 50: " + Arrays.toString(severalRandomNumInRange(10, 20, 50)));

        System.out.println("Task 5. Ten random numbers in range from -10 to 10: " + Arrays.toString(severalRandomNumInRange(10, -10, 10)));

        System.out.println("Task 6. Random amount of number form 3 to 15 of random numbers in range from -10 to 35: " +

                Arrays.toString(severalRandomNumInRange(oneRandomNunInRange(3,15), -10, 35)));
    }

    public static int oneRandomNun(){
        Random random = new Random();
        return random.nextInt();
    }

    public static int oneRandomNunInRange(int min, int max){
        Random random = new Random();
        int number = random.nextInt(max - min + 1) + min;
        return number;
    }

    public static int[] severalRandomNum(int size){
        int[] sevRanNum = new int[size];
        Random random = new Random();
        for(int i = 0; i < size; i++){
            sevRanNum[i] = random.nextInt();
        }
        return sevRanNum;
    }

    public static int[] severalRandomNumInRange(int size, int min, int max){
        int[] sevRanNum = new int[size];
        Random random = new Random();
        for(int i = 0; i < size; i++){
            sevRanNum[i] = random.nextInt(max - min +1 ) + min;
        }
        return sevRanNum;
    }
}
