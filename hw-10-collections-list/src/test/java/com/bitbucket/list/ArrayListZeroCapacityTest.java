package com.bitbucket.list;

import com.bitbucket.list.exception.ListEmptyException;
import com.bitbucket.list.exception.PositionOutOfBoundListException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayListZeroCapacityTest {

    //private final IList list = new ArrayListZeroCapacity();

    private final String name;

    private final IList list;

    public ArrayListZeroCapacityTest(String name, IList list) {
        this.name = name;
        this.list = list;
    }

    @Before
    public void setUp() {
        this.list.clear();
    }

    @Parameterized.Parameters(name = "{index} {0}")
    public static Collection<Object[]> instances() {
        return Arrays.asList(new Object[][] {
                {"Array List Zero Capacity", new ArrayListZeroCapacity()},
                {"Linked List Only Next", new LinkedListOnlyNext()},
        });
    }

    //=================================================
    //=================== Clean =======================
    //=================================================

    @Test
    public void clearMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, 4343, 123, 5644, 34, 12};
        this.list.init(array);
        this.list.clear();
        int[] exp = {};
        int[] act = this.list.toArray();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void clearTwo() {
        int[] array = new int[]{1, 232};
        this.list.init(array);
        this.list.clear();
        int[] exp = {};
        int[] act = this.list.toArray();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void clearOne() {
        int[] array = new int[]{1};
        this.list.init(array);
        this.list.clear();
        int[] exp = {};
        int[] act = this.list.toArray();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void clearZero() {
        int[] array = {};
        this.list.init(array);
        this.list.clear();
        int[] exp = {};
        int[] act = this.list.toArray();
        Assert.assertArrayEquals(exp, act);
    }

    //=================================================
    //=================== Size ========================
    //=================================================

    @Test
    public void sizeMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, 4343, 123, 5644, 34, 12};
        this.list.init(array);
        int exp = 10;
        int act = this.list.size();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sizeTwo() {
        int[] array = new int[]{1, 232};
        this.list.init(array);
        int exp = 2;
        int act = this.list.size();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sizeOne() {
        int[] array = new int[]{1};
        this.list.init(array);
        int exp = 1;
        int act = this.list.size();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void sizeZero() {
        int[] array = new int[]{};
        this.list.init(array);
        int exp = 0;
        int act = this.list.size();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    //=================================================
    //=================== Add Start ===================
    //=================================================

    @Test
    public void addStartMany() {
        int[] array = new int[]{232, 43432, 123, 543, 4343, 123, 5644, 34, 12, 44};
        this.list.init(array);
        int[] exp = {1, 232, 43432, 123, 543, 4343, 123, 5644, 34, 12, 44};
        this.list.addStart(1);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void addStartMany2() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        this.list.init(array);
        int[] exp = {0, 1, 2, 3, 4, 5};
        this.list.addStart(0);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void addStartTwo() {
        int[] array = new int[]{232, 43432};
        this.list.init(array);
        int[] exp = {1, 232, 43432};
        this.list.addStart(1);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }
    @Test
    public void addStartOne() {
        int[] array = new int[]{232};
        this.list.init(array);
        int[] exp = {1, 232};
        this.list.addStart(1);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void addStartZero() {
        int[] array = new int[0];
        this.list.init(array);
        this.list.addStart(1);
        this.list.clear();
    }

    //=================================================
    //=================== Add End =====================
    //=================================================

    @Test
    public void addEndMany() {
        int[] array = new int[]{232, 43432, 123, 543, 4343, 123, 5644, 34};
        this.list.init(array);
        int[] exp = {232, 43432, 123, 543, 4343, 123, 5644, 34, 12};
        this.list.addEnd(12);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void addEndMany2() {
        int[] array = new int[]{5, 3, 1, 0, -6};
        this.list.init(array);
        int[] exp = {5, 3, 1, 0, -6, -45};
        this.list.addEnd(-45);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void addEndTwo() {
        int[] array = new int[]{232, 43432};
        this.list.init(array);
        int[] exp = {232, 43432,12};
        this.list.addEnd(12);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }
    @Test
    public void addEndOne() {
        int[] array = new int[]{232};
        this.list.init(array);
        int[] exp = {232, 12};
        this.list.addEnd(12);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void addEndZero() {
        int[] array = new int[0];
        this.list.init(array);
        this.list.addEnd(12);
        int[] act = this.list.toArray();
        this.list.clear();
    }


    //=================================================
    //=================== Add by Pos ==================
    //=================================================

    @Test
    public void addByPosMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, 4343, 123, 5644, 34};
        this.list.init(array);
        int[] exp = {1, 232, 43432, 123, 543, 4343, 123, 31, 5644, 34};
        this.list.addByPos(7,31);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void addByPosMany2() {
        int[] array = new int[]{56000, -45, 6777, 3, 5};
        this.list.init(array);
        int[] exp = {56000, -45, 31, 6777, 3, 5};
        this.list.addByPos(2,31);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void addByPosManyStart() {
        int[] array = new int[]{56000, -45, 6777, 3, 5};
        this.list.init(array);
        int[] exp = {11, 56000, -45, 6777, 3, 5};
        this.list.addByPos(0,11);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void addByPosManyEnd() {
        int[] array = new int[]{56000, -45, 6777, 3, 5};
        this.list.init(array);
        int[] exp = {56000, -45, 6777, 3, 31, 5};
        this.list.addByPos(4,31);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test (expected = PositionOutOfBoundListException.class)
    public void addByPosManyEndNotExcistPosition() {
        int[] array = new int[]{56000, -45, 6777, 3, 5};
        this.list.init(array);
        this.list.addByPos(5,31);
        int[] act = this.list.toArray();
        this.list.clear();
    }

    @Test
    public void addByPosTwo() {
        int[] array = new int[]{232, 43432};
        this.list.init(array);
        int[] exp = {232, 31, 43432};
        this.list.addByPos(1,31);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }
    @Test
    public void addByPosOne() {
        int[] array = new int[]{232};
        this.list.init(array);
        int[] exp = {12, 232};
        this.list.addByPos(0, 12);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test (expected = PositionOutOfBoundListException.class)
    public void addByPosOne2() {
        int[] array = new int[]{232};
        this.list.init(array);
        this.list.addByPos(1, 12);
        int[] act = this.list.toArray();
        this.list.clear();
    }

    @Test (expected = ListEmptyException.class)
    public void addByPosZero() {
        int[] array = new int[0];
        this.list.init(array);
        this.list.addByPos(0,12);
        this.list.clear();
    }

    @Test(expected = PositionOutOfBoundListException.class)
    public void addByPosNotExistPos() {
        int[] array = new int[]{232, 43432};
        this.list.init(array);
        this.list.addByPos(10,12);
        this.list.clear();
    }

    //=================================================
    //=================== Remove Start ================
    //=================================================

    @Test
    public void removeStartMany() {
        int[] array = new int[]{232, 43432, 123, 543, 4343, 123, 5644, 34, 12};
        this.list.init(array);
        int expNum = 232;
        int[] exp = {43432, 123, 543, 4343, 123, 5644, 34, 12};
        int actNum = this.list.removeStart();
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void removeStartMany2() {
        int[] array = new int[]{-1, 0, 3, 6, 9};
        this.list.init(array);
        int expNum = -1;
        int[] exp = {0, 3, 6, 9};
        int actNum = this.list.removeStart();
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void removeStartTwo() {
        int[] array = new int[]{232, 43432};
        this.list.init(array);
        int expNum = 232;
        int[] exp = {43432};
        int actNum = this.list.removeStart();
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }
    @Test
    public void removeStartOne() {
        int[] array = new int[]{232};
        this.list.init(array);
        int expNum = 232;
        int[] exp = {};
        int actNum = this.list.removeStart();
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void removeStartZero() {
        int[] array = new int[0];
        this.list.init(array);
        int actNum = this.list.removeStart();
        int[] act = this.list.toArray();
        this.list.clear();
    }

    //=================================================
    //=================== remove End ==================
    //=================================================

    @Test
    public void removeEndMany() {
        int[] array = new int[]{232, 43432, 123, 543, 4343, 123, 5644, 34, 12};
        this.list.init(array);
        int expNum = 12;
        int[] exp = {232, 43432, 123, 543, 4343, 123, 5644, 34};
        int actNum = this.list.removeEnd();
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void removeEndMany2() {
        int[] array = new int[]{-1, 0, 3, 6, 9};
        this.list.init(array);
        int expNum = 9;
        int[] exp = {-1, 0, 3, 6};
        int actNum = this.list.removeEnd();
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void removeEndTwo() {
        int[] array = new int[]{232, 43432};
        this.list.init(array);
        int expNum = 43432;
        int[] exp = {232};
        int actNum = this.list.removeEnd();
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }
    @Test
    public void removeEndOne() {
        int[] array = new int[]{232};
        this.list.init(array);
        int expNum = 232;
        int[] exp = {};
        int actNum = this.list.removeEnd();
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void removeEndZero() {
        int[] array = new int[0];
        this.list.init(array);
        int actNum = this.list.removeEnd();
        int[] act = this.list.toArray();
        this.list.clear();
    }


    //=================================================
    //=================== Remove by Pos ===============
    //=================================================

    @Test
    public void removeByPosMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, 4343, 123, 5644, 34};
        this.list.init(array);
        int expNum = 43432;
        int[] exp = {1, 232, 123, 543, 4343, 123, 5644, 34};
        int actNum = this.list.removeByPos(2);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void removeByPosManyStart() {
        int[] array = new int[]{1, 232, 43432, 123, 543, 4343, 123, 5644, 34};
        this.list.init(array);
        int expNum = 1;
        int[] exp = {232, 43432, 123, 543, 4343, 123, 5644, 34};
        int actNum = this.list.removeByPos(0);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void removeByPosManyEnd() {
        int[] array = new int[]{1, 232, 43432, 123, 543, 4343, 123, 5644, 34};
        this.list.init(array);
        int expNum = 34;
        int[] exp = {1, 232, 43432, 123, 543, 4343, 123, 5644};
        int actNum = this.list.removeByPos(8);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void removeByPosMany2() {
        int[] array = new int[]{-5, 7, 3, 78};
        this.list.init(array);
        int expNum = 7;
        int[] exp = {-5, 3, 78};
        int actNum = this.list.removeByPos(1);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void removeByPosTwo() {
        int[] array = new int[]{232, 43432};
        this.list.init(array);
        int expNum = 43432;
        int[] exp = {232};
        int actNum = this.list.removeByPos(1);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }
    @Test
    public void removeByPosOne() {
        int[] array = new int[]{232};
        this.list.init(array);
        int expNum = 232;
        int[] exp = {};
        int actNum = this.list.removeByPos(0);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertEquals(expNum, actNum);
        Assert.assertArrayEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void removeByPosZero() {
        int[] array = new int[0];
        this.list.init(array);
        int actNum = this.list.removeByPos(0);
        int[] act = this.list.toArray();
        this.list.clear();
    }

    @Test(expected = PositionOutOfBoundListException.class)
    public void removeByPosNotExistPos() {
        int[] array = new int[]{232, 43432};
        this.list.init(array);
        this.list.removeByPos(10);
        this.list.clear();
    }


    //=================================================
    //=================== Max ========================
    //=================================================

    @Test
    public void maxMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, 4343, 123, 5644, 34, 12};
        this.list.init(array);
        int exp = 43432;
        int act = this.list.max();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void maxMany2() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        this.list.init(array);
        int exp = 5;
        int act = this.list.max();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void maxTwo() {
        int[] array = new int[]{1, 232};
        this.list.init(array);
        int exp = 232;
        int act = this.list.max();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void maxOne() {
        int[] array = new int[]{1};
        this.list.init(array);
        int exp = 1;
        int act = this.list.max();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void maxZero() {
        int[] array = new int[0];
        this.list.init(array);
        int act = this.list.max();
        this.list.clear();
    }


    //=================================================
    //=================== Min ========================
    //=================================================

    @Test
    public void minMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, -4343, 123, 5644, 34, 12};
        this.list.init(array);
        int exp = -4343;
        int act = this.list.min();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void minMany2() {
        int[] array = new int[]{-1, -2, -3, 0, -5};
        this.list.init(array);
        int exp = -5;
        int act = this.list.min();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void minTwo() {
        int[] array = new int[]{1, 232};
        this.list.init(array);
        int exp = 1;
        int act = this.list.min();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void minOne() {
        int[] array = new int[]{1};
        this.list.init(array);
        int exp = 1;
        int act = this.list.min();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void minZero() {
        int[] array = new int[0];
        this.list.init(array);
        int act = this.list.min();
        this.list.clear();
    }


    //=================================================
    //=================== Max Pos =====================
    //=================================================

    @Test
    public void maxPosMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, 4343, 123, 5644, 34, 12};
        this.list.init(array);
        int exp = 2;
        int act = this.list.maxPos();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void maxPosMany2() {
        int[] array = new int[]{6, 8, 3, 12, -7, 9};
        this.list.init(array);
        int exp = 3;
        int act = this.list.maxPos();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void maxPosTwo() {
        int[] array = new int[]{1, 232};
        this.list.init(array);
        int exp = 1;
        int act = this.list.maxPos();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void maxPosOne() {
        int[] array = new int[]{1};
        this.list.init(array);
        int exp = 0;
        int act = this.list.maxPos();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void maxPosZero() {
        int[] array = new int[0];
        this.list.init(array);
        int act = this.list.max();
        this.list.clear();
    }

    //=================================================
    //=================== Min Pos =====================
    //=================================================

    @Test
    public void minPosMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, -4343, 123, 5644, 34, 12};
        this.list.init(array);
        int exp = 5;
        int act = this.list.minPos();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void minPosMany2() {
        int[] array = new int[]{6, 8, 3, 12, -7, 9};
        this.list.init(array);
        int exp = 4;
        int act = this.list.minPos();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void minPosTwo() {
        int[] array = new int[]{1, 232};
        this.list.init(array);
        int exp = 0;
        int act = this.list.minPos();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void minPosOne() {
        int[] array = new int[]{1};
        this.list.init(array);
        int exp = 0;
        int act = this.list.minPos();
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void minPosZero() {
        int[] array = new int[0];
        this.list.init(array);
        int act = this.list.minPos();
        this.list.clear();
    }


    //=================================================
    //=================== Get ========================
    //=================================================

    @Test
    public void getMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, 4343, 123, 5644, 34, 12};
        this.list.init(array);
        int exp = 123;
        int act = this.list.get(3);
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void getMany2() {
        int[] array = new int[]{-4, 6, 2, 8};
        this.list.init(array);
        int exp = -4;
        int act = this.list.get(0);
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void getTwo() {
        int[] array = new int[]{1, 232};
        this.list.init(array);
        int exp = 1;
        int act = this.list.get(0);
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void getOne() {
        int[] array = new int[]{1};
        this.list.init(array);
        int exp = 1;
        int act = this.list.get(0);
        this.list.clear();
        Assert.assertEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void getZero() {
        int[] array = new int[0];
        this.list.init(array);
        int act = this.list.get(10);
        this.list.clear();
    }

    //=================================================
    //=================== halfRevers =====================
    //=================================================

    @Test
    public void halfReversMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, -4343, 123, 5644, 34, 12};
        this.list.init(array);
        int[] exp = {-4343, 123, 5644, 34, 12, 1, 232, 43432, 123, 543};
        int[] act = this.list.halfRevers();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void halfReversMany2() {
        int[] array = new int[]{-1, 0, 1, 3, 7};
        this.list.init(array);
        int[] exp = {3, 7, -1, 0, 1};
        int[] act = this.list.halfRevers();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void halfReversTwo() {
        int[] array = new int[]{1, 232};
        this.list.init(array);
        int[] exp = {232,1};
        int[] act = this.list.halfRevers();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void halfReversOne() {
        int[] array = new int[]{1};
        this.list.init(array);
        int[] exp = {1};
        int[] act = this.list.halfRevers();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void halfReversZero() {
        int[] array = new int[0];
        this.list.init(array);
        int[] act = this.list.halfRevers();
        this.list.clear();
    }

    //=================================================
    //=================== Sort ========================
    //=================================================

    @Test
    public void sortMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, -4343, 123, 5644, 34, 12};
        this.list.init(array);
        int[] exp = {-4343, 1, 12, 34, 123, 123, 232, 543, 5644, 43432};
        int[] act = this.list.sort();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void sortMany2() {
        int[] array = new int[]{-234, 56000, 1, 7, -23, 0, 54, 333};
        this.list.init(array);
        int[] exp = {-234, -23, 0, 1, 7, 54, 333, 56000};
        int[] act = this.list.sort();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void sortMany3() {
        int[] array = new int[]{4, 7, 2};
        this.list.init(array);
        int[] exp = {2, 4, 7};
        int[] act = this.list.sort();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void sortTwo() {
        int[] array = new int[]{1, 232};
        this.list.init(array);
        int[] exp = {1, 232};
        int[] act = this.list.sort();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void sortOne() {
        int[] array = new int[]{1};
        this.list.init(array);
        int[] exp = {1};
        int[] act = this.list.sort();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void sortZero() {
        int[] array = new int[0];
        this.list.init(array);
        int[] act = this.list.sort();
        this.list.clear();
    }
    //=================================================
    //=================== Revers ======================
    //=================================================

    @Test
    public void reversMany() {
        int[] array = new int[]{1, 232, 43432, 123, 543, -4343, 123, 5644, 34, 12};
        this.list.init(array);
        int[] exp = {12, 34, 5644, 123, -4343, 543, 123, 43432, 232, 1};
        int[] act = this.list.revers();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void reversMany2() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        this.list.init(array);
        int[] exp = {5, 4, 3, 2, 1};
        int[] act = this.list.revers();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void reversTwo() {
        int[] array = new int[]{1, 232};
        this.list.init(array);
        int[] exp = {232,1};
        int[] act = this.list.revers();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void reversOne() {
        int[] array = new int[]{1};
        this.list.init(array);
        int[] exp = {1};
        int[] act = this.list.revers();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void reversZero() {
        int[] array = new int[0];
        this.list.init(array);
        int[] act = this.list.revers();
        this.list.clear();
    }


    //=================================================
    //=================== Set =========================
    //=================================================

    @Test
    public void setMany() {
        int[] array = new int[]{232, 43432, 123, 543, 4343, 123, 5644, 34, 12};
        this.list.init(array);
        int[] exp = {232, 43432, 123, 543, 5000, 123, 5644, 34, 12};
        this.list.set(4,5000);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void setMany2() {
        int[] array = new int[]{0, 1, 2, 3, 4, 5};
        this.list.init(array);
        int[] exp = {0, 1, 999, 3, 4, 5};
        this.list.set(2,999);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void setTwo() {
        int[] array = new int[]{232, 43432};
        this.list.init(array);
        int[] exp = {232, 5000};
        this.list.set(1,5000);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }
    @Test
    public void setOne() {
        int[] array = new int[]{232};
        this.list.init(array);
        int[] exp = {1};
        this.list.set(0, 1);
        int[] act = this.list.toArray();
        this.list.clear();
        Assert.assertArrayEquals(exp, act);
    }

    @Test (expected = ListEmptyException.class)
    public void setZero() {
        int[] array = new int[0];
        this.list.init(array);
        this.list.set(0,1);
        int[] act = this.list.toArray();
        this.list.clear();
    }

    @Test (expected = PositionOutOfBoundListException.class)
    public void setPositionOut() {
        int[] array = new int[]{232, 344, 6};
        this.list.init(array);
        this.list.addByPos(4, 12);
        int[] act = this.list.toArray();
        this.list.clear();
    }

}