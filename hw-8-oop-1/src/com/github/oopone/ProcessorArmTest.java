package com.github.oopone;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessorArmTest {

    @Test
    public void dataProcess2(){
        ProcessorArm s = (ProcessorArm) MockData.proc3;
        String p = s.toString();
        String exp = "PROCESSORARM{FREQUENCY=1.1, CACHE=4, BITCAPACITY=3, ARCHITECTURE=ARM}";
        String act = s.dataProcess(p);
        Assert.assertEquals(exp,act);
    }

    @Test
    public void dataProcessEmpty(){
        ProcessorArm s = (ProcessorArm) MockData.proc5;
        String p = s.toString();
        String exp = "PROCESSORARM{FREQUENCY=0.0, CACHE=0, BITCAPACITY=0, ARCHITECTURE=ARM}";
        String act = s.dataProcess(p);
        Assert.assertEquals(exp,act);
    }

    @Test
    public void dataProcess3(){
        ProcessorArm s = (ProcessorArm) MockData.proc3;
        long p = Long.valueOf(s.cache);
        String exp = "4";
        String act = s.dataProcess(p);
        Assert.assertEquals(exp,act);
    }

    @Test
    public void dataProcessEmptyA(){
        ProcessorArm s = (ProcessorArm) MockData.proc5;
        long p = (long) s.cache;
        String exp = "0";
        String act = s.dataProcess(p);
        Assert.assertEquals(exp,act);
    }
}