package com.github.paint.view;

import com.github.paint.commands.PaintColorThicknessCommands;

import javax.swing.*;

public class PaintColorClearPanel extends JPanel {

    public PaintColorClearPanel(PaintColorThicknessCommands colorThicknessCommands){
        setLayout(null);
        setBounds(820, 170, 200, 180);

        JButton btnColor = new JButton("Color");
        JButton btnClear = new JButton("Clear");

        btnClear.addActionListener(colorThicknessCommands.actionClear());
        btnColor.addActionListener(colorThicknessCommands.actionColorChooser());

        btnColor.setBounds(10, 10, 180, 30);
        btnClear.setBounds(10, 50, 180, 30);

        add(btnColor);
        add(btnClear);

        setVisible(Boolean.TRUE);
    }
}
