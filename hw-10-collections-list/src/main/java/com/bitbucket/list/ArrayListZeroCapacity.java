package com.bitbucket.list;

import com.bitbucket.list.exception.ListEmptyException;
import com.bitbucket.list.exception.PositionOutOfBoundListException;

public class ArrayListZeroCapacity implements IList{

    private int[] array = new int[0];

    @Override
    public void init(int[] init) {
        if (init == null) {
            this.array = new int[0];
        } else {
            this.array = new int[init.length];
            for (int i = 0; i < init.length; i++) {
                this.array[i] = init[i];
            }
        }
    }

    @Override
    public void clear() {
        this.array = new int[0];
    }

    @Override
    public int size() {
        return this.array.length;
    }

    @Override
    public int[] toArray() {
        int size = size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = this.array[i];
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            str.append(this.array[i]).append(", ");
        }
        return str.toString();
    }

    @Override
    public void addStart(int val) {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int[] tmp = new int[size + 1];
        for (int i = 0; i < size; i++) {
            tmp[i + 1] = this.array[i];
        }
        tmp[0] = val;
        this.array = tmp;
    }

    @Override
    public void addEnd(int val) {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int[] tmp = new int[size + 1];
        for (int i = 0; i < size; i++) {
            tmp[i] = this.array[i];
        }
        tmp[size] = val;
        this.array = tmp;
    }

    @Override
    public void addByPos(int pos, int val) {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        if (pos < 0 || pos >= size) {
            throw new PositionOutOfBoundListException();
        }
        int[] tmp = new int[size + 1];
        for (int i = 0; i < pos; i++) {
            tmp[i] = this.array[i];
        }
        tmp[pos] = val;
        for (int j = pos+1; j < size+1; j++){
            tmp[j] = this.array[j-1];
        }
        this.array = tmp;
    }

    @Override
    public int removeStart() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int[] tmp = new int[size - 1];
        int remove = this.array[0];
        for (int i = 0; i < size-1; i++) {
            tmp[i] = this.array[i+1];
        }
        this.array = tmp;
        return remove;
    }

    @Override
    public int removeEnd() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int[] tmp = new int[size - 1];
        int remove = this.array[size-1];
        for (int i = 0; i < size-1; i++) {
            tmp[i] = this.array[i];
        }
        this.array = tmp;
        return remove;
    }

    @Override
    public int removeByPos(int pos) {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        if (pos < 0 || pos >= size) {
            throw new PositionOutOfBoundListException();
        }
        int[] tmp = new int[size - 1];
        int remove = this.array[pos];
        for (int i = 0; i < size-1; i++) {
            if(pos <= i){
                tmp[i] = this.array[i+1];
            } else {
                tmp[i] = this.array[i];
            }
        }
        this.array = tmp;
        return remove;
    }

    @Override
    public int max() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int max = this.array[0];
        for (int i = 1; i < size; i++){
            if (this.array[i] > max){
                max = this.array[i];
            }
        }
        return max;
    }

    @Override
    public int min() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int min = this.array[0];
        for (int i = 1; i < size; i++){
            if (this.array[i] < min){
                min = this.array[i];
            }
        }
        return min;
    }

    @Override
    public int maxPos() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int max = this.array[0];
        int index = 0;
        for (int i = 1; i < size; i++){
            if (this.array[i] > max){
                max = this.array[i];
                index = i;
            }
        }
        return index;
    }

    @Override
    public int minPos() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int min = this.array[0];
        int index = 0;
        for (int i = 1; i < size; i++){
            if (this.array[i] < min){
                min = this.array[i];
                index = i;
            }
        }
        return index;
    }

    @Override
    public int[] sort() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size-i-1; j++){
                if(this.array[j] > this.array[j+1]){
                    int temp = this.array[j];
                    this.array[j] = this.array[j+1];
                    this.array[j+1] = temp;
                }
            }
        }
        return this.array;
    }

    @Override
    public int get(int pos) {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        if (pos < 0 || pos >= size) {
            throw new PositionOutOfBoundListException();
        }
        return this.array[pos];
    }

    @Override
    public int[] halfRevers() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int[] result = new int[size];
        int half;
        if(size%2 == 0){
            half = size/2;
        } else {
            half = (size+1)/2;
        }
        for (int i = half; i < size; i++){
            result[i-half] = this.array[i];
        }
        for (int j = 0; j < half; j++){
            result [j+size-half] = this.array[j];
        }
        return result;
    }

    @Override
    public int[] revers() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int[] result = new int[size];
        for (int i = 0; i < size; i++){
            result[i] = this.array[size-1-i];
        }
        return result;
    }

    @Override
    public void set(int pos, int val) {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        if (pos < 0 || pos >= size) {
            throw new PositionOutOfBoundListException();
        }
        int[] tmp = new int[size];
        for (int i = 0; i < size; i++) {
            if (pos == i){
                tmp[i] = val;
            } else {
                tmp[i] = this.array[i];
            }
        }
        this.array = tmp;
    }
}
