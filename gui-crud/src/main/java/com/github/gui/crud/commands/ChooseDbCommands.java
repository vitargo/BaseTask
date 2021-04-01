package com.github.gui.crud.commands;

import com.github.gui.crud.config.DataBaseConfig;
import com.github.gui.crud.config.type.DataBaseType;
import com.github.gui.crud.entity.Person;
import com.github.gui.crud.models.PeopleTableModel;
import com.github.gui.crud.view.PeopleTablePanel;
import com.github.gui.crud.view.PersonDialog;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ChooseDbCommands {

    private final PeopleTableModel peopleTableModel;
    private final PersonDialog personDialog;
    private final PeopleTablePanel peopleTablePanel;

    public ChooseDbCommands(PeopleTableModel peopleTableModel, PersonDialog personDialog, PeopleTablePanel peopleTablePanel) {
        this.peopleTableModel = peopleTableModel;
        this.personDialog = personDialog;
        this.peopleTablePanel = peopleTablePanel;
    }

    public ActionListener chooseDataBase() {
        return e -> {
            JComboBox<String> dataBaseNameSource = (JComboBox) e.getSource();
            String dataBaseName = (String) dataBaseNameSource.getSelectedItem();
            this.peopleTableModel.setPeopleService(DataBaseConfig.newInstance(DataBaseType.from(dataBaseName)));
            read();
        };
    }

    public ActionListener actionCreate() {
        return e -> {
            this.personDialog.setVisible(Boolean.TRUE);
            if (this.personDialog.isDialog()) {
                Person person = this.personDialog.getPerson();
                this.peopleTableModel.create(person);
                this.personDialog.clear();
                read();
            }
        };
    }

    public ActionListener actionRead() {
        return e -> {
            read();
        };
    }

    public ActionListener actionUpdate() {
        return e -> {
            long selectedPeopleId = getSelectedPeopleId();
            this.personDialog.setVisibleId(false);
            this.personDialog.setVisible(Boolean.TRUE);
            if (this.personDialog.isDialog()) {
                Person person = this.personDialog.getPerson();
                person.setId(selectedPeopleId);
                this.peopleTableModel.update(selectedPeopleId, person);
                this.personDialog.clear();
                read();
            }
            this.personDialog.setVisibleId(true);
        };
    }

    public ActionListener actionDelete() {
        return e -> {
            this.peopleTableModel.delete(getSelectedPeopleId());
            read();
        };
    }

    private long getSelectedPeopleId() {
        JTable peopleTable = peopleTablePanel.getPeopleTable();
        int selectedRow = peopleTable.getSelectedRow();
        return (long) peopleTable.getValueAt(selectedRow, 0);
    }

    private void read() {
        peopleTablePanel.peopleTableModel().refresh();
        this.peopleTablePanel.getPeopleTable().revalidate();
        peopleTablePanel.repaint();
    }
}
