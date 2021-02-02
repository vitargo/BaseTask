package com.github.basetask.methods;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MethodsTask5Test {

    @Test
    public void billionAsText(){
        String exp = "one billion one million one thousand one";
        String act = MethodsTask5.billionAsText(1001001001);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void millionAsText(){
        String exp = "one million one";
        String act = MethodsTask5.millionAsText(1000001);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void thousandAsText(){
        String exp = "two thousands thirty two";
        String act = MethodsTask5.thousandAsText(2032);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsText(){
        String exp = "nine hundreds ninety nine";
        String act = MethodsTask5.numAsText(999);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void numAsText40(){
        String exp = "forty";
        String act = MethodsTask5.numAsText(40);
        Assert.assertEquals(exp, act);
    }
}