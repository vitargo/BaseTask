package com.github.gui.crud.view;

import javax.swing.*;
import java.awt.*;

public class PeopleForm extends JFrame {
    public PeopleForm(
            PeopleTablePanel peopleTablePanel,
            JCrudPanel crudCmd) throws HeadlessException {
        setLayout(null);
        setVisible(Boolean.TRUE);
        setSize(1300, 900);
        add(peopleTablePanel);
        add(crudCmd);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
