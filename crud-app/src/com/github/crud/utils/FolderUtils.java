package com.github.crud.utils;

import java.io.File;

public class FolderUtils {
    public static void FolderUtils() {
        String fileSeparator = System.getProperty("file.separator");
        File folderName = new File(".." + fileSeparator + "FormatFiles");

//        Альтернативный вариант
//        new File(new File(System.getProperty("user.dir")).getParent() +
//        File.separator + "FormatFiles").mkdir();

        if (!folderName.exists()) {
            boolean result = false;

            try {
                folderName.mkdir();
                result = true;
            } catch (SecurityException se) {
                System.out.println(se.getMessage());
            }
        }
    }
}
