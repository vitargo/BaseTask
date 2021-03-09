package com.github.oopone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Memory memory1 = new Memory(new String[]{"AMD", "Ryzen", "Threadripper", "PRO", "3995WX", null});
        Memory memory2 = new Memory(new String[]{"AMD", "Ryzen", "Threadripper", "3990X"});
        Memory memory3 = new Memory(new String[]{"AMD", "EPYC", null, "7702"});
        Memory memory4 = new Memory(new String[]{"Intel", "Xeon", "Gold", "6248R", null, null});
        Memory memory5 = new Memory(new String[]{"Intel", "Xeon", "Gold", "6254"});
        Memory memory6 = new Memory(new String[]{"Cortex", "A15", null, null, null});
        Memory memory7 = new Memory(new String[]{"Apple", "A13", "Bionic"});
        Memory memory8 = new Memory(new String[]{"Qualcomm", "Snapdragon", "865"});
        Memory memory9 = new Memory(new String[]{"Media", "Tek", "Dimensity", "1000"});
        Memory memory10 = new Memory(new String[]{"HiSilicon", "Kirin", "990"});
        Processor proc1 = new ProcessorX86(2.7, 262144, 64, ProcessorX86.ARCHITECTURE);
        Processor proc2 = new ProcessorX86(2.9, 262144, 64, ProcessorX86.ARCHITECTURE);
        Processor proc3 = new ProcessorX86(2.0, 262144, 64, ProcessorX86.ARCHITECTURE);
        Processor proc4 = new ProcessorX86(2.933, 36608, 32, ProcessorX86.ARCHITECTURE);
        Processor proc5 = new ProcessorX86(3.1, 25344, 36, ProcessorX86.ARCHITECTURE);
        Processor proc6 = new ProcessorArm(2.5, 409600, 32, ProcessorArm.ARCHITECTURE);
        Processor proc7 = new ProcessorArm(2.66, 409600, 64, ProcessorArm.ARCHITECTURE);
        Processor proc8 = new ProcessorArm(2.84, 131072, 64, ProcessorArm.ARCHITECTURE);
        Processor proc9 = new ProcessorArm(2.84, 409600, 64, ProcessorArm.ARCHITECTURE);
        Processor proc10 = new ProcessorArm(2.86, 409600, 64, ProcessorArm.ARCHITECTURE);

        //Создать массив Device[] (не менее 10ти элементов) с различной комбинацией процессоров, памяти
        Device[] devices = new Device[10];
        devices[0] = new Device(proc1, memory1);
        devices[1] = new Device(proc2, memory2);
        devices[2] = new Device(proc3, memory3);
        devices[3] = new Device(proc4, memory4);
        devices[4] = new Device(proc5, memory5);
        devices[5] = new Device(proc6, memory6);
        devices[6] = new Device(proc7, memory7);
        devices[7] = new Device(proc8, memory8);
        devices[8] = new Device(proc9, memory9);
        devices[9] = new Device(proc10, memory10);

        //Отфильтровать девайсы по заданным критериям:

        //Девайсы с заданной архитектурой процессора;
        Device[] filterArchDevices = Device.sortByArch(devices, "X86");
        System.out.println("Devices filtered out by architecture info: ");
        for (Device device : filterArchDevices) {
            System.out.println(device.processor.toString() + device.memory.toString());
        }
        System.out.println(Arrays.toString(Device.sortByArch(devices, "X86")));

        //Фильтрация по параметрам процессора;
        //by frequency
        Device[] filterFrequencyDevices = Device.sortByProcFrequency(devices, 2.84);
        System.out.println("Devices filtered out by frequency: ");
        for (Device device : filterFrequencyDevices) {
            System.out.println(device.processor.toString() + device.memory.toString());
        }

        //by cache
        Device[] filterCacheDevices = Device.sortByProcCache(devices, 409600);
        System.out.println("Devices filtered out by cache: ");
        for (Device device : filterCacheDevices) {
            System.out.println(device.processor.toString() + device.memory.toString());
        }

        //by bitCapacity
        Device[] filterBitCapacityDevices = Device.sortByProcBitCapacity(devices, 64);
        System.out.println("Devices filtered out by bit capacity: ");
        for (Device device : filterBitCapacityDevices) {
            System.out.println(device.processor.toString() + device.memory.toString());
        }

        //Объём памяти больше/меньше заданного значения
        int filterMemoryMore = 2;
        Device[] devicesByTotalMemoryMore = Device.sortByTotalMemoryMore(devices, filterMemoryMore);
        System.out.format("Devices filtered out by total memory more then %d: ", filterMemoryMore);
        System.out.println();
        for (Device device : devicesByTotalMemoryMore) {
            System.out.println(device.processor.toString() + device.memory.toString());
        }

        int filterMemoryLess = 5;
        Device[] devicesByTotalMemoryLess = Device.sortByTotalMemoryLess(devices, filterMemoryLess);
        System.out.format("Devices filtered out by total memory less then %d: ", filterMemoryLess);
        System.out.println();
        for (Device device : devicesByTotalMemoryLess) {
            System.out.println(device.processor.toString() + device.memory.toString());
        }

        //Объём использованной памяти больше/меньше заданного значения
        int filterCMemoryMore = 5;
        Device[] devicesByConsumeMemoryMore = Device.sortByConsumeMemoryMore(devices, filterCMemoryMore);
        System.out.format("Devices filtered out by consume memory more then %d: ", filterCMemoryMore);
        System.out.println();
        for (Device device : devicesByConsumeMemoryMore) {
            System.out.println(device.processor.toString() + device.memory.toString());
        }

        int filterCMemoryLess = 45;
        Device[] devicesByConsumeMemoryLess = Device.sortByConsumeMemoryLess(devices, filterCMemoryLess);
        System.out.format("Devices filtered out by consume memory less then %d: ", filterCMemoryLess);
        System.out.println();
        for (Device device : devicesByConsumeMemoryLess) {
            System.out.println(device.processor.toString() + device.memory.toString());
        }

        System.out.println("Info: " + devices[0].getSystemInfo());

        System.out.println("Last element null - " + Memory.removeLast(memory1.memoryCell));

        System.out.println("Last element null - " + Memory.removeLast(MockData.dataMany));

        System.out.println(Arrays.toString(devices[0].readAll()));

        devices[1].dataProcessing();
    }
}
