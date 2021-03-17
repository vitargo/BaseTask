package com.bitbucket.list;

import com.bitbucket.list.exception.ListEmptyException;
import com.bitbucket.list.exception.PositionOutOfBoundListException;

public class LinkedListOnlyNext implements IList{

    private Node root;

    private static class Node {

        int value;

        Node next;

        public Node(){};
        public Node(int value) {
            this.value = value;
        }
    }


    @Override
    public void init(int[] init) {
        if (init != null) {
            for (int i = 0; i < init.length; i++) {
                addEnd(init[i]);
            }
        }
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public int size() {
        int count = 0;
        Node tmp = this.root;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    @Override
    public int[] toArray() {
        int size = size();
        if (size == 0) {
            return new int[0];
        }
        int count = 0;
        int[] array = new int[size];
        Node tmp = this.root;
        while (tmp != null) {
            array[count++] = tmp.value;
            tmp = tmp.next;
        }
        return array;
    }

    @Override
    public void addStart(int val) {
        int size = size();
        if(size == 0){
            throw new ListEmptyException();
        }
        Node tmp = new Node(val);
        tmp.next = this.root;
        this.root = tmp;
    }

    @Override
    public void addEnd(int val) {
        if (this.root == null) {
            this.root = new Node(val);
        } else {
            Node tmp = this.root;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node(val);
        }
    }

    @Override
    public void addByPos(int pos, int val) {
        int size = size();
        if(size == 0){
            throw new ListEmptyException();
        }
        if (pos < 0 || pos >= size) {
            throw new PositionOutOfBoundListException();
        }
        if (pos == 0) {
            addStart(val);
        } else if (pos == size) {
            addEnd(val);
        } else {
            Node tmp = this.root;
            Node newNode = new Node(val);
            for (int i = 0; i < pos - 1; i++) {
                tmp = tmp.next;
            }
            newNode.next = tmp.next;
            tmp.next = newNode;
        }
    }

    @Override
    public int removeStart() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int first = this.root.value;
        this.root = this.root.next;
        return first;
    }

    @Override
    public int removeEnd() {
        int size = size();
        int result;
        if (size == 0) {
            throw new ListEmptyException();
        }
        if(this.root.next == null){
            result = this.root.value;
            this.root = null;
            return result;
        }
        Node tmp = this.root;
        while(tmp.next.next != null){
            tmp = tmp.next;
        }
        result = tmp.next.value;
        tmp.next = null;
        return result;
    }

    @Override
    public int removeByPos(int pos) {
        int size = size();
        int result = 0;
        if (size == 0) {
            throw new ListEmptyException();
        }
        if (pos < 0 || pos > size) {
            throw new PositionOutOfBoundListException();
        }
        if (pos == 0) {
            result = removeStart();
        } else if (pos == size) {
            result = removeEnd();
        } else {
            Node tmp = this.root;
            for (int i = 0; i < pos - 1; i++) {
                tmp = tmp.next;
            }
            result = tmp.next.value;
            tmp.next = tmp.next.next;
        }
        return result;
    }

    @Override
    public int max() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int result = this.root.value;
        Node tmp = this.root;
        while(tmp.next != null){
            if(result < tmp.next.value){
                result = tmp.next.value;
            }
            tmp = tmp.next;
        }
        return result;
    }

    @Override
    public int min() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int result = this.root.value;
        Node tmp = this.root;
        while(tmp.next != null){
            if(result > tmp.next.value){
                result = tmp.next.value;
            }
            tmp = tmp.next;
        }
        return result;
    }

    @Override
    public int maxPos() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int result = this.root.value;
        int count = 0;
        int index = 0;
        Node tmp = this.root;
        while(tmp.next != null){
            count++;
            if(result < tmp.next.value){
                result = tmp.next.value;
                index = count;
            }
            tmp = tmp.next;
        }
        return index;
    }

    @Override
    public int minPos() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int result = this.root.value;
        int count = 0;
        int index = 0;
        Node tmp = this.root;
        while(tmp.next != null){
            count++;
            if(result > tmp.next.value){
                result = tmp.next.value;
                index = count;
            }
            tmp = tmp.next;
        }
        return index;
    }

    @Override
    public int[] sort() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        Node current = this.root;
        Node index;
        int tmp;
        while(current != null){
            index = current.next;
            while(index != null){
                if (current.value > index.value){
                    tmp = current.value;
                    current.value = index.value;
                    index.value = tmp;
                }
                index = index.next;
            }
            current = current.next;
        }
        return toArray();
    }

    @Override
    public int get(int pos) {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        if (pos < 0 || pos > size) {
            throw new PositionOutOfBoundListException();
        }
        Node tmp;
        int result;
        if (pos == 0){
            result = this.root.value;
        } else {
            tmp = this.root;
            for (int i = 0; i < pos-1; i++) {
                tmp = tmp.next;
            }
            result = tmp.next.value;
        }
        return result;
    }

    @Override
    public int[] halfRevers() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        int half;
        if(size%2 == 0){
            half = size/2;
        } else {
            half = (size+1)/2;
        }
        Node current = this.root;
        Node current2 = this.root;
        Node first = new Node(0);
        Node result = new Node(0);
        result.next = first;

        for (int i = 0; i < size; i++){
            if(i >= half){
                Node curr =  new Node(current.value);
                first.next = curr;
                first = first.next;
            }
            current = current.next;
        }
        for (int i = 0; i < half; i++){
            Node curr =  new Node(current2.value);
            first.next = curr;
            first = first.next;
            current2 = current2.next;
        }
        this.root = result.next.next;
        return toArray();
    }

    @Override
    public int[] revers() {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        Node prev = null;
        Node next;
        Node current = this.root;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.root = prev;
        return toArray();
    }

    @Override
    public void set(int pos, int val) {
        int size = size();
        if (size == 0) {
            throw new ListEmptyException();
        }
        if (pos < 0 || pos > size) {
            throw new PositionOutOfBoundListException();
        }
        if (pos == 0) {
            this.root.value = val;
        } else {
            Node tmp = this.root;
            for (int i = 0; i < pos - 1; i++) {
                tmp = tmp.next;
            }
            tmp.next.value = val;
        }
    }
}
