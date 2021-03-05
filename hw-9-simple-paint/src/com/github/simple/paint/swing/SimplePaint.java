package com.github.simple.paint.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimplePaint {

    JButton clearButton, colorButton;
    AreaPaint areaPaint;
    private JLabel thicknessStat;
    private JSlider thicknessSlider;
    ChangeListener thick = new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
            thicknessStat.setText(String.format("Thickness %s", thicknessSlider.getValue()));
            areaPaint.thicknessLine(thicknessSlider.getValue());
        }
    };
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == clearButton){
                areaPaint.clear();
            } else if(e.getSource() == colorButton){
                areaPaint.colorChooser();
            }
        }
    };

    public static void main(String[] args) {
        new SimplePaint().show();
    }
    public void show(){
        JFrame frame = new JFrame("Simple Paint");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        areaPaint = new AreaPaint();

        content.add(areaPaint, BorderLayout.CENTER);

        JPanel controls = new JPanel();

        thicknessSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 1);
        thicknessSlider.setMajorTickSpacing(25);
        thicknessSlider.setPaintTicks(true);
        thicknessSlider.setPreferredSize(new Dimension(100, 40));
        thicknessSlider.addChangeListener(thick);

        colorButton = new JButton("Color");
        colorButton.addActionListener(actionListener);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(actionListener);

        thicknessStat = new JLabel("Thickness");

        controls.add(thicknessStat);
        controls.add(thicknessSlider);
        controls.add(colorButton);
        controls.add(clearButton);

        content.add(controls, BorderLayout.NORTH);

        frame.setSize(600,600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
