package com.github.basetask.conditionaloperators;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConditionalOperatorsTask5Test {

    @Test
    public void studentResultA(){
        String exp = "A";
        String act = ConditionalOperatorsTask5.studentResult(100);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void studentResultB(){
        String exp = "B";
        String act = ConditionalOperatorsTask5.studentResult(88);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void studentResultC(){
        String exp = "C";
        String act = ConditionalOperatorsTask5.studentResult(60);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void studentResultD(){
        String exp = "D";
        String act = ConditionalOperatorsTask5.studentResult(40);
        Assert.assertEquals(exp, act);
    }
    @Test
    public void studentResultE(){
        String exp = "E";
        String act = ConditionalOperatorsTask5.studentResult(20);
        Assert.assertEquals(exp, act);
    }
    @Test
    public void studentResultSmall(){
        String exp = null;
        String act = ConditionalOperatorsTask5.studentResult(-1);
        Assert.assertEquals(exp, act);
    }
    @Test
    public void studentResultBig(){
        String exp = null;
        String act = ConditionalOperatorsTask5.studentResult(101);
        Assert.assertEquals(exp, act);
    }
    @Test
    public void studentResultZero(){
        String exp = "F";
        String act = ConditionalOperatorsTask5.studentResult(0);
        Assert.assertEquals(exp, act);
    }
}