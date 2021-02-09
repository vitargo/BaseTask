package com.github.math;

import java.awt.*;

public class MathTask3 {
    public static void main(String[] args) {
        System.out.println(isPointInPolygon(2,2));
    }
    private static int isPointInPolygon(double x, double y){
        int nPoints = 4;
        int[] xPoints = {0, 2, 0, -2};
        int[] yPoints = {0, 2, -1, 2};
        Polygon polygon = new Polygon(xPoints, yPoints, nPoints);
        boolean fact = polygon.contains(x, y);
        if(fact){
            return 1;
        } else{
            return 0;
        }
    }
}
