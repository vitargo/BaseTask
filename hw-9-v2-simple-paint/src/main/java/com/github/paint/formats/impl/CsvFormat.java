package com.github.paint.formats.impl;

import com.github.paint.CustomLine;
import com.github.paint.formats.IBaseFormat;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFormat implements IBaseFormat {

    @Override
    public void toFormat(List<CustomLine> lines, String file) {
        if(lines == null){
            JOptionPane.showMessageDialog(null, "Picture is null","Picture saver",JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            FileWriter output = new FileWriter(file);
            CSVPrinter printer = CSVFormat.TDF.withQuote(null).withFirstRecordAsHeader().withNullString("").withHeader("firstX=", "firstY=", "lastX=", "lastY=", "color=", "width=")
                    .withRecordSeparator("\n").print(output);

            for (CustomLine line : lines) {
                List<String> record = new ArrayList<>();
                record.add("firstX="+line.getFirstX());
                record.add(", firstY="+line.getFirstY());
                record.add(", lastX="+line.getLastX());
                record.add(", lastY="+line.getLastY());
                record.add(", color="+line.getColor());
                record.add(", width="+line.getWidth());
                printer.printRecord(record);
            }

            output.flush();
            output.close();
            JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

        @Override
    public List<CustomLine> fromFormat(String file){

        List<CustomLine> lines2 = new ArrayList<>();
        try {
            FileReader input = new FileReader(file);
            Iterable<CSVRecord> records = CSVFormat.TDF.withQuote(null).withNullString("").withHeader("firstX=", "firstY=", "lastX=", "lastY=", "color=", "width=").parse(input);
            records.forEach(record -> {
                CustomLine line = new CustomLine();
                line.setFirstX(Integer.parseInt(record.get("firstX=").substring(7)));
                line.setFirstY(Integer.parseInt(record.get("firstY=").substring(9)));
                line.setLastX(Integer.parseInt(record.get("lastX=").substring(8)));
                line.setLastY(Integer.parseInt(record.get("lastY=").substring(8)));
                line.setColor(Integer.parseInt(record.get("color=").substring(8)));
                line.setWidth(Integer.parseInt(record.get("width=").substring(8)));
                lines2.add(line);
            });
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return lines2;
    }
}
