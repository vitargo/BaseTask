package com.github.oopone;

public abstract class Processor {
    public double frequency;
    public int cache;
    public int bitCapacity;

    // getDetails(), который возвращает технические характеристики процессора (значения полей в виде строки)

    String getDetail() {
        return "Processor{" +
                "frequency=" + frequency +
                ", cache=" + cache +
                ", bitCapacity=" + bitCapacity +
                '}';
    }

    //String dataProcess(String data) – абстрактный метод

    abstract String dataProcess(String data);

    //String dataProcess(long data) – абстрактный метод

    abstract String dataProcess(long data);

    abstract String getArch();

}
