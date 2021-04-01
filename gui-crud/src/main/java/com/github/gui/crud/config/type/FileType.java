package com.github.gui.crud.config.type;

public enum FileType {

    JSON, BIN, CSV, XML, YML;

    public static FileType from(String fileTypeName) {
        for (FileType type : FileType.values()) {
            if (type.name().equalsIgnoreCase(fileTypeName)) {
                return type;
            }
        }
        throw new RuntimeException("Incorrect file type name: " + fileTypeName);
    }
}
