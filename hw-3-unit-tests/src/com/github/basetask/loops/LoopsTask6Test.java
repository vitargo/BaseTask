package com.github.basetask.loops;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoopsTask6Test {

    @Test
    public void reflectionNumber(){
        int exp = 321;
        int act = LoopsTask6.reflectionNumber(123);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void reflectionNumberZero(){
        int exp = 0;
        int act = LoopsTask6.reflectionNumber(0);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void reflectionNumberNeg(){
        int exp = -654;
        int act = LoopsTask6.reflectionNumber(-456);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void reflectionNumberHundred(){
        int exp = 1;
        int act = LoopsTask6.reflectionNumber(100);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void reflectionNumberOne(){
        int exp = -1;
        int act = LoopsTask6.reflectionNumber(-1);
        Assert.assertEquals(exp, act);
    }

}