package com.github.test;

import com.github.paint.CustomLine;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static CustomLine line1 = new CustomLine(360, 358,360,358, -65485, 4);
    public static CustomLine line2 = new CustomLine(360, 358,360,357, -65485, 4);
    public static CustomLine line3 = new CustomLine(360, 357,360,357, -65485, 4);
    public static CustomLine line4 = new CustomLine(360, 357,360,357, -65485, 4);
    public static CustomLine line5 = new CustomLine(360, 357,361,357, -65485, 4);

    public static List <CustomLine> paintMany = List.of(line1,line2,line3,line4,line5);
    public static List <CustomLine> paintTwo = List.of(line1,line2);
    public static List <CustomLine> paintOne = List.of(line1);
    public static List <CustomLine> paintNull = null;
    public static List <CustomLine> paintEmpty = new ArrayList<>();
}
