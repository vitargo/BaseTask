package com.github.basetask.conditionaloperators;

import org.junit.Test;
import org.junit.Assert;

public class ConditionalOperatorsTask1Test {

    @Test
    public void multipleResultEven() {
        int exp = 12;
        int act = ConditionalOperatorsTask1.multipleResult(4, 3);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void multipleResultOdd() {
        int exp = 17;
        int act = ConditionalOperatorsTask1.multipleResult(7, 10);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void multipleResultZero() {
        int exp = 0;
        int act = ConditionalOperatorsTask1.multipleResult(0, 3);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void multipleResultBig() {
        int exp = 800;
        int act = ConditionalOperatorsTask1.multipleResult(100, 8);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void multipleResultOne() {
        int exp = 9;
        int act = ConditionalOperatorsTask1.multipleResult(1, 8);
        Assert.assertEquals(exp, act);
    }

}
