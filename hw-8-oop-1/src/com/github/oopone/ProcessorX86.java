package com.github.oopone;

public class ProcessorX86 extends Processor{

    final public static String ARCHITECTURE = "X86";

    public ProcessorX86() {
    }

    public ProcessorX86(double frequency, int cache, int bitCapacity) {
        this.frequency = frequency;
        this.cache = cache;
        this.bitCapacity = bitCapacity;
    }

    public ProcessorX86(double frequency, int cache, int bitCapacity, String ARCHITECTURE) {
        this.frequency = frequency;
        this.cache = cache;
        this.bitCapacity = bitCapacity;
    }

    // return Lowercase data
    @Override
    String dataProcess(String data) {
        return data.toLowerCase();
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
