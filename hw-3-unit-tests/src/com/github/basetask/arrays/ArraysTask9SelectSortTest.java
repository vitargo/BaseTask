package com.github.basetask.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTask9SelectSortTest {
    @Test
    public void selectSort(){
        int[] array = {7, 90, 4, 5};
        int[] exp = {4, 5, 7, 90};
        int[] act = ArraysTask9SelectSort.selectSort(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void selectSortZero(){
        int[] array = {0, 1, 2, 3};
        int[] exp = {0, 1, 2, 3};
        int[] act = ArraysTask9SelectSort.selectSort(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void selectSortOneEl(){
        int[] array = {0};
        int[] exp = {0};
        int[] act = ArraysTask9SelectSort.selectSort(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void selectSortTwo(){
        int[] array = {4, 0};
        int[] exp = {0, 4};
        int[] act = ArraysTask9SelectSort.selectSort(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void selectSortNegDob() {
        int[] array = {0, -1, 2, 3, -5, 2};
        int[] exp = {-5, -1, 0, 2, 2, 3};
        int[] act = ArraysTask9SelectSort.selectSort(array);
        Assert.assertArrayEquals(exp, act);
    }
}