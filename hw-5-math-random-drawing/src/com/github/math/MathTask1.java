package com.github.math;

public class MathTask1 {
    public static void main(String[] args) {

        System.out.println("Distance of shells flight is : " + distOfFlightDegree(45, 36) + " meter(s).");

        System.out.println("Distance of shells flight is : " + distOfFlightRadian(0.7853981634, 36) + " meter(s).");
    }

    public static double distOfFlightDegree(double angleDegree, double speed){
        speed = speed/3.6;
        return ((speed * speed) * Math.round(Math.sin(angleDegree * 2)))/9.81;
    }

    public static double distOfFlightRadian(double angleRadian, double speed){
        speed = speed/3.6;
        double angle = Math.toDegrees(angleRadian);
        return ((speed * speed) * Math.round(Math.sin(angle * 2)))/9.81;
    }
}
