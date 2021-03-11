package com.github.paint.view;

import com.github.paint.PaintPanel;

import javax.swing.*;
import java.awt.*;

public class PaintFrame extends JFrame {

    public PaintFrame(PaintPanel paintPanel, PaintThicknessPanel paintThicknessPanel, PaintColorClearPanel paintColorClearPanel, PaintFilePanel paintFilePanel) throws HeadlessException {
        JLabel label = new JLabel("Simple paint");
        label.setBounds(350,10,180,30);
        label.setFont(new Font("Serif", Font.PLAIN, 24));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(100, 100, 1200, 800);
        add(label);
        add(paintPanel);
        add(paintThicknessPanel);
        add(paintColorClearPanel);
        add(paintFilePanel);
        setVisible(Boolean.TRUE);
    }
}
