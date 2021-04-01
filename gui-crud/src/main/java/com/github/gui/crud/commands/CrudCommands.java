package com.github.gui.crud.commands;

import com.github.gui.crud.config.FormatsConfig;
import com.github.gui.crud.config.type.FileType;
import com.github.gui.crud.entity.Person;
import com.github.gui.crud.models.PeopleTableModel;
import com.github.gui.crud.services.impl.PeopleStubService;
import com.github.gui.crud.view.PeopleTablePanel;
import com.github.gui.crud.view.PersonDialog;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionListener;
import java.io.File;

public class CrudCommands {

    private final PeopleTableModel peopleTableModel;
    private final PersonDialog personDialog;
    private final PeopleTablePanel peopleTablePanel;

    public CrudCommands(PeopleTableModel peopleTableModel, PersonDialog personDialog, PeopleTablePanel peopleTablePanel) {
        this.peopleTableModel = peopleTableModel;
        this.personDialog = personDialog;
        this.peopleTablePanel = peopleTablePanel;
    }

    public ActionListener actionCreate() {
        return e -> {
            if (peopleTablePanel.peopleTableModel().getPeopleService() instanceof PeopleStubService) {
                fileChoose();
            }

            this.personDialog.setVisible(Boolean.TRUE);
            if (this.personDialog.isDialog()) {
                Person person = this.personDialog.getPerson();
                this.peopleTableModel.create(person);
                this.peopleTablePanel.getPeopleTable().revalidate();
                peopleTablePanel.repaint();
                this.personDialog.clear();
            }
        };
    }

    public ActionListener actionRead() {
        return e -> fileChoose();
    }

    public ActionListener actionUpdate() {
        return e -> {
            long selectedPeopleId = getSelectedPeopleId();
            this.personDialog.setVisibleId(false);
            this.personDialog.setVisible(Boolean.TRUE);
            if (this.personDialog.isDialog()) {
                Person person = this.personDialog.getPerson();
                person.setId(selectedPeopleId);
                this.peopleTableModel.update(person);
                this.peopleTablePanel.getPeopleTable().revalidate();
                peopleTablePanel.repaint();
                this.personDialog.clear();
            }
        };
    }

    private long getSelectedPeopleId() {
        JTable peopleTable = peopleTablePanel.getPeopleTable();
        int selectedRow = peopleTable.getSelectedRow();
        return (long) peopleTable.getValueAt(selectedRow, 0);
    }

    public ActionListener actionDelete() {
        return e -> {
            this.peopleTableModel.delete(getSelectedPeopleId());
            this.peopleTablePanel.getPeopleTable().revalidate();
            peopleTablePanel.repaint();
        };
    }

    private void fileChoose() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileFilter(new FileNameExtensionFilter("Files (*.json)", "json"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Files (*.csv)", "csv"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Files (*.bin)", "bin"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Files (*.xml)", "xml"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Files (*.yml)", "yml"));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String description = fileChooser.getFileFilter().getDescription();
            description = description.substring(9, description.length() - 1);
            File file = fileChooser.getSelectedFile();
            peopleTablePanel.peopleTableModel().setPeopleService(
                    FormatsConfig.newInstance(FileType.from(description), file.getAbsolutePath()));
            peopleTablePanel.peopleTableModel().refresh();
            this.peopleTablePanel.getPeopleTable().revalidate();
            peopleTablePanel.repaint();
        }
    }
}
