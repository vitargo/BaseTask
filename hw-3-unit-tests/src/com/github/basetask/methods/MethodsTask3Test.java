package com.github.basetask.methods;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MethodsTask3Test {

    @Test
    public void numAsTextToDigitsOne(){
        String[] name = {"one"};
        int exp = 1;
        int act = MethodsTask3.numAsTextToDigits(name);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextToDigits21(){
        String[] name = {"twenty", "one"};
        int exp = 21;
        int act = MethodsTask3.numAsTextToDigits(name);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextToDigitsHundred(){
        String[] name = {"one", "hundred"};
        int exp = 100;
        int act = MethodsTask3.numAsTextToDigits(name);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextToDigits999(){
        String[] name = {"nine", "hundreds", "ninety", "nine"};
        int exp = 999;
        int act = MethodsTask3.numAsTextToDigits(name);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsTextToDigitsZero(){
        String[] name = {"zero"};
        int exp = 0;
        int act = MethodsTask3.numAsTextToDigits(name);
        Assert.assertEquals(exp, act);
    }
}