package com.github.paint.view;

import com.github.paint.commands.PaintFileCommands;

import javax.swing.*;

public class PaintFilePanel extends JPanel{

    public static JTextField file;

    public static JLabel lable;

    public PaintFilePanel(PaintFileCommands paintFileCommands) {
        setLayout(null);
        setBounds(820, 360, 200, 180);

        lable = new JLabel("Open file name:");
        file = new JTextField(paintFileCommands.fileChose);
        JButton btnSave = new JButton("Save");
        JButton btnOpen = new JButton("Open");

        btnOpen.addActionListener(paintFileCommands.actionOpen());
        btnSave.addActionListener(paintFileCommands.actionSave());

        btnSave.setBounds(10, 10, 180, 30);
        lable.setBounds(15,50,180,30);
        file.setBounds(10,90,180, 30);
        btnOpen.setBounds(10, 130, 180, 30);

        add(btnSave);
        add(lable);
        add(file);
        add(btnOpen);

        setVisible(Boolean.TRUE);
    }

}
