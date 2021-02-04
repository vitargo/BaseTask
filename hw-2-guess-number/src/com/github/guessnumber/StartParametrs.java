package com.github.guessnumber;

public class StartParametrs {

    static int min;
    static int max;
    static int attempt;

    StartParametrs(){
        ValidateDialog.validateDialog();
        min = ValidateDialog.min;
        max = ValidateDialog.max;
        attempt = ValidateDialog.attempt;
    }

    public static int getMinConstr(){
        return min;
    }
    public static int getMaxConstr(){
        return max;
    }
    public static int getAttemptConstr(){
        return attempt;
    }
}
