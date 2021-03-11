package com.github.paint.config;

import com.github.paint.formats.IBaseFormat;

public class FM {
    public static IBaseFormat newInstance(String description) {
        IBaseFormat result;
        switch (description) {
            case "json":
                result = FormatChooser.jsonFormat();
                break;
            case "csv":
                result = FormatChooser.csvFormat();
                break;
            case "bin":
                result = FormatChooser.binFormat();
                break;
            case "xml":
                result = FormatChooser.xmlFormat();
                break;
            case "yml":
                result = FormatChooser.ymlFormat();
                break;
            default:
                throw new IllegalArgumentException("File format or file extension is not valid.\n" +
                        "Please choose one of accessible format: 'bin', 'json', 'csv', 'xml' or 'yml'.");
        }
        return result;
    }
}
