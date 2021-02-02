package com.github.basetask.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTask6Test {
    @Test
    public void reverseArray(){
        int[] array = {7, 90, 4, 5};
        int[] exp = {5, 4, 90, 7};
        int[] act = ArraysTask6.reverseArray(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void reverseArrayZero(){
        int[] array = {0, 1, 2, 3};
        int[] exp = {3, 2, 1, 0};
        int[] act = ArraysTask6.reverseArray(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void reverseArrayOneEl(){
        int[] array = {0};
        int[] exp = {0};
        int[] act = ArraysTask6.reverseArray(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void reverseArrayZeroFiveEl(){
        int[] array = {0, 1, 2, 3, -5};
        int[] exp = {-5, 3, 2, 1, 0};
        int[] act = ArraysTask6.reverseArray(array);
        Assert.assertArrayEquals(exp, act);
    }
}