package com.github.basetask.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTask3Test {
    @Test
    public void indexMinInArray(){
        int[] array = {7, 90, 4, 5};
        int exp = 2;
        int act = ArraysTask3.indexMinInArray(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void indexMinInArrayZero(){
        int[] array = {0, 0, 0};
        int exp = 2;
        int act = ArraysTask3.indexMinInArray(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void indexMinInArrayOneEl(){
        int[] array = {3};
        int exp = 0;
        int act = ArraysTask3.indexMinInArray(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void indexMinInArrayNeg(){
        int[] array = {-45, -567, 4, 0};
        int exp = 1;
        int act = ArraysTask3.indexMinInArray(array);
        Assert.assertEquals(exp, act);
    }
}