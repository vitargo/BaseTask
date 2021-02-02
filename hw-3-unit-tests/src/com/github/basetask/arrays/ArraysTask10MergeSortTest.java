package com.github.basetask.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTask10MergeSortTest {
    @Test
    public void mergeSort(){
        int[] array = {7, 90, 4, 5};
        int[] exp = {4, 5, 7, 90};
        int[] act = ArraysTask10MergeSort.mergeSort(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void mergeSortZero(){
        int[] array = {0, 1, 2, 3};
        int[] exp = {0, 1, 2, 3};
        int[] act = ArraysTask10MergeSort.mergeSort(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void mergeSortOneEl(){
        int[] array = {0};
        int[] exp = {0};
        int[] act = ArraysTask10MergeSort.mergeSort(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void mergeSortTwo(){
        int[] array = {4, 0};
        int[] exp = {0, 4};
        int[] act = ArraysTask10MergeSort.mergeSort(array);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void mergeSortNegDob() {
        int[] array = {0, -1, 2, 3, -5, 2};
        int[] exp = {-5, -1, 0, 2, 2, 3};
        int[] act = ArraysTask10MergeSort.mergeSort(array);
        Assert.assertArrayEquals(exp, act);
    }
}