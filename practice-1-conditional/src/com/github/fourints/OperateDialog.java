package com.github.fourints;

public class OperateDialog {

        static int[] fourints = ValidateDialog.fourints;

        public static void operateMin() {
            ValidateDialog.validateDialog();
            System.out.println("Minimal number is " + FindMin.findMin(fourints));
        }

        public static void operateAmountMax() {
            ValidateDialog.validateDialog();
            System.out.println("Amount of maximal number is " + FindAmountMax.amoutMax(fourints));
        }
}
