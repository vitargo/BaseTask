package com.github.convertor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Convertor {
    private JPanel Convertor;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTabbedPane tabbedPane4;
    private JTabbedPane tabbedPane5;
    private JTextField valueLenght;
    private JComboBox fromLenght;
    private JComboBox toLenght;
    private JButton buttonLenght;
    private JTextField resultLenght;
    private JLabel convLenght;
    private JLabel toL;
    private JComboBox fromTemp;
    private JComboBox toTemp;
    private JButton buttonTemp;
    private JTextField resultTemp;
    private JLabel convTemp;
    private JTextField valueTemp;
    private JLabel toT;
    private JTextField valueWeight;
    private JComboBox fromWeight;
    private JComboBox toWeight;
    private JButton buttonWeight;
    private JTextField resultWeight;
    private JLabel convWeight;
    private JLabel toW;
    private JTextField valueTime;
    private JComboBox fromTime;
    private JComboBox toTime;
    private JButton buttonTime;
    private JTextField resultTime;
    private JLabel convTime;
    private JLabel toTm;
    private JTextField valueVolume;
    private JComboBox fromVolume;
    private JComboBox toVolume;
    private JButton buttonVolume;
    private JTextField resultVolume;
    private JLabel convVolume;
    private JLabel toV;

    public Convertor() {
        buttonLenght.addActionListener(e -> {
                double value = Double.parseDouble(valueLenght.getText());
                double result = 0;
                Object selectFromLenght = fromLenght.getSelectedItem();
                if (!selectFromLenght.toString().equals("m")){
                    switch (selectFromLenght.toString()){
                        case "km":
                            value = kilometerToMeter(value);
                            break;
                        case "mile":
                            value = mileToMeter(value);
                            break;
                        case "nautical mile":
                            value = nauticalMileToMeter(value);
                            break;
                        case "cable":
                            value = cableToMeter(value);
                            break;
                        case "league":
                            value = leagueToMeter(value);
                            break;
                        case "foot":
                            value = footToMeter(value);
                            break;
                        case "yard":
                            value = yardToMeter(value);
                            break;
                    }
                }
                Object selectToLenght = toLenght.getSelectedItem();
                switch(selectToLenght.toString()){
                    case "km":
                        result = meterToKilometer(value);
                        break;
                    case "mile":
                        result = meterToMile(value);
                        break;
                    case "nautical mile":
                        result = meterToNauticalMile(value);
                        break;
                    case "cable":
                        result = meterToCable(value);
                        break;
                    case "league":
                        result = meterToLeague(value);
                        break;
                    case "foot":
                        result = meterToFoot(value);
                        break;
                    case "yard":
                        result = meterToYard(value);
                        break;
                    case "m":
                        result = value;
                }
                resultLenght.setText(String.valueOf(result));
        });

        buttonTemp.addActionListener(e -> {
            double value = Double.parseDouble(valueTemp.getText());
            double result = 0;
            Object selectedFromTemp = fromTemp.getSelectedItem();
            if(!selectedFromTemp.toString().equals("C")){
                switch (selectedFromTemp.toString()){
                    case "K":
                        value = kToC(value);
                        break;
                    case "F":
                        value = fToC(value);
                        break;
                    case "Re":
                        value = reToC(value);
                        break;
                    case "Ro":
                        value = roToC(value);
                        break;
                    case "Ra":
                        value = raToC(value);
                        break;
                    case "N":
                        value = nToC(value);
                        break;
                    case "D":
                        value = dToC(value);
                        break;
                }
            }
            Object selectedToTemp = toTemp.getSelectedItem();
            switch (selectedToTemp.toString()){
                case "K":
                    result = cToK(value);
                    break;
                case "F":
                    result = cToF(value);
                    break;
                case "Re":
                    result = cToRe(value);
                    break;
                case "Ro":
                    result = cToRo(value);
                    break;
                case "Ra":
                    result = cToRa(value);
                    break;
                case "N":
                    result = cToN(value);
                    break;
                case "D":
                    result = cToD(value);
                    break;
                case "C":
                    result = value;
                    break;
            }
            resultTemp.setText(String.valueOf(result));
        });
        buttonWeight.addActionListener( e -> {
            double value = Double.parseDouble(valueWeight.getText());
            double result = 0;
            Object selectedFromWeight = fromWeight.getSelectedItem();
            if(!selectedFromWeight.toString().equals("kg")){
                switch (selectedFromWeight.toString()){
                    case "g":
                        value = gToKg(value);
                        break;
                    case "carat":
                        value = caratToKg(value);
                        break;
                    case "eng pound":
                        value = engPoundToKg(value);
                        break;
                    case "pound":
                        value = poundToKg(value);
                        break;
                    case "stone":
                        value = stoneToKg(value);
                        break;
                    case "rus pound":
                        value = rusPoundToKg(value);
                        break;
                }
            }
            Object selectedToWeight = toWeight.getSelectedItem();
            switch (selectedToWeight.toString()){
                case "g":
                    result = kgToG(value);
                    break;
                case "carat":
                    result = kgToCarat(value);
                    break;
                case "eng pound":
                    result = kgToEngPound(value);
                    break;
                case "pound":
                    result = kgToPound(value);
                    break;
                case "stone":
                    result = kgToStone(value);
                    break;
                case "rus pound":
                    result = kgToRusPound(value);
                    break;
                case "kg":
                    result = value;
                    break;
            }
            resultWeight.setText(String.valueOf(result));
        });
        buttonTime.addActionListener( e -> {
            double value = Double.parseDouble(valueTime.getText());
            double result = 0;
            Object selectedFromTime = fromTime.getSelectedItem();
            if(!selectedFromTime.toString().equals("sec")){
                switch (selectedFromTime.toString()){
                    case "min":
                        value = minToSec(value);
                        break;
                    case "hour":
                        value = hourToSec(value);
                        break;
                    case "day":
                        value = dayToSec(value);
                        break;
                    case "week":
                        value = weekToSec(value);
                        break;
                    case "month":
                        value = monthToSec(value);
                        break;
                    case "astronomical year":
                        value = yearToSec(value);
                        break;
                }
            }
            Object selectedToTime = toTime.getSelectedItem();
            switch (selectedToTime.toString()){
                case "min":
                    result = secToMin(value);
                    break;
                case "hour":
                    result = secToHour(value);
                    break;
                case "day":
                    result = secToDay(value);
                    break;
                case "week":
                    result = secToWeek(value);
                    break;
                case "month":
                    result = secToMonth(value);
                    break;
                case "astronomical year":
                    result = secToYear(value);
                    break;
                case "sec":
                    result = value;
                    break;
            }
            resultTime.setText(String.valueOf(result));
        });

        buttonVolume.addActionListener(e -> {
            double value = Double.parseDouble(valueVolume.getText());
            double result = 0;
            Object selectedFromVolume = fromVolume.getSelectedItem();
            if(!selectedFromVolume.toString().equals("l")){
                switch (selectedFromVolume.toString()){
                    case "m^3":
                        value = m3ToL(value);
                        break;
                    case "gallon":
                        value = gallonToL(value);
                        break;
                    case "pint":
                        value = pintToL(value);
                        break;
                    case "quart":
                        value = quartToL(value);
                        break;
                    case "barrel":
                        value = barrelToL(value);
                        break;
                    case "cubic foot":
                        value = cubicFootToL(value);
                        break;
                    case "cubic inch":
                        value = cubicInchToL(value);
                        break;
                }
            }
            Object selectedToVolume = toVolume.getSelectedItem();
            switch (selectedToVolume.toString()){
                case "m^3":
                    result = lToM3(value);
                    break;
                case "gallon":
                    result = lToGallon(value);
                    break;
                case "pint":
                    result = lToPint(value);
                    break;
                case "quart":
                    result = lToQuart(value);
                    break;
                case "barrel":
                    result = lToBarrel(value);
                    break;
                case "cubic foot":
                    result = lToCubicFoot(value);
                    break;
                case "cubic inch":
                    result = lToCubicInch(value);
                    break;
                case "l":
                    result = value;
                    break;
            }
            resultVolume.setText(String.valueOf(result));
        });
    }
    public static double m3ToL(double value){
        return value*1000;
    }
    public static double gallonToL(double value){
        return value*3.785411784;
    }
    public static double pintToL(double value){
        return value*0.473176473;
    }
    public static double quartToL(double value){
        return value*0.946352946;
    }
    public static double barrelToL(double value){
        return value*158.98729493;
    }
    public static double cubicFootToL(double value){
        return value*28.316846592;
    }
    public static double cubicInchToL(double value){
        return value*0.016387064;
    }
    public static double lToM3(double value){
        return value*0.001;
    }
    public static double lToGallon(double value){
        return value*0.2641720524;
    }
    public static double lToPint(double value){
        return value*2.1133764189;
    }
    public static double lToQuart(double value){
        return value*1.0566882094;
    }
    public static double lToBarrel(double value){
        return value*0.0062898108;
    }
    public static double lToCubicFoot(double value){
        return value*0.0353146667;
    }
    public static double lToCubicInch(double value){
        return value*61.023744095;
    }
    public static double minToSec(double value){
        return value*60;
    }
    public static double hourToSec(double value){
        return value*3600;
    }
    public static double dayToSec(double value){
        return value*86400;
    }
    public static double weekToSec(double value){
        return value*604800;
    }
    public static double monthToSec(double value){
        return value*2628000;
    }
    public static double yearToSec(double value){
        return value*31536000;
    }
    public static double secToMin(double value){
        return value*0.016666666666667;
    }
    public static double secToHour(double value){
        return value*0.000277777778;
    }
    public static double secToDay(double value){
        return value*1.15741E-5;
    }
    public static double secToWeek(double value){
        return value*1.6534391534392E-6;
    }
    public static double secToMonth(double value){
        return value*3.8051750380518E-7;
    }
    public static double secToYear(double value){
        return value*3.1709791983765E-8;
    }
    public static double gToKg(double value){
        return value/1000;
    }
    public static double caratToKg(double value){
        return value*0.0002;
    }
    public static double engPoundToKg(double value) {
        return value * 0.454;
    }
    public static double poundToKg(double value){
        return value*0.45359237;
    }
    public static double stoneToKg(double value){
        return value*6.35029318;
    }
    public static double rusPoundToKg(double value){
        return value*0.409512037;
    }
    public static double kgToG(double value){
        return value*1000;
    }
    public static double kgToCarat(double value){
        return value*5000;
    }
    public static double kgToEngPound(double value) {
        return value * 2.205;
    }
    public static double kgToPound(double value){
        return value*2.20462262;
    }
    public static double kgToStone(double value){
        return value*0.157473044;
    }
    public static double kgToRusPound(double value){
        return value*2.441899995502;
    }
    public static double kToC(double value){
        return value-273.15;
    }
    public static double fToC(double value){
        return (value-32)*5/9;
    }
    public static double reToC(double value){
        return value*1.25;
    }
    public static double roToC(double value){
        return (value-7.5)/0.52500;
    }
    public static double raToC(double value){
        return (value-459.67-32)/1.8;
    }
    public static double nToC(double value){
        return value*100/33;
    }
    public static double dToC(double value){
        return 100 - value*(2/3);
    }
    public static double cToK(double value){
        return value+273.15;
    }
    public static double cToF(double value){
        return value*9/5+32;
    }
    public static double cToRe(double value){
        return value*0.8;
    }
    public static double cToRo(double value){
        return (value*21)/40+7.5;
    }
    public static double cToRa(double value){
        return value*1.8+32+459.67;
    }
    public static double cToN(double value){
        return value*33/100;
    }
    public static double cToD(double value){
        return (100 - value) * (3/2);
    }
    public static double meterToKilometer(double value){
        return value/1000;
    }
    public static double meterToMile(double value){
        return value*0.00062137;
    }
    public static double meterToNauticalMile(double value){
        return value*0.0005399568;
    }
    public static double meterToCable(double value){
        return value*0.0054;
    }
    public static double meterToLeague(double value){
        return value*0.000179985601;
    }
    public static double meterToFoot(double value){
        return value*3.2808399;
    }
    public static double meterToYard(double value){
        return value*0.9144;
    }
    public static double kilometerToMeter(double value){
        return value*1000;
    }
    public static double mileToMeter(double value){
        return value*1609.344;
    }
    public static double nauticalMileToMeter(double value){
        return value*1852;
    }
    public static double cableToMeter(double value){
        return value*219.45600;
    }
    public static double leagueToMeter(double value){
        return value*5556;
    }
    public static double footToMeter(double value){
        return value*0.3048;
    }
    public static double yardToMeter(double value){
        return value*1.0936133;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Convertor");
        frame.setContentPane(new Convertor().Convertor);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
