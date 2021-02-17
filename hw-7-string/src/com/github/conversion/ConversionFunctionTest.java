package com.github.conversion;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConversionFunctionTest {

    // Integer to String

    @Test
    public void convertIntToStringBig(){
        String exp = "123456789";
        String act = ConversionFunction.convertIntToString(123456789);
        Assert.assertEquals(act, exp);
    }

    @Test
    public void convertIntToStringSmall(){
        String exp = "1";
        String act = ConversionFunction.convertIntToString(1);
        Assert.assertEquals(act, exp);
    }

    @Test
    public void convertIntToStringZero(){
        int i = 0;
        String exp = "0";
        String act = ConversionFunction.convertIntToString(i);
        Assert.assertEquals(act, exp);
    }

    // Real number to String

    @Test
    public void convertRealToStringBig(){
        String exp = "12.121212";
        String act = ConversionFunction.convertRealToString(12.121212);
        Assert.assertEquals(exp,act);
    }

    @Test
    public void convertRealToStringZero(){
        String exp = "0.0";
        String act = ConversionFunction.convertRealToString(0.0);
        Assert.assertEquals(exp,act);
    }

    @Test
    public void convertRealToStringSmall(){
        String exp = "-1";
        String act = ConversionFunction.convertRealToString(-1);
        Assert.assertEquals(exp,act);
    }


    // String to Integer

    @Test(expected = NumberFormatException.class)
    public void convertStringToIntNull(){
        ConversionFunction.convertStringToInt(null);
    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToIntNoDigits(){
        ConversionFunction.convertStringToInt("one");
    }

    @Test
    public void convertStringToIntBig(){
        int exp = 987654321;
        int act = ConversionFunction.convertStringToInt("0987654321");
        Assert.assertEquals(act, exp);
    }

    @Test
    public void convertStringToIntZero(){
        int exp = 0;
        int act = ConversionFunction.convertStringToInt("0");
        Assert.assertEquals(act, exp);
    }

    @Test
    public void convertStringToIntMinus(){
        int exp = -123;
        int act = ConversionFunction.convertStringToInt("-123");
        Assert.assertEquals(act, exp);
    }

    @Test
    public void convertStringToIntSmall(){
        int exp = 9;
        int act = ConversionFunction.convertStringToInt("9");
        Assert.assertEquals(act, exp);
    }

    // String to real number

    @Test(expected = NumberFormatException.class)
    public void convertStringToRealNull(){
        ConversionFunction.convertStringToReal(null);
    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToRealNoDigits(){
        ConversionFunction.convertStringToReal("one");
    }

    @Test
    public void convertStringToRealBig() {
        double exp = 987654321.0989809809;
        double act = ConversionFunction.convertStringToReal("987654321.0989809809");
        Assert.assertEquals(act, exp, 0.00001);
    }

    @Test
    public void convertStringToRealMinus() {
        double exp = -9.09;
        double act = ConversionFunction.convertStringToReal("-9.090000000");
        Assert.assertEquals(act, exp, 0.00001);
    }

    @Test
    public void convertStringToRealZero() {
        double exp = 0;
        double act = ConversionFunction.convertStringToReal("-0.00000");
        Assert.assertEquals(act, exp, 0.00001);
    }
}