package com.github.samename;

public class OperateDialog {

    public static void operateNamesake() {
        ValidateDialog.validateDialog();
        String name1 = ValidateDialog.name1;
        String name2 = ValidateDialog.name2;
        if(CompareNames.compareNames(name1, name2)){
            System.out.println("The people are namesake.");
        } else {
            System.out.println("This is different names.");
        }
    }
}