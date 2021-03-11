package com.github.paint.commands;

import com.ctc.wstx.util.StringUtil;
import com.github.paint.PaintPanel;
import com.github.paint.config.FM;
import com.github.paint.formats.IBaseFormat;
import com.github.paint.view.PaintFilePanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaintFileCommands {

    private PaintPanel paintPanel;

    public String fileChose = "No chosen file";

    public void setPaintPanel(PaintPanel paintPanel) {
        this.paintPanel = paintPanel;
    }

    public ActionListener actionOpen() {
        return e -> {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setFileFilter(new FileNameExtensionFilter("Files (*.json)", "json"));
            fileChooser.setFileFilter(new FileNameExtensionFilter("Files (*.csv)", "csv"));
            fileChooser.setFileFilter(new FileNameExtensionFilter("Files (*.bin)", "bin"));
            fileChooser.setFileFilter(new FileNameExtensionFilter("Files (*.xml)", "xml"));
            fileChooser.setFileFilter(new FileNameExtensionFilter("Files (*.yml)", "yml"));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                String description = fileChooser.getFileFilter().getDescription();
                description = description.substring(9, description.length()-1);
                File selectedFile = fileChooser.getSelectedFile();
                fileChose = selectedFile.getName();
                PaintFilePanel.file.setText(fileChose);
                File file = new File(String.valueOf(fileChooser.getSelectedFile()));
                IBaseFormat iBaseFormat = FM.newInstance(description);
                PaintPanel.lines = iBaseFormat.fromFormat(file.getPath());
                this.paintPanel.repaint();
            }
        };
    }

    public ActionListener actionSave() {
        return e -> {
            JFileChooser saveFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            saveFile.setFileFilter(new FileNameExtensionFilter("Files (*.json)", "json"));
            saveFile.setFileFilter(new FileNameExtensionFilter("Files (*.csv)", "csv"));
            saveFile.setFileFilter(new FileNameExtensionFilter("Files (*.bin)", "bin"));
            saveFile.setFileFilter(new FileNameExtensionFilter("Files (*.xml)", "xml"));
            saveFile.setFileFilter(new FileNameExtensionFilter("Files (*.yml)", "yml"));
            int result = saveFile.showSaveDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                String description = saveFile.getFileFilter().getDescription();
                description = description.substring(9, description.length()-1);
                System.out.println(description);
                IBaseFormat iBaseFormat = FM.newInstance(description);
                String fileName = saveFile.getSelectedFile().getAbsolutePath();
                System.out.println(fileName);
                String fileNameExtension = fileName.substring(fileName.lastIndexOf('.')+1);
                if(!fileNameExtension.equals(description)){
                    fileName = fileName + "." + description;
                }
                System.out.println(fileName);
                File file = new File(fileName);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                iBaseFormat.toFormat(PaintPanel.lines, file.getPath());
            } else if(result == JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "File save has been canceled");
            }
        };
    }
}
