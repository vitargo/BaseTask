package com.github.oopone;

import java.util.Arrays;

public class Memory {

    String[] memoryCell = null;

    // Поле инициализируется в конструкторе. Начальные значения – null.
    public Memory(String[] memoryCell) {
        this.memoryCell = memoryCell;
    }

    // вычитать значение из последнего записанного элемента массива (значение которого не null)
    public static String readLast(String[] memoryCell) {
        String last = null;
        for (int i = memoryCell.length - 1; i >= 0; i--) {
            if (memoryCell[i] != null) {
                last = memoryCell[i];
                break;
            }
        }
        if (last == null) throw new NullPointerException("Array is null");
        return last;
    }

    //удаление последнего элемента (записать значение null)
    public static String removeLast(String[] memoryCell) {
        try {
            int lastIndex = memoryCell.length - 1;
            memoryCell[lastIndex] = null;
        } catch (ArrayIndexOutOfBoundsException e){
            return Arrays.toString(memoryCell);
        }
        return Arrays.toString(memoryCell);
    }

    //записать в последнюю ячейку, значение которой null, вернуть true, если свободных ячеек памяти нет – вернуть false
    public static boolean save(String[] memoryCell, String newLastElement) {
        boolean result;
        try{
            if (memoryCell[memoryCell.length - 1] == null) {
                memoryCell[memoryCell.length - 1] = newLastElement;
                result = true;
            } else {
                result = false;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }

        return result;
    }

    //возвращает объект, состоящий из двух полей: общий объём памяти (количество доступных ячеек), занятый объём памяти (в процентах).
    public static ObjectMemory getMemoryInfo(String[] memoryCell) {
        ObjectMemory object = new ObjectMemory();
        object.totalMemory = memoryCell.length;
        int count = 0;
        for(int i = 0; i < memoryCell.length; i++) {
            if(memoryCell[i] != null){
                count++;
            }
        }
        try{
            object.consumeMemory =  count*100/memoryCell.length;
        } catch (ArithmeticException e){
            object.consumeMemory = 0;
        }
        return object;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "memoryCell=" + Arrays.toString(memoryCell) +
                '}';
    }

    public static class ObjectMemory {
        int totalMemory;
        int consumeMemory;

        public ObjectMemory() {
        }

        @Override
        public String toString() {
            return "ObjectMemory{" +
                    "totalMemory=" + totalMemory +
                    ", consumeMemory=" + consumeMemory +
                    '}';
        }

        public ObjectMemory(int totalMemory, int consumeMemory) {
            this.totalMemory = totalMemory;
            this.consumeMemory = consumeMemory;
        }
    }
}
