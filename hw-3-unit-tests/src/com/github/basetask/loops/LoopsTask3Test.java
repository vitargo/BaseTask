package com.github.basetask.loops;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoopsTask3Test {

    @Test
    public void cubeResultBig(){
        int exp = 9;
        int act = LoopsTask3.cubeResult(85);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void cubeResultSmall(){
        int exp = 1;
        int act = LoopsTask3.cubeResult(3);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void cubeResultZero(){
        int exp = 0;
        int act = LoopsTask3.cubeResult(0);
        Assert.assertEquals(exp, act);
    }
    @Test
    public void cubeResultOne(){
        int exp = 1;
        int act = LoopsTask3.cubeResult(1);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void cubeResultMid(){
        int exp = 3;
        int act = LoopsTask3.cubeResult(10);
        Assert.assertEquals(exp, act);
    }

}