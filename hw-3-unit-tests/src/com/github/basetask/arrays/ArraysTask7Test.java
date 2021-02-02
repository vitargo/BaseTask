package com.github.basetask.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTask7Test {
    @Test
    public void numberOfOddElements(){
        int[] array = {7, 90, 4, 5};
        int exp = 2;
        int act = ArraysTask7.numberOfOddElements(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numberOfOddElementsZero(){
        int[] array = {0, 0, 0};
        int exp = 0;
        int act = ArraysTask7.numberOfOddElements(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numberOfOddElementsOneOdd(){
        int[] array = {3};
        int exp = 1;
        int act = ArraysTask7.numberOfOddElements(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numberOfOddElementsOneEven(){
        int[] array = {4};
        int exp = 0;
        int act = ArraysTask7.numberOfOddElements(array);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numberOfOddElementsNeg(){
        int[] array = {-45, -567, 4, 0};
        int exp = 2;
        int act = ArraysTask7.numberOfOddElements(array);
        Assert.assertEquals(exp, act);
    }

}