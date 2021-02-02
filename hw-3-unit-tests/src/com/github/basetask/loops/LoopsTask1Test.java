package com.github.basetask.loops;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoopsTask1Test {

    @Test
    public void sumAndNumberOfEven100() {
        int[] exp = {2450, 49};
        int[] act = LoopsTask1.sumAndNumberOfEven100(1, 99);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void sumAndNumberOfEven5() {
        int[] exp = {6, 2};
        int[] act = LoopsTask1.sumAndNumberOfEven100(1, 5);
        Assert.assertArrayEquals(exp, act);
    }
    @Test
    public void sumAndNumberOfEven0() {
        int[] exp = {0, 1};
        int[] act = LoopsTask1.sumAndNumberOfEven100(0, 1);
        Assert.assertArrayEquals(exp, act);
    }
    @Test
    public void sumAndNumberOfEven1() {
        int[] exp = {12, 3};
        int[] act = LoopsTask1.sumAndNumberOfEven100(2, 6);
        Assert.assertArrayEquals(exp, act);
    }
}