package com.github.oopone;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceTest {

    //Filter by arch

    @Test
    public void sortByArchMany() {
        Device[] exp = {MockData.device3, MockData.device4};
        Device[] act = Device.sortByArch(MockData.deviceMany, "ARM");
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByArchTwo() {
        Device[] exp = {MockData.device3};
        Device[] act = Device.sortByArch(MockData.deviceTwo, "ARM");
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByArchOne() {
        Device[] exp = {};
        Device[] act = Device.sortByArch(MockData.deviceOne, "ARM");
        Assert.assertArrayEquals(act, exp);
    }

    @Test(expected = NullPointerException.class)
    public void sortByArchNull() {
        Device.sortByArch(MockData.deviceNull, "ARM");
    }

    @Test
    public void sortByArchEmpty() {
        Device[] exp = {};
        Device[] act = Device.sortByArch(MockData.deviceEmpty, "ARM");
        Assert.assertArrayEquals(act, exp);
    }

    //Filter by frequency

    @Test
    public void sortByProcFrequencyMany() {
        Device[] exp = {MockData.device1, MockData.device3};
        Device[] act = Device.sortByProcFrequency(MockData.deviceMany, 1.1);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByProcFrequencyTwo() {
        Device[] exp = {MockData.device1, MockData.device3};
        Device[] act = Device.sortByProcFrequency(MockData.deviceTwo, 1.1);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByProcFrequencyOne() {
        Device[] exp = {MockData.device2};
        Device[] act = Device.sortByProcFrequency(MockData.deviceOne, 2.2);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByProcFrequencyEmpty() {
        Device[] exp = {};
        Device[] act = Device.sortByProcFrequency(MockData.deviceEmpty, 1.1);
        Assert.assertArrayEquals(act, exp);
    }

    //Filter by cache

    @Test
    public void sortByProcCacheMany() {
        Device[] exp = {MockData.device3, MockData.device4};
        Device[] act = Device.sortByProcCache(MockData.deviceMany, 4);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByProcCacheTwo() {
        Device[] exp = {MockData.device1};
        Device[] act = Device.sortByProcCache(MockData.deviceTwo, 2);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByProcCacheOne() {
        Device[] exp = {};
        Device[] act = Device.sortByProcCache(MockData.deviceOne, 4);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByProcCacheEmpty() {
        Device[] exp = {};
        Device[] act = Device.sortByProcCache(MockData.deviceEmpty, 4);
        Assert.assertArrayEquals(act, exp);
    }

    //Filter by capacity

    @Test
    public void sortByProcCapacityMany() {
        Device[] exp = {MockData.device1, MockData.device2, MockData.device3};
        Device[] act = Device.sortByProcBitCapacity(MockData.deviceMany, 3);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByProcCapacityTwo() {
        Device[] exp = {MockData.device1, MockData.device3};
        Device[] act = Device.sortByProcBitCapacity(MockData.deviceTwo, 3);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByProcCapacityOne() {
        Device[] exp = {MockData.device2};
        Device[] act = Device.sortByProcBitCapacity(MockData.deviceOne, 3);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByProcEmptyMany() {
        Device[] exp = {};
        Device[] act = Device.sortByProcBitCapacity(MockData.deviceEmpty, 3);
        Assert.assertArrayEquals(act, exp);
    }

    //Filter by total memory more

    @Test
    public void sortByTotalMemoryMoreMany() {
        Device[] exp = {MockData.device2, MockData.device3, MockData.device4};
        Device[] act = Device.sortByTotalMemoryMore(MockData.deviceMany, 2);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByTotalMemoryMoreTwo() {
        Device[] exp = {MockData.device3};
        Device[] act = Device.sortByTotalMemoryMore(MockData.deviceTwo, 2);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByTotalMemoryMoreOne() {
        Device[] exp = {};
        Device[] act = Device.sortByTotalMemoryMore(MockData.deviceOne, 5);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByTotalMemoryMoreEmpty() {
        Device[] exp = {};
        Device[] act = Device.sortByTotalMemoryMore(MockData.deviceEmpty, 2);
        Assert.assertArrayEquals(act, exp);
    }

    //Filter by total memory less

    @Test
    public void sortByTotalMemoryLessMany() {
        Device[] exp = {MockData.device1};
        Device[] act = Device.sortByTotalMemoryLess(MockData.deviceMany, 3);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByTotalMemoryLessTwo() {
        Device[] exp = {MockData.device1};
        Device[] act = Device.sortByTotalMemoryLess(MockData.deviceMany, 3);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByTotalMemoryLessOne() {
        Device[] exp = {};
        Device[] act = Device.sortByTotalMemoryLess(MockData.deviceOne, 3);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByTotalMemoryLessEmpty() {
        Device[] exp = {};
        Device[] act = Device.sortByTotalMemoryLess(MockData.deviceEmpty, 3);
        Assert.assertArrayEquals(act, exp);
    }

    //Filter by consume memory more

    @Test
    public void sortByConsumeMemoryMoreMany() {
        Device[] exp = {MockData.device1, MockData.device2, MockData.device3, MockData.device4};
        Device[] act = Device.sortByConsumeMemoryMore(MockData.deviceMany, 40);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByConsumeMemoryMoreTwo() {
        Device[] exp = {MockData.device1, MockData.device3};
        Device[] act = Device.sortByConsumeMemoryMore(MockData.deviceTwo, 40);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByConsumeMemoryMoreOne() {
        Device[] exp = {MockData.device2};
        Device[] act = Device.sortByConsumeMemoryMore(MockData.deviceOne, 40);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByConsumeMemoryMoreEmpty() {
        Device[] exp = {};
        Device[] act = Device.sortByConsumeMemoryMore(MockData.deviceEmpty, 40);
        Assert.assertArrayEquals(act, exp);
    }

    //Filter by consume memory less

    @Test
    public void sortByConsumeMemoryLessMany() {
        Device[] exp = {};
        Device[] act = Device.sortByConsumeMemoryLess(MockData.deviceMany, 40);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByConsumeMemoryLessTwo() {
        Device[] exp = {MockData.device1, MockData.device3};
        Device[] act = Device.sortByConsumeMemoryLess(MockData.deviceTwo, 60);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByConsumeMemoryLessOne() {
        Device[] exp = {MockData.device2};
        Device[] act = Device.sortByConsumeMemoryLess(MockData.deviceOne, 60);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void sortByConsumeMemoryLessEmpty() {
        Device[] exp = {};
        Device[] act = Device.sortByConsumeMemoryLess(MockData.deviceEmpty, 60);
        Assert.assertArrayEquals(act, exp);
    }

    @Test
    public void getSystemInfo() {
        String exp = "Device{processor=ProcessorArm{frequency=1.1, cache=2, bitCapacity=3, ARCHITECTURE=X86}, memory=Memory{memoryCell=[1qQ, null]}}";
        String act = MockData.device1.getSystemInfo();
        Assert.assertEquals(exp, act);
    }
}