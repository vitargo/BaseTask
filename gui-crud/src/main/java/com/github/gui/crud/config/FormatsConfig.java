package com.github.gui.crud.config;

import com.github.gui.crud.config.type.FileType;
import com.github.gui.crud.exceptions.CrudException;
import com.github.gui.crud.services.IPeopleService;

public class FormatsConfig {

    public static IPeopleService newInstance(FileType format, String path) {
        IPeopleService result;
        switch (format) {
            case BIN:
                result = ServicesConfig.servicePersonBin(path);
                break;
            case JSON:
                result = ServicesConfig.servicePersonJson(path);
                break;
            case XML:
                result = ServicesConfig.servicePersonXml(path);
                break;
            case YML:
                result = ServicesConfig.servicePersonYml(path);
                break;
            case CSV:
                result = ServicesConfig.servicePersonCsv(path);
                break;
            default:
                throw new CrudException("File format or file extension is not valid.\n" +
                        "Please choose one of accessible format: 'bin', 'json', 'csv', 'xml' or 'yml'.");
        }

        return result;
    }
}
