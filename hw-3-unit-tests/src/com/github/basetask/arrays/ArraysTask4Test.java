package com.github.basetask.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTask4Test {
    @Test
    public void indexMaxInArray(){
        int[] array = {7, 90, 4, 5};
        int exp = 1;
        int act = ArraysTask4.indexMaxInArray(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void indexMaxInArrayZero(){
        int[] array = {0, 0, 0};
        int exp = 2;
        int act = ArraysTask4.indexMaxInArray(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void indexMaxInArrayOneEl(){
        int[] array = {3};
        int exp = 0;
        int act = ArraysTask4.indexMaxInArray(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void indexMaxInArrayNeg(){
        int[] array = {-45, -567, 4, 0};
        int exp = 2;
        int act = ArraysTask4.indexMaxInArray(array);
        Assert.assertEquals(exp, act);
    }
}