package com.github.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MCalc extends JFrame {

    private JTextField textNumber2;
    private JTextField textOperation;
    private JButton buttonCalc;
    private JPanel MCalc;
    private JTextField textResult;
    private JLabel number1;
    private JLabel number2;
    private JLabel operation;
    private JLabel result;
    private JTextField textNumber1;

    public MCalc() {
        buttonCalc.addActionListener(e -> {
            double num1 = Double.parseDouble(textNumber1.getText());
            String oper = textOperation.getText();
            double num2 = Double.parseDouble(textNumber2.getText());
            double res = MathCalc.calcMath(num1, num2, oper);
            textResult.setText(String.valueOf(res));
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MCalc");
        frame.setContentPane(new MCalc().MCalc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
