package com.github.basetask.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTask10QuickSortTest {
    @Test
    public void quickSort(){
        int[] array = {7, 90, 4, 5};
        int[] exp = {4, 5, 7, 90};
        int[] act = ArraysTask10QuickSort.quickSort(array, 0, array.length-1);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void quickSortZero(){
        int[] array = {0, 1, 2, 3};
        int[] exp = {0, 1, 2, 3};
        int[] act = ArraysTask10QuickSort.quickSort(array, 0, array.length-1);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void quickSortOneEl(){
        int[] array = {0};
        int[] exp = {0};
        int[] act = ArraysTask10QuickSort.quickSort(array, 0, array.length-1);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void quickSortTwo(){
        int[] array = {4, 0};
        int[] exp = {0, 4};
        int[] act = ArraysTask10QuickSort.quickSort(array, 0, array.length-1);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void quickSortNegDob() {
        int[] array = {0, -1, 2, 3, -5, 2};
        int[] exp = {-5, -1, 0, 2, 2, 3};
        int[] act = ArraysTask10QuickSort.quickSort(array, 0, array.length-1);
        Assert.assertArrayEquals(exp, act);
    }
}