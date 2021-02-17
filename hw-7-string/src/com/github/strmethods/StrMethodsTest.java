package com.github.strmethods;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrMethodsTest {

    // Shortest word

    @Test
    public void shortestWordBig(){
        int exp = 3;
        int act = StrMethods.shortestWord("The,- word... Cub!!!");
        Assert.assertEquals(exp, act);
    }

    @Test
    public void shortestWordSmall(){
        int exp = 7;
        int act = StrMethods.shortestWord("The,true...!!!");
        Assert.assertEquals(exp, act);
    }

    @Test(expected = NumberFormatException.class)
    public void shortestWordNull(){
        StrMethods.shortestWord(null);
    }

    @Test
    public void shortestWordEmpty(){
        int exp = 0;
        int act = StrMethods.shortestWord("");
        Assert.assertEquals(exp, act);
    }

    //Dollar sign

    @Test
    public void dollarSighBig(){
        String[] test = {"max", "am", "min", "hello"};
        String[] exp = {"$$$", "am", "$$$", "hello"};
        String[] act = StrMethods.dollarSign(test,3);
        Assert.assertArrayEquals(exp, act);
    }

    @Test(expected = NullPointerException.class)
    public void dollarSighNull(){
        String[] test = {null, null, null};
        StrMethods.dollarSign(test,3);
    }

    @Test(expected = NullPointerException.class)
    public void dollarSighNull2(){
        String[] test = null;
        StrMethods.dollarSign(test,3);
    }

    @Test
    public void dollarSignSmall(){
        String[] test = {"max"};
        String[] exp = {"max"};
        String[] act = StrMethods.dollarSign(test,4);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void dollarSighOutThree(){
        String[] test = {"max", "am", "min", "hello"};
        String[] exp = {"max", "am", "min", "hello"};
        String[] act = StrMethods.dollarSign(test,2);
        Assert.assertArrayEquals(exp, act);
    }

    // Add space

    @Test
    public void addSpaceBig(){
        String exp = "The, - word. . . Cub! ! !";
        String act = StrMethods.addSpace("The,- word... Cub!!!");
        Assert.assertEquals(exp, act);
    }

    @Test(expected = NullPointerException.class)
    public void addSpaceNull(){
        StrMethods.addSpace(null);
    }

    @Test
    public void addSpaceEmpty(){
        String exp = "";
        String act = StrMethods.addSpace("");
        Assert.assertEquals(exp, act);
    }

    // No repeated char

    @Test
    public void noRepeatedCharBig(){
        String exp = "Nasty igrl!";
        String act = StrMethods.noRepeatedChar("Nastya is a girl!!!");
        Assert.assertEquals(exp, act);
    }

    @Test(expected = NullPointerException.class)
    public void noRepeatedCharNull(){
        StrMethods.noRepeatedChar(null);
    }

    @Test
    public void noRepeatedCharSmall(){
        String exp = "a.b,c/d\\e|f";
        String act = StrMethods.noRepeatedChar("aa..bb,,cc//d\\ee||ff");
        Assert.assertEquals(exp, act);
    }

    @Test
    public void noRepeatedCharZero(){
        String exp = "";
        String act = StrMethods.noRepeatedChar("");
        Assert.assertEquals(exp, act);
    }

    // Number of words

    @Test
    public void numberOfWordsBig(){
        int exp = 2;
        int act = StrMethods.numberOfWords("Hello world!!!!");
        Assert.assertEquals(act, exp);
    }

    @Test
    public void numberOfWordsNull(){
        int exp = 0;
        int act = StrMethods.numberOfWords(null);
        Assert.assertEquals(act, exp);
    }

    @Test
    public void numberOfWordsSmall(){
        int exp = 1;
        int act = StrMethods.numberOfWords("Hello!!!!");
        Assert.assertEquals(act, exp);
    }

    // Delete part

    @Test
    public void deletePartBig(){
        String exp = "Hello, Bob!";
        String act = StrMethods.deletePart("Hello, Big Bob!", 6,4);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void deletePartMinusStart(){
        String exp = "Hello, Big Bob!";
        String act = StrMethods.deletePart("Hello, Big Bob!", -6,4);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void deletePartMinusLen(){
        String exp = "Hello, Big Bob!";
        String act = StrMethods.deletePart("Hello, Big Bob!", 6,-4);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void deletePartZero(){
        String exp = "Hello, Big Bob!";
        String act = StrMethods.deletePart("Hello, Big Bob!", 0,0);
        Assert.assertEquals(exp, act);
    }

    @Test(expected = NullPointerException.class)
    public void deletePartNull(){
        StrMethods.deletePart(null, -4,0);
    }

    // Reverse String

    @Test
    public void reverseStringBig(){
        String exp = "!drow olleH";
        String act = StrMethods.reverseString("Hello word!");
        Assert.assertEquals(exp, act);
    }

    @Test
    public void reverseStringSmall(){
        String exp = "KO";
        String act = StrMethods.reverseString("OK");
        Assert.assertEquals(exp, act);
    }

    @Test
    public void reverseStringEmpty(){
        String exp = "";
        String act = StrMethods.reverseString("");
        Assert.assertEquals(exp, act);
    }

    @Test(expected = NullPointerException.class)
    public void reverseStringNull(){
        StrMethods.reverseString(null);
    }

    // Delete last word

    @Test
    public void deleteLastWordBig(){
        String exp = "Hello, Big";
        String act = StrMethods.deleteLastWord("Hello, Big Bob!");
        Assert.assertEquals(exp, act);
    }

    @Test
    public void deleteLastWordSmall(){
        String exp = "";
        String act = StrMethods.deleteLastWord("Hello!");
        Assert.assertEquals(exp, act);
    }

    @Test(expected = NullPointerException.class)
    public void deleteLastWordNull(){
        StrMethods.deleteLastWord(null);
    }

}