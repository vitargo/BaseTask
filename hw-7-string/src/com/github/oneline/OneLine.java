package com.github.oneline;

public class OneLine {
    public static void main(String[] args) {

        printOneLine('A','Z');

        printOneLineConvert('z','a');

        printOneLine('а','я');

        printOneLine('0','9');

        printOneLine((char) 32,(char) 127);

    }
    public static void printOneLine (char start, char finish){
        for(int i = start; i < finish+1; i++){
            System.out.print((char) i + " ");
        }
        System.out.println();
    }

    public static void printOneLineConvert (char start, char finish){
        for(int i = start; i > finish-1; i--){
            System.out.print((char) i + " ");
        }
        System.out.println();
    }
}
