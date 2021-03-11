package com.github.paint.view;

import com.github.paint.commands.PaintColorThicknessCommands;

import javax.swing.*;
import java.awt.*;

public class PaintThicknessPanel extends JPanel {

    public static JSlider thicknessSlider;

    public static JLabel thicknessStat;

    public PaintThicknessPanel(PaintColorThicknessCommands paintColorThicknessCommands){
        setLayout(new FlowLayout());
        setBounds(820, 70, 200, 80);

        thicknessStat = new JLabel("Thickness");
        thicknessSlider = new JSlider(0,25,1);
        thicknessSlider.setMajorTickSpacing(3);
        thicknessSlider.setPaintTicks(true);

        thicknessSlider.addChangeListener(paintColorThicknessCommands.thicknessLine());

        add(thicknessStat);
        add(thicknessSlider);
    }
}
