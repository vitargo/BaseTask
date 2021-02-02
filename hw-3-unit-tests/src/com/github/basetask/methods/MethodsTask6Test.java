package com.github.basetask.methods;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MethodsTask6Test {
    @Test
    public void numAsTextToDigitsOne(){
        String[] name = {"one"};
        long exp = 1;
        long act = MethodsTask6.numAsTextToDigits(name);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextToDigits21(){
        String[] name = {"twenty", "one"};
        long exp = 21;
        long act = MethodsTask6.numAsTextToDigits(name);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextToDigitsHundred(){
        String[] name = {"one", "hundred"};
        long exp = 100;
        long act = MethodsTask6.numAsTextToDigits(name);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextToDigits999(){
        String[] name = {"nine", "hundreds", "ninety", "nine"};
        long exp = 999;
        long act = MethodsTask6.numAsTextToDigits(name);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextToDigitsZero(){
        String[] name = {"zero"};
        long exp = 0;
        long act = MethodsTask6.numAsTextToDigits(name);
        Assert.assertEquals(exp, act);
    }
}