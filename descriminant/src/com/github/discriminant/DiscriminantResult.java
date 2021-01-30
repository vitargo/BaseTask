package com.github.discriminant;

public class DiscriminantResult {

    public static void result(int a, int b, int c){

        int discriminant = disciminantResult(a, b, c);

        if (discriminant > 0){
            System.out.println("Discriminant is " + discriminant + ". Positive. Two solutions.");
        }
        else if (discriminant == 0){
            System.out.println("Discriminant is " + discriminant + ". Zero. One solution.");
        }
        else {
            System.out.println("Discriminant is "+ discriminant + ". Negative. No solution.");
        }
    }

    private static int disciminantResult(int a, int b, int c) {
        return (int)Math.pow(b,2) - (4*a*c);
    }
}

