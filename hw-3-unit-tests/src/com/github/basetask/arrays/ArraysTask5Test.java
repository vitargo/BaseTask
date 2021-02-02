package com.github.basetask.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTask5Test {
    @Test
    public void sumOfOddIndexElement(){
        int[] array = {7, 90, 4, 5};
        int exp = 95;
        int act = ArraysTask5.sumOfOddIndexElement(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sumOfOddIndexElementZero(){
        int[] array = {0, 0, 0};
        int exp = 0;
        int act = ArraysTask5.sumOfOddIndexElement(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sumOfOddIndexElementOne(){
        int[] array = {3};
        int exp = 0;
        int act = ArraysTask5.sumOfOddIndexElement(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sumOfOddIndexElementNeg(){
        int[] array = {-45, -567, 4, 0};
        int exp = -567;
        int act = ArraysTask5.sumOfOddIndexElement(array);
        Assert.assertEquals(exp, act);
    }
}