package com.github.basetask.conditionaloperators;

import java.util.Scanner;

public class ConditionalOperatorsTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the coordinate x (int):");
        int x = scan.nextInt();
        System.out.println("Enter the coordinate y (int):");
        int y = scan.nextInt();
        int result = decartQuadrant(x, y);

        if(result == 1){
            System.out.println ("I Quadrant");
        } else if(result == 2){
            System.out.println ("II Quadrant");
        } else if(result == 3){
            System.out.println ("III Quadrant");
        } else if(result == 4){
            System.out.println ("IV Quadrant");
        } else if(result == 0){
            System.out.println ("Origin");
        } else {
            System.out.println ("Point lies on the axis");
        }
    }

    public static int decartQuadrant(int x, int y){
        int result = -1;
        if(x > 0 && y > 0){
            result = 1 ;
        } else if(x < 0 && y > 0){
            result = 2;
        } else if(x < 0 && y < 0){
            result = 3;
        } else if(x > 0 && y < 0){
            result = 4;
        } else if(x == 0 && y == 0){
            result = 0;
        }
        return result;
    }
}
