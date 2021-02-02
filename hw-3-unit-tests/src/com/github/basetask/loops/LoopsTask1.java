package com.github.basetask.loops;

public class LoopsTask1 {
    public static void main(String[] args) {
        int min = 1;
        int max = 99;
        int[] result = sumAndNumberOfEven100(min, max);
        System.out.println("Sum  of even numbers from " + min + " to " + max + " is " + result[0]);
        System.out.println("Number of even numbers from " + min + " to " + max + " is " + result[1]);

    }
    public static int[] sumAndNumberOfEven100(int min, int max){
        int[] result = {0, 0};
        for(int i = min; i < max+1; i ++){
            if(i % 2 == 0){
                result[0]= result[0] + i;
                result[1]++;
            }
        }
        return result;
    }
}
