package com.github.basetask.methods;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MethodsTask1Test {

    @Test
    public void dayName1(){
        String exp = "Monday";
        String act = MethodsTask1.dayName(1);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void dayName2(){
        String exp = "Tuesday";
        String act = MethodsTask1.dayName(2);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void dayName7(){
        String exp = "Sunday";
        String act = MethodsTask1.dayName(7);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void dayNameZero(){
        String exp = null;
        String act = MethodsTask1.dayName(0);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void dayNameBig(){
        String exp = null;
        String act = MethodsTask1.dayName(8);
        Assert.assertEquals(exp, act);
    }
}