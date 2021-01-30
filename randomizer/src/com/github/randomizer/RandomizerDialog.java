package com.github.randomizer;

public class RandomizerDialog {
    public static void randomizer(){
        ValidateDialog.validateDialog();
        int max = ValidateDialog.max;
        int min = ValidateDialog.min;

        int[] notRepeat = new int[max-min];

        CommandDialog.commandDialog(notRepeat, max, min);

    }
}
