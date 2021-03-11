package com.github.paint.formats.impl;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.paint.CustomLine;
import com.github.paint.formats.IBaseFormat;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class XmlFormat implements IBaseFormat {

    @Override
    public void toFormat(List<CustomLine> lines, String file) {
        try {
            XmlMapper mapper = new XmlMapper();
            String xmlString = mapper.writeValueAsString(lines);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(xmlString);
                JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CustomLine> fromFormat(String file) {
        List <CustomLine> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String xmlString = br.readLine();
            Type type = new TypeToken<List<CustomLine>>() {}.getType();
            XmlMapper mapper = new XmlMapper();
            lines = mapper.readValue(xmlString, mapper.constructType(type));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return lines;
    }
}
