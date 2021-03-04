package com.github.crud.utils;

import com.github.crud.exeptions.CrudException;
import com.github.crud.view.ViewMainMenu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Locale;

public class FileUtils {

    public static boolean isValid(String format) {
        if (format.equals("json") || format.equals("yml") || format.equals("bin") || format.equals("csv") || format.equals("xml")) {
            return true;
        } else {
            return false;
        }
    }

    public static String createFile(String fileName) {
        Formatter formatter = new Formatter(Locale.US);
        String fileSeparator = System.getProperty("file.separator");
        formatter.format(".." + fileSeparator + "FormatFiles%1$s%2$s", fileSeparator, fileName);
        String relativePath = formatter.toString();
        File file = new File(relativePath);
        try{
            file.createNewFile();
        } catch(IOException e){
            System.out.println(e.getMessage());
            ViewMainMenu.start(1);
        }

        return relativePath;
    }

    public static String isExist(String fileName) {
        Formatter formatter = new Formatter(Locale.US);
        String fileSeparator = System.getProperty("file.separator");
        formatter.format(".." + fileSeparator + "FormatFiles%1$s%2$s", fileSeparator, fileName);
        String relativePath = formatter.toString();
        Path path = Paths.get(relativePath);
        if (Files.exists(path)) {
            return relativePath;
        } else {
            relativePath = "";
            return relativePath;
        }
    }
}
