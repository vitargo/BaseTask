package com.github.oopone;

public class MockData {

    public  static Processor proc1 = new ProcessorX86(1.1, 2,3, ProcessorX86.ARCHITECTURE);
    public  static Processor proc2 = new ProcessorX86(2.2, 2, 3, ProcessorX86.ARCHITECTURE);
    public  static Processor proc3 = new ProcessorArm(1.1, 4,3, ProcessorArm.ARCHITECTURE);
    public  static Processor proc4 = new ProcessorArm(2.2, 4,6, ProcessorArm.ARCHITECTURE);
    public  static Processor proc5 = new ProcessorArm();
    public  static Processor proc6 = new ProcessorX86();
    public  static Memory memory1 = new Memory(new String[]{"1qQ", null});
    public  static Memory memory2 = new Memory(new String[]{"1aA", "2aA", null, null});
    public  static Memory memory3 = new Memory(new String[]{"1zZ", "2zZ", "3zZ", null, null, null});
    public  static Memory memory4 = new Memory(new String[]{"1xX", "2xX", "3xX", "4xX", null, null, null, null});
    public  static Device device1 = new Device(proc1, memory1);
    public  static Device device2 = new Device(proc2, memory2);
    public  static Device device3 = new Device(proc3, memory3);
    public  static Device device4 = new Device(proc4, memory4);

    public static Device[] deviceMany = {device1,device2,device3,device4};

    public static Device[] deviceTwo = {device1, device3};

    public static Device[] deviceOne = {device2};

    public static Device[] deviceNull = null;

    public static Device[] deviceEmpty = {};

    public static String[] dataMany = {"One", "Two", "Three"};

    public static String[] dataOne = {"One"};

    public static String[] dataEmpty = {};

    public static String[] dataNull = {null};

}
