package com.github.basetask.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTask8Test {
    @Test
    public void rotationOfArray(){
        int[] array = {7, 90, 4, 5};
        int[] exp = {4, 5, 7, 90};
        int[] act = ArraysTask8.rotationOfArray(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void rotationOfArrayZero(){
        int[] array = {0, 1, 2, 3};
        int[] exp = {2, 3, 0, 1};
        int[] act = ArraysTask8.rotationOfArray(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void rotationOfArrayOneEl(){
        int[] array = {0};
        int[] exp = {0};
        int[] act = ArraysTask8.rotationOfArray(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void rotationOfArrayFiveEl(){
        int[] array = {0, 1, 2, 3, -5};
        int[] exp = {3, -5, 2, 0, 1};
        int[] act = ArraysTask8.rotationOfArray(array);
        Assert.assertArrayEquals(exp, act);
    }
}