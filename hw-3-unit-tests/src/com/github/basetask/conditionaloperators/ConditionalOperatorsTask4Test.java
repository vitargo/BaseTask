package com.github.basetask.conditionaloperators;

import org.junit.Assert;
import org.junit.Test;

public class ConditionalOperatorsTask4Test {

    @Test
    public void maxSumOrMultiPosAll(){
        int exp = 15;
        int act = ConditionalOperatorsTask4.maxSumOrMulti(1, 3,5);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void maxSumOrMultiNegAll(){
        int exp = -8;
        int act = ConditionalOperatorsTask4.maxSumOrMulti(-2, -4,-2);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void maxSumOrMultiZero(){
        int exp = 2;
        int act = ConditionalOperatorsTask4.maxSumOrMulti(0, 4,-2);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void maxSumOrMultiZeroAll(){
        int exp = 0;
        int act = ConditionalOperatorsTask4.maxSumOrMulti(0, 0,0);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void maxSumOrMultiOne(){
        int exp = 3;
        int act = ConditionalOperatorsTask4.maxSumOrMulti(1, 1,1);
        Assert.assertEquals(exp, act);
    }

}