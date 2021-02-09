package com.github.math;

public class MathTask4 {
    public static void main(String[] args) {
        int b = 1;
        int x = 2;

        double z = 6 * Math.log((Math.sqrt(Math.pow(b, x + 1) + (2 * Math.pow(b, x) * Math.cos(x))) / Math.log(x - Math.pow(b, x + 1) * Math.sin(x))) + Math.abs(Math.cos(x) / Math.pow(b, Math.sin(x))));
        System.out.println(z);
    }
}
