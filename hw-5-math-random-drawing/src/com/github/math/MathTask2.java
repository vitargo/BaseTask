package com.github.math;

public class MathTask2 {
    public static void main(String[] args) {
        System.out.println("Distance between cars is " + distance(2, 1, 60, 50) + " kilometer(s). ");
    }
    public static double  distance(double startDistance, double time, double speed1, double speed2){
        return Math.round((speed1 * time) + startDistance + (speed2 * time));
    }
}
