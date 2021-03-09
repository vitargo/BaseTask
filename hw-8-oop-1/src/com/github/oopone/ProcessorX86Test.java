package com.github.oopone;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ProcessorX86Test {
    
    @Test
    public void dataProcess(){
        ProcessorX86 s = (ProcessorX86) MockData.proc1;
        String p = s.toString();
        String exp = "processorarm{frequency=1.1, cache=2, bitcapacity=3, architecture=x86}";
        String act = s.dataProcess(p);
        Assert.assertEquals(exp,act);
    }

    @Test
    public void dataProcess2(){
        ProcessorX86 s = (ProcessorX86) MockData.proc2;
        String p = s.toString();
        String exp = "processorarm{frequency=2.2, cache=2, bitcapacity=3, architecture=x86}";
        String act = s.dataProcess(p);
        Assert.assertEquals(exp,act);
    }

    @Test
    public void dataProcessEmpty(){
        ProcessorX86 s = (ProcessorX86) MockData.proc6;
        String p = s.toString();
        String exp = "processorarm{frequency=0.0, cache=0, bitcapacity=0, architecture=x86}";
        String act = s.dataProcess(p);
        Assert.assertEquals(exp,act);
    }

    @Test
    public void dataProcessEmptyX(){
        ProcessorX86 s = (ProcessorX86) MockData.proc6;
        long p = (long) s.cache;
        String exp = "0";
        String act = s.dataProcess(p);
        Assert.assertEquals(exp,act);
    }
}