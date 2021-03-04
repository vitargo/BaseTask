package com.github.crud.config;

import com.github.crud.dao.IDaoPerson;
import com.github.crud.dao.impl.*;
import com.github.crud.formats.BaseFormat;
import com.github.crud.formats.impl.*;

public class InstanceSelection {

    public static BaseFormat csvFormat(){
        return new CsvFormat();
    }

    public static IDaoPerson daoPersonCsv(String path){
        return new DaoPersonCsv(csvFormat(), path);
    }

    public static BaseFormat dataFormat(){
        return new BinFormat();
    }

    public static IDaoPerson daoPersonData(String path){
        return new DaoPersonBin(dataFormat(), path);
    }

    public static BaseFormat jsonFormat(){
        return new JsonFormat();
    }

    public static IDaoPerson daoPersonJson(String path){
        return new DaoPersonJson(jsonFormat(), path);
    }

    public static BaseFormat xmlFormat(){
        return new XmlFormat();
    }

    public static IDaoPerson daoPersonXml(String path){
        return new DaoPersonXml(xmlFormat(), path);
    }

    public static BaseFormat ymlFormat() {
        return new YmlFormat();
    }

    public static IDaoPerson daoPersonYml(String path){
        return new DaoPersonYml(ymlFormat(), path);
    }
}
