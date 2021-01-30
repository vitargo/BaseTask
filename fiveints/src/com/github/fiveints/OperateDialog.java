package com.github.fiveints;

public class OperateDialog {

        public static void operateMinMax() {
            ValidateDialog.validateDialog();
            int[] fiveints = ValidateDialog.fiveints;
            System.out.println("Minimal number is " + FindMinMax.findMin(fiveints));
            System.out.println("Maximal number is " + FindMinMax.findMax(fiveints));
        }
}
