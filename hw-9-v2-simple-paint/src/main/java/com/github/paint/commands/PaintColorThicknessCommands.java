package com.github.paint.commands;

import com.github.paint.PaintPanel;
import com.github.paint.view.PaintThicknessPanel;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class PaintColorThicknessCommands {

    Graphics2D graphics2D;

    private PaintPanel paintPanel;

    public void setPaintPanelColor(PaintPanel paintPanel) {
        this.paintPanel = paintPanel;
    }

    public ActionListener actionClear() {
        return e -> {
            PaintPanel.lines.clear();
            paintPanel.repaint();
        };
    }

    public ActionListener actionColorChooser() {
        return e -> {
            paintPanel.setColor(JColorChooser.showDialog(new JFrame(), "Select a color", Color.RED).getRGB());
        };
    }
    public ChangeListener thicknessLine() {
        return e -> {
            PaintThicknessPanel.thicknessStat.setText(String.format("Thickness \n %s", PaintThicknessPanel.thicknessSlider.getValue()));
            paintPanel.setWidth(PaintThicknessPanel.thicknessSlider.getValue());
        };
    }

    public void setGraphics2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }
}
