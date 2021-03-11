package com.github.paint.formats.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.paint.CustomLine;
import com.github.paint.formats.IBaseFormat;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class YmlFormat implements IBaseFormat {
    @Override
    public void toFormat(List<CustomLine> lines, String file) {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            String ymlString = mapper.writeValueAsString(lines);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(ymlString);
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
        try {
            Type type = new TypeToken<List<CustomLine>>() {}.getType();
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            lines = mapper.readValue(new File(file), mapper.constructType(type));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return lines;
    }
}
