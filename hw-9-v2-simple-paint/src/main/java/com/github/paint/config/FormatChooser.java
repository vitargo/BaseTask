package com.github.paint.config;

import com.github.paint.formats.impl.*;
import com.github.paint.formats.IBaseFormat;

public class FormatChooser {

    public static IBaseFormat csvFormat(){
        return new CsvFormat();
    }

    public static IBaseFormat binFormat(){
        return new BinFormat();
    }

    public static IBaseFormat jsonFormat(){
        return new JsonFormat();
    }

    public static IBaseFormat xmlFormat(){
        return new XmlFormat();
    }

    public static IBaseFormat ymlFormat() {
        return new YmlFormat();
    }
}
