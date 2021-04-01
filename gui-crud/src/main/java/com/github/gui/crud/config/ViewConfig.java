package com.github.gui.crud.config;

import com.github.gui.crud.commands.PersonDialogCommands;
import com.github.gui.crud.entity.Person;
import com.github.gui.crud.models.PeopleTableModel;
import com.github.gui.crud.utils.ReflectionUtils;
import com.github.gui.crud.view.*;
import com.github.gui.crud.commands.ChooseDbCommands;
import com.github.gui.crud.commands.CrudCommands;
import com.github.gui.crud.services.impl.PeopleStubService;
import org.bitbucket.gui.crud.view.*;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.List;

public class ViewConfig {

    private static final List<Field> personColumn = ReflectionUtils.fields(Person.class);

    private static final PeopleTableModel peopleTableModel =
            new PeopleTableModel(new PeopleStubService(), personColumn).refresh();

    private static PersonDialogCommands personDialogCommands() {
        return new PersonDialogCommands();
    }

    private static ChooseDbCommands chooseDbCommands(PersonDialog personDialog, PeopleTablePanel peopleTablePanel) {
        return new ChooseDbCommands(peopleTableModel, personDialog, peopleTablePanel);
    }

    public static CrudCommands crudCommands(PersonDialog personDialog, PeopleTablePanel peopleTablePanel) {
        return new CrudCommands(peopleTableModel, personDialog, peopleTablePanel);
    }

    public static PeopleChooseDbPanel peopleChooseDbPanel(ChooseDbCommands dbCommands) {
        return new PeopleChooseDbPanel(dbCommands);
    }

    public static PeopleCrudCommandsPanel peopleCrudCommandsPanel(CrudCommands crudCommands) {
        return new PeopleCrudCommandsPanel(crudCommands);
    }

    private static PersonDialog personDialog() {
        return new PersonDialog(personDialogCommands());
    }

    public static PeopleTablePanel peopleTablePanel() {
        return new PeopleTablePanel(peopleTableModel);
    }

    private static JCrudPanel jCrudPane(CrudCommands crudCommands, ChooseDbCommands dbCommands) {
        return new JCrudPanel(crudCommands, dbCommands);
    }

    public static JFrame peopleFrame() {
        PeopleTablePanel peopleTablePanel = peopleTablePanel();
        CrudCommands crudCommands = crudCommands(personDialog(), peopleTablePanel);
        ChooseDbCommands dbCommands = chooseDbCommands(personDialog(), peopleTablePanel);
        JCrudPanel jCrudPanel = jCrudPane(crudCommands, dbCommands);
        return new PeopleForm(peopleTablePanel, jCrudPanel);
    }
}
