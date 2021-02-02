package com.github.basetask.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTask10ShellSortTest {
    @Test
    public void shellSort(){
        int[] array = {7, 90, 4, 5};
        int[] exp = {4, 5, 7, 90};
        int[] act = ArraysTask10ShellSort.shellSort(array, array.length);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void shellSortZero(){
        int[] array = {0, 1, 2, 3};
        int[] exp = {0, 1, 2, 3};
        int[] act = ArraysTask10ShellSort.shellSort(array, array.length);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void shellSortOneEl(){
        int[] array = {0};
        int[] exp = {0};
        int[] act = ArraysTask10ShellSort.shellSort(array, array.length);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void shellSortTwo(){
        int[] array = {4, 0};
        int[] exp = {0, 4};
        int[] act = ArraysTask10ShellSort.shellSort(array, array.length);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void shellSortNegDob() {
        int[] array = {0, -1, 2, 3, -5, 2};
        int[] exp = {-5, -1, 0, 2, 2, 3};
        int[] act = ArraysTask10ShellSort.shellSort(array, array.length);
        Assert.assertArrayEquals(exp, act);
    }
}