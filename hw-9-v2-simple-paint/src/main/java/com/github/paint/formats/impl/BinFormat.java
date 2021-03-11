package com.github.paint.formats.impl;

import com.github.paint.CustomLine;
import com.github.paint.formats.IBaseFormat;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinFormat implements IBaseFormat {
    @Override
    public void toFormat(List<CustomLine> lines, String file) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file))) {
            o.writeObject(lines);
            JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<CustomLine> fromFormat(String file) {
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(file))) {
            return cast(o.readObject());
        } catch (ClassNotFoundException | IOException e) {
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T cast(Object o) {
        return (T) o;
    }
}
