package com.github.basetask.loops;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoopsTask4Test {

    @Test
    public void factorialFunc1(){
        long exp = 1;
        long act = LoopsTask4.factorialFunc(1);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void factorialFunc2(){
        long exp = 2;
        long act = LoopsTask4.factorialFunc(2);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void factorialFunc3(){
        long exp = 6;
        long act = LoopsTask4.factorialFunc(3);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void factorialFunc5(){
        long exp = 120;
        long act = LoopsTask4.factorialFunc(5);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void factorialFuncBig(){
        long exp = 2432902008176640000L;
        long act = LoopsTask4.factorialFunc(20);
        Assert.assertEquals(exp, act);
    }

}