package com.github.gui.crud.view;

import com.github.gui.crud.models.PeopleTableModel;

import javax.swing.*;

public class PeopleTablePanel extends JPanel {

    private final PeopleTableModel peopleTableModel;

    public PeopleTableModel peopleTableModel() {
        return peopleTableModel;
    }

    private JTable peopleTable;

    public PeopleTablePanel(PeopleTableModel peopleTableModel) {
        setLayout(null);
        setBounds(325, 8, 955, 845);
        this.peopleTableModel = peopleTableModel;
        this.peopleTable = new JTable(peopleTableModel);
        JScrollPane scr = new JScrollPane(this.peopleTable);
        scr.setBounds(5, 5, 945, 835);
        add(scr);
        setVisible(Boolean.TRUE);
    }

    public JTable getPeopleTable() {
        return peopleTable;
    }

}
