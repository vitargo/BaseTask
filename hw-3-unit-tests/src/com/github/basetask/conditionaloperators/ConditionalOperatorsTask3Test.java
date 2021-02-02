package com.github.basetask.conditionaloperators;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConditionalOperatorsTask3Test {

    @Test
    public void sumPositiveIntPos(){
        int exp = 20;
        int act = ConditionalOperatorsTask3.sumPositiveInt(4, 6, 10);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sumPositiveIntNegAll(){
        int exp = 0;
        int act = ConditionalOperatorsTask3.sumPositiveInt(- 4, - 6,  -11);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sumPositiveIntPosNeg(){
        int exp = 10;
        int act = ConditionalOperatorsTask3.sumPositiveInt(7, 3, -5);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sumPositiveIntPosZero(){
        int exp = 0;
        int act = ConditionalOperatorsTask3.sumPositiveInt(0, 0, 0);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sumPositiveIntPosNeg2(){
        int exp = 100;
        int act = ConditionalOperatorsTask3.sumPositiveInt(100, -20, -2);
        Assert.assertEquals(exp, act);
    }
}