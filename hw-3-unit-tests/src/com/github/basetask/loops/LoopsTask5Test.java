package com.github.basetask.loops;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoopsTask5Test {

    @Test
    public void sumNumberDigitsBig(){
        int exp = 6;
        int act = LoopsTask5.sumNumberDigits(123);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sumNumberDigitsSmall(){
        int exp = 1;
        int act = LoopsTask5.sumNumberDigits(1);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sumNumberDigitsZero(){
        int exp = 0;
        int act = LoopsTask5.sumNumberDigits(0);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sumNumberDigitsBig2(){
        int exp = 6;
        int act = LoopsTask5.sumNumberDigits(102030);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sumNumberDigits(){
        int exp = 4;
        int act = LoopsTask5.sumNumberDigits(004);
        Assert.assertEquals(exp, act);
    }
}