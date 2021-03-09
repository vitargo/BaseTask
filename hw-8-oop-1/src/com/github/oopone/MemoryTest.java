package com.github.oopone;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemoryTest {

    @Test
    public void readAllOne(){
        String exp = "1qQ";
        String act = Memory.readLast(MockData.memory1.memoryCell);
        Assert.assertEquals(act, exp);
    }
    @Test
    public void readAllOne2(){
        String exp = "One";
        String act = Memory.readLast(MockData.dataOne);
        Assert.assertEquals(act, exp);
    }

    @Test
    public void readAllMany(){
        String exp = "4xX";
        String act = Memory.readLast(MockData.memory4.memoryCell);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void readAllMany2(){
        String exp = "Three";
        String act = Memory.readLast(MockData.dataMany);
        Assert.assertEquals(exp, act);
    }

    @Test (expected = NullPointerException.class)
    public void readAllEmpty(){
        Memory.readLast(MockData.dataEmpty);
    }

    @Test
    public void removeLastMany(){
        String exp = "[1aA, 2aA, null, null]";
        String act = Memory.removeLast(MockData.memory2.memoryCell);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void removeLastMany1(){
        String exp = "[One, Two, null]";
        String act = Memory.removeLast(MockData.dataMany);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void removeLastOne(){
        String exp = "[null]";
        String act = Memory.removeLast(MockData.dataOne);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void removeLastEmpty(){
        String exp = "[]";
        String act = Memory.removeLast(MockData.dataEmpty);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void saveMany(){
        boolean exp = true;
        boolean act = Memory.save(MockData.memory2.memoryCell, "new");
        Assert.assertEquals(exp, act);
    }

    @Test
    public void saveOne(){
        boolean exp = false;
        boolean act = Memory.save(MockData.dataOne, "new");
        Assert.assertEquals(exp, act);
    }

    @Test
    public void saveNull(){
        boolean exp = true;
        boolean act = Memory.save(MockData.dataNull, "new");
        Assert.assertEquals(exp, act);
    }

    @Test
    public void saveEmpty(){
        boolean exp = false;
        boolean act = Memory.save(MockData.dataEmpty, "new");
        Assert.assertEquals(exp, act);
    }

    @Test
    public void getMemoryMany(){
        Memory.ObjectMemory exp = new Memory.ObjectMemory(2,50);
        Memory.ObjectMemory act = Memory.getMemoryInfo(MockData.memory1.memoryCell);
        Assert.assertEquals(exp.toString(), act.toString());
    }

    @Test
    public void getMemoryMany2(){
        Memory.ObjectMemory exp = new Memory.ObjectMemory(8,50);
        Memory.ObjectMemory act = Memory.getMemoryInfo(MockData.memory4.memoryCell);
        Assert.assertEquals(exp.toString(), act.toString());
    }

    @Test
    public void getMemoryOne(){
        Memory.ObjectMemory exp = new Memory.ObjectMemory(1,100);
        Memory.ObjectMemory act = Memory.getMemoryInfo(MockData.dataOne);
        Assert.assertEquals(exp.toString(), act.toString());
    }

    @Test
    public void getMemoryNull(){
        Memory.ObjectMemory exp = new Memory.ObjectMemory(1,0);
        Memory.ObjectMemory act = Memory.getMemoryInfo(MockData.dataNull);
        Assert.assertEquals(exp.toString(), act.toString());
    }

    @Test
    public void getMemoryEmpty(){
        Memory.ObjectMemory exp = new Memory.ObjectMemory(0,0);
        Memory.ObjectMemory act = Memory.getMemoryInfo(MockData.dataEmpty);
        Assert.assertEquals(exp.toString(), act.toString());
    }


}