package com.github.gui.crud.commands;

import com.github.gui.crud.view.PersonDialog;

import java.awt.event.ActionListener;

public class PersonDialogCommands {

    private boolean isDialog = false;

    private PersonDialog personDialog;

    public void setPersonDialog(PersonDialog personDialog) {
        this.personDialog = personDialog;
    }

    public ActionListener actionOk() {
        return e -> {
            this.isDialog = true;
            this.personDialog.setVisible(Boolean.FALSE);
        };
    }

    public ActionListener actionCancel() {
        return e -> {
            this.isDialog = false;
            this.personDialog.setVisible(Boolean.FALSE);
        };
    }

    public boolean isDialog() {
        return isDialog;
    }
}
