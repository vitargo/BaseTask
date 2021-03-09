package com.github.oopone;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Device {
    Processor processor;
    Memory memory;

    public Device() {
    }

    public Device(Processor processor, Memory memory) {
        this.processor = processor;
        this.memory = memory;
    }

    //Отфильтровать девайсы по заданным критериям:

    //Девайсы с заданной архитектурой процессора;
    public static Device[] sortByArch(Device[] devices, String findArch){
        int count = 0;
        for(Device d : devices){
            if(d.processor.getArch().equals(findArch)){
                count++;
            }
        }
        Device[] devicesByArch = new Device[count];
        count = 0;
        for (Device d : devices) {
            if (d.processor.getArch().equals(findArch)) {
                devicesByArch[count] = d;
                count++;
            }
        }
        return devicesByArch;
    }

    //Фильтрация по параметрам процессора;
    public static Device[] sortByProcFrequency(Device[] devices, double frequency){
        int count = 0;
        for(Device d : devices){
            if(d.processor.frequency == frequency){
                count++;
            }
        }
        Device[] devicesByFrequency = new Device[count];
        count = 0;
        for (Device d : devices) {
            if (d.processor.frequency == frequency) {
                devicesByFrequency[count] = d;
                count++;
            }
        }
        return devicesByFrequency;
    }

    public static Device[] sortByProcCache(Device[] devices, int cache){
        int count = 0;
        for(Device d : devices){
            if(d.processor.cache == cache){
                count++;
            }
        }
        Device[] devicesByCache = new Device[count];
        count = 0;
        for (Device d : devices) {
            if (d.processor.cache == cache) {
                devicesByCache[count] = d;
                count++;
            }
        }
        return devicesByCache;
    }

    public static Device[] sortByProcBitCapacity(Device[] devices, int bitCapacity){
        int count = 0;
        for(Device d : devices){
            if(d.processor.bitCapacity == bitCapacity){
                count++;
            }
        }
        Device[] devicesByBitCapacity = new Device[count];
        count = 0;
        for (Device d : devices) {
            if (d.processor.bitCapacity == bitCapacity) {
                devicesByBitCapacity[count] = d;
                count++;
            }
        }
        return devicesByBitCapacity;
    }

    //Объём памяти больше/меньше заданного значения
    public static Device[] sortByTotalMemoryMore(Device[] devices, int filterMemory){
        int count = 0;
        for(Device d : devices){
            Memory.ObjectMemory memory = Memory.getMemoryInfo(d.memory.memoryCell);
            if(memory.totalMemory > filterMemory){
                count++;
            }
        }
        Device[] devicesByTotalMemoryMore = new Device[count];
        count = 0;
        for (Device d : devices) {
            Memory.ObjectMemory memory = Memory.getMemoryInfo(d.memory.memoryCell);
            if(memory.totalMemory > filterMemory){
                devicesByTotalMemoryMore[count] = d;
                count++;
            }
        }
        return devicesByTotalMemoryMore;
    }

    public static Device[] sortByTotalMemoryLess(Device[] devices, int filterMemory){
        int count = 0;
        for(Device d : devices){
            Memory.ObjectMemory memory = Memory.getMemoryInfo(d.memory.memoryCell);
            if(memory.totalMemory < filterMemory){
                count++;
            }
        }
        Device[] devicesByTotalMemoryLess = new Device[count];
        count = 0;
        for (Device d : devices) {
            Memory.ObjectMemory memory = Memory.getMemoryInfo(d.memory.memoryCell);
            if(memory.totalMemory < filterMemory){
                devicesByTotalMemoryLess[count] = d;
                count++;
            }
        }
        return devicesByTotalMemoryLess;
    }

    //Объём использованной памяти больше/меньше заданного значения
    public static Device[] sortByConsumeMemoryMore(Device[] devices, int filterMemory){
        int count = 0;
        for(Device d : devices){
            Memory.ObjectMemory memory = Memory.getMemoryInfo(d.memory.memoryCell);
            if(memory.consumeMemory > filterMemory){
                count++;
            }
        }
        Device[] devicesByConsumeMemoryMore = new Device[count];
        count = 0;
        for (Device d : devices) {
            Memory.ObjectMemory memory = Memory.getMemoryInfo(d.memory.memoryCell);
            if(memory.consumeMemory > filterMemory){
                devicesByConsumeMemoryMore[count] = d;
                count++;
            }
        }
        return devicesByConsumeMemoryMore;
    }

    public static Device[] sortByConsumeMemoryLess(Device[] devices, int filterCMemory){
        int count = 0;
        for(Device d : devices){
            Memory.ObjectMemory memory = Memory.getMemoryInfo(d.memory.memoryCell);
            if(memory.consumeMemory < filterCMemory){

                count++;
            }
        }
        Device[] sortByConsumeMemoryLess = new Device[count];
        count = 0;
        for (Device d : devices) {
            Memory.ObjectMemory memory = Memory.getMemoryInfo(d.memory.memoryCell);
            if(memory.consumeMemory < filterCMemory){
                sortByConsumeMemoryLess[count] = d;
                count++;
            }
        }
        return sortByConsumeMemoryLess;
    }

    //сохранение в память всех элементов в массиве
    public static void save(String[] data){
        String[] memory = Arrays.copyOf(data, data.length);
    }

    //вычитка всех элементов из памяти, затем стирание данных
    public String[] readAll(){
        String[] readArray = this.memory.memoryCell;
        System.out.println(Arrays.toString(readArray));
        Arrays.fill(readArray, null);
        return readArray;
    }

    //преобразование всех данных, записанных в памяти
    public void dataProcessing(){
        String[] readArray = this.memory.memoryCell;
        for(int i = 0; i < readArray.length; i++){
            readArray[i] = readArray[i].toLowerCase();
        }
        System.out.println(Arrays.toString(readArray));
    }

    //получение строки с информацией о системе (информация о процессоре, памяти)
    public String getSystemInfo(){
        return "Device{" +
                "processor=" + processor.toString() +
                ", memory=" + memory.toString() +
                '}';
    }

    @Override
    public String toString() {
        return "Device{" +
                "processor=" + processor +
                ", memory=" + memory +
                '}';
    }
}
