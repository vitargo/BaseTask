package com.github.crud.config;

import com.github.crud.dao.IDaoPerson;
import com.github.crud.exeptions.CrudException;

public class FDaoPerson {
    public static IDaoPerson newInstance(String format, String path) {
        IDaoPerson result;
        switch (format) {
            case "bin":
                result = InstanceSelection.daoPersonData(path);
                break;
            case "json":
                result = InstanceSelection.daoPersonJson(path);
                break;
            case "xml":
                result = InstanceSelection.daoPersonXml(path);
                break;
            case "yml":
                result = InstanceSelection.daoPersonYml(path);
                break;
            case "csv":
                result = InstanceSelection.daoPersonCsv(path);
                break;
            default:
                throw new CrudException("File format or file extension is not valid.\n" +
                        "Please choose one of accessible format: 'bin', 'json', 'csv', 'xml' or 'yml'.");
        }
        return result;
    }
}
