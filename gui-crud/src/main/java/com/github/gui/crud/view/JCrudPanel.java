package com.github.gui.crud.view;

import com.github.gui.crud.commands.ChooseDbCommands;
import com.github.gui.crud.commands.CrudCommands;
import com.github.gui.crud.config.ViewConfig;

import javax.swing.*;

public class JCrudPanel extends JTabbedPane {

    public JCrudPanel(CrudCommands commands, ChooseDbCommands dbCommands) {

        this.setBounds(5, 8, 315, 845);

        JPanel crudPanel = ViewConfig.peopleCrudCommandsPanel(commands);
        crudPanel.setVisible(Boolean.TRUE);
        JPanel dbPanel = ViewConfig.peopleChooseDbPanel(dbCommands);
        dbPanel.setVisible(Boolean.TRUE);

        add("FILE", crudPanel);
        add("DB", dbPanel);
        setVisible(Boolean.TRUE);
    }

}
