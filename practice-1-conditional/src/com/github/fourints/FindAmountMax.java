package com.github.fourints;

public class FindAmountMax {
    static int amoutMax(int[] a) {
        int max = findMax(a);
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == max){
                count++;
            }
        }
        return count;
    }

    private static int findMax(int[] a) {
        int max = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        return max;
    }
}
