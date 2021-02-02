package com.github.basetask.loops;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoopsTask2Test {
    @Test
    public void simpleNumber2(){
        boolean exp = false;
        boolean act = LoopsTask2.simpleNumber(2);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void simpleNumber8(){
        boolean exp = true;
        boolean act = LoopsTask2.simpleNumber(8);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void simpleNumber11(){
        boolean exp = false;
        boolean act = LoopsTask2.simpleNumber(11);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void simpleNumber10000(){
        boolean exp = true;
        boolean act = LoopsTask2.simpleNumber(10000);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void simpleNumber131(){
        boolean exp = false;
        boolean act = LoopsTask2.simpleNumber(131);
        Assert.assertEquals(exp, act);
    }

}