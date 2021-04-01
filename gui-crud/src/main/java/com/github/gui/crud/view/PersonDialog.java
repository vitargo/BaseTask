package com.github.gui.crud.view;

import com.github.gui.crud.commands.PersonDialogCommands;
import com.github.gui.crud.entity.Person;

import javax.swing.*;

public class PersonDialog extends JDialog {

    private final PersonDialogCommands commands;
    private final JLabel id;
    private final JLabel firstName;
    private final JLabel lastName;
    private final JLabel age;
    private final JLabel city;
    private final JTextField txtId;
    private final JTextField txtFirstName;
    private final JTextField txtLastName;
    private final JTextField txtAge;
    private final JTextField txtCity;

    public PersonDialog(PersonDialogCommands commands) {
        setLayout(null);
        setBounds(300, 300, 400, 300);
        setModal(Boolean.TRUE);

        this.id = new JLabel("ID");
        this.firstName = new JLabel("First Name");
        this.lastName = new JLabel("Last Name");
        this.age = new JLabel("Age");
        this.city = new JLabel("City");

        this.txtId = new JTextField();
        this.txtFirstName = new JTextField();
        this.txtLastName = new JTextField();
        this.txtAge = new JTextField();
        this.txtCity = new JTextField();

        this.id.setBounds(20, 10, 70, 30);
        this.firstName.setBounds(20, 50, 70, 30);
        this.lastName.setBounds(20, 90, 70, 30);
        this.age.setBounds(20, 130, 70, 30);
        this.city.setBounds(20, 170, 70, 30);

        this.txtId.setBounds(100, 10, 280, 30);
        this.txtFirstName.setBounds(100, 50, 280, 30);
        this.txtLastName.setBounds(100, 90, 280, 30);
        this.txtAge.setBounds(100, 130, 280, 30);
        this.txtCity.setBounds(100, 170, 280, 30);

        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(commands.actionOk());
        cancelButton.addActionListener(commands.actionCancel());

        okButton.setBounds(100, 210, 120, 30);
        cancelButton.setBounds(260, 210, 120, 30);

        add(id);
        add(firstName);
        add(lastName);
        add(age);
        add(city);

        add(txtId);
        add(txtFirstName);
        add(txtLastName);
        add(txtAge);
        add(txtCity);

        add(okButton);
        add(cancelButton);

        this.commands = commands;
        this.commands.setPersonDialog(this);
    }

    public boolean isDialog() {
        return this.commands.isDialog();
    }

    public Person getPerson() {
        String idAsText = this.txtId.getText();
        if (idAsText.isBlank()) {
            return new Person(
                    this.txtFirstName.getText(),
                    this.txtLastName.getText(),
                    Integer.parseInt(this.txtAge.getText()),
                    this.txtCity.getText());
        } else {
            return new Person(
                    Long.parseLong(idAsText),
                    this.txtFirstName.getText(),
                    this.txtLastName.getText(),
                    Integer.parseInt(this.txtAge.getText()),
                    this.txtCity.getText());
        }
    }

    public void clear() {
        this.txtId.setText("");
        this.txtFirstName.setText("");
        this.txtLastName.setText("");
        this.txtAge.setText("");
        this.txtCity.setText("");
    }

    public void setVisibleId(boolean visibleId) {
        id.setVisible(visibleId);
        txtId.setVisible(visibleId);
    }
}
