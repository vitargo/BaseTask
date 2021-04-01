package com.github.gui.crud.view;

import com.github.gui.crud.commands.CrudCommands;

import javax.swing.*;

public class PeopleCrudCommandsPanel extends JPanel {

    public PeopleCrudCommandsPanel(CrudCommands commands) {
        setLayout(null);

        setBounds(5, 8, 315, 845);

        JButton createButton = new JButton("Create");
        JButton readButton = new JButton("Read");
        JButton updateButton = new JButton("Update");
        JButton removeButton = new JButton("Remove");


        createButton.setBounds(25, 35, 265, 85);
        readButton.setBounds(25, 135, 265, 85);
        updateButton.setBounds(25, 235, 265, 85);
        removeButton.setBounds(25, 335, 265, 85);

        createButton.addActionListener(commands.actionCreate());
        readButton.addActionListener(commands.actionRead());
        updateButton.addActionListener(commands.actionUpdate());
        removeButton.addActionListener(commands.actionDelete());

        add(createButton);
        add(readButton);
        add(updateButton);
        add(removeButton);

        setVisible(Boolean.TRUE);
    }
}
