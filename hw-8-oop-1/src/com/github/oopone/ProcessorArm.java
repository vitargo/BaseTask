package com.github.oopone;

public class ProcessorArm extends Processor{

    final public static String ARCHITECTURE = "ARM";

    public ProcessorArm() {
    }

    public ProcessorArm(double frequency, int cache, int bitCapacity, String ARCHITECTURE) {
        this.frequency = frequency;
        this.cache = cache;
        this.bitCapacity = bitCapacity;
    }

    // return Uppercase data
    @Override
    String dataProcess(String data) {
        return data.toUpperCase();
    }

    @Override
    String dataProcess(long data) {
        return Long.toString(data);
    }

    @Override
    public String getArch() {
        return ARCHITECTURE;
    }

    @Override
    public String toString() {
        return "ProcessorArm{" +
                "frequency=" + frequency +
                ", cache=" + cache +
                ", bitCapacity=" + bitCapacity +
                ", ARCHITECTURE=" + ARCHITECTURE +
                '}';
    }
}
