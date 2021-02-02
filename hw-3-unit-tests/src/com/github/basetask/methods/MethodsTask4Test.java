package com.github.basetask.methods;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MethodsTask4Test {

    @Test
    public void distanceBetweenPoints(){
        double exp = Math.sqrt(2);
        double act = MethodsTask4.distanceBetweenPoints(6,9,7,8);
        Assert.assertEquals(exp, act, 0.01);
    }
    @Test
    public void distanceBetweenPoints2(){
        double exp = Math.sqrt(20);
        double act = MethodsTask4.distanceBetweenPoints(1,3,5,1);
        Assert.assertEquals(exp, act, 0.01);
    }
    @Test
    public void distanceBetweenPoints3(){
        double exp = Math.sqrt(34);
        double act = MethodsTask4.distanceBetweenPoints(0,3,5,0);
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void distanceBetweenPointsZero(){
        double exp = Math.sqrt(0);
        double act = MethodsTask4.distanceBetweenPoints(0,0,0,0);
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void distanceBetweenPointsOne(){
        double exp = Math.sqrt(0);
        double act = MethodsTask4.distanceBetweenPoints(1,1,1,1);
        Assert.assertEquals(exp, act, 0.01);
    }

}