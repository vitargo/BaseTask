package com.github.basetask.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTask1Test {

    @Test
    public void minInArray(){
        int[] array = {7, 90, 4, 5};
        int exp = 4;
        int act = ArraysTask1.minInArray(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void minInArrayZero(){
        int[] array = {0, 0, 0};
        int exp = 0;
        int act = ArraysTask1.minInArray(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void minInArrayOneEl(){
        int[] array = {3};
        int exp = 3;
        int act = ArraysTask1.minInArray(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void minInArrayNeg(){
        int[] array = {-45, -567, 4, 0};
        int exp = -567;
        int act = ArraysTask1.minInArray(array);
        Assert.assertEquals(exp, act);
    }
}