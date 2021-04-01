package com.github.gui.crud.view;

import com.github.gui.crud.commands.ChooseDbCommands;
import com.github.gui.crud.config.type.DataBaseType;

import javax.swing.*;
import java.util.Arrays;

public class PeopleChooseDbPanel extends JPanel {

    public PeopleChooseDbPanel(ChooseDbCommands dbCommands) {
        setLayout(null);

        setBounds(5, 8, 315, 845);

        JButton createButton = new JButton("Create");
        JButton readButton = new JButton("Read");
        JButton updateButton = new JButton("Update");
        JButton removeButton = new JButton("Remove");

        JComboBox<String> cmbBxDb = new JComboBox<>(
                Arrays.stream(DataBaseType.values())
                        .map(DataBaseType::getDataBaseTypeName)
                        .toArray(String[]::new));

        createButton.setBounds(25, 35, 265, 85);
        readButton.setBounds(25, 135, 265, 85);
        updateButton.setBounds(25, 235, 265, 85);
        removeButton.setBounds(25, 335, 265, 85);
        cmbBxDb.setBounds(25, 435, 265, 40);

        cmbBxDb.addActionListener(dbCommands.chooseDataBase());
        createButton.addActionListener(dbCommands.actionCreate());
        readButton.addActionListener(dbCommands.actionRead());
        updateButton.addActionListener(dbCommands.actionUpdate());
        removeButton.addActionListener(dbCommands.actionDelete());

        add(createButton);
        add(readButton);
        add(updateButton);
        add(removeButton);
        add(cmbBxDb);

        setVisible(Boolean.TRUE);
    }

}
