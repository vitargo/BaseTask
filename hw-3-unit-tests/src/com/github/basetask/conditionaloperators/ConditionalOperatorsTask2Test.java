package com.github.basetask.conditionaloperators;

import org.junit.Test;
import org.junit.Assert;

public class ConditionalOperatorsTask2Test {

    @Test
    public void decartQuadrant1(){
        int exp = 1;
        int act = ConditionalOperatorsTask2.decartQuadrant(4, 6);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void decartQuadrant2(){
        int exp = 2;
        int act = ConditionalOperatorsTask2.decartQuadrant(-5, 10);
        Assert.assertEquals(exp, act);
    }

    @Test
    public  void decartQuadrant3(){
        int exp = 3;
        int act = ConditionalOperatorsTask2.decartQuadrant(-12, -23);
        Assert.assertEquals(exp, act);
    }

    @Test
    public  void decartQuadrant4(){
        int exp = 4;
        int act = ConditionalOperatorsTask2.decartQuadrant(12, -6);
        Assert.assertEquals(exp, act);
    }

    @Test
    public  void decartQuadrant0(){
        int exp = 0;
        int act = ConditionalOperatorsTask2.decartQuadrant(0, 0);
        Assert.assertEquals(exp, act);
    }

    @Test
    public  void decartQuadrant(){
        int exp = -1;
        int act = ConditionalOperatorsTask2.decartQuadrant(0, 6);
        Assert.assertEquals(exp, act);
    }
}
