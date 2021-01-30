package com.github.seasons;

public class OperateDialog {

        public static void getSeason() {
            ValidateDialog.validateDialog();
            int month = ValidateDialog.month;
            GetSeason.getSeason(month);
        }
}
