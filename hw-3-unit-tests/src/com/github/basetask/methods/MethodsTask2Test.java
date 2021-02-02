package com.github.basetask.methods;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MethodsTask2Test {

    @Test
    public void numAsTextBig(){
        String exp = "one hundred twenty three";
        String act = MethodsTask2.numAsText(123);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextZero(){
        String exp = "zero";
        String act = MethodsTask2.numAsText(0);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextOne(){
        String exp = "one";
        String act = MethodsTask2.numAsText(1);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextBig900(){
        String exp = "nine hundreds";
        String act = MethodsTask2.numAsText(900);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextBig12(){
        String exp = "twelve";
        String act = MethodsTask2.numAsText(12);
        Assert.assertEquals(exp, act);
    }

}