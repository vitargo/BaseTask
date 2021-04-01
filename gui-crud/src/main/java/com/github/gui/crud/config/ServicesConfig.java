package com.github.gui.crud.config;

import com.github.gui.crud.formats.impl.*;
import com.github.gui.crud.services.impl.db.*;
import com.github.gui.crud.services.impl.file.*;
import com.github.gui.crud.formats.IFormats;
import org.bitbucket.gui.crud.formats.impl.*;
import com.github.gui.crud.handlers.PersonServiceHandler;
import com.github.gui.crud.services.IPeopleService;
import org.bitbucket.gui.crud.services.impl.db.*;
import org.bitbucket.gui.crud.services.impl.file.*;

import java.lang.reflect.Proxy;

public class ServicesConfig {

    public static IFormats csvFormat(){
        return new FormatCsv();
    }

    public static IFormats binFormat(){
        return new FormatBin();
    }

    public static IFormats jsonFormat(){
        return new FormatJson();
    }

    public static IFormats xmlFormat(){
        return new FormatXml();
    }

    public static IFormats ymlFormat() {
        return new FormatYaml();
    }

    public static IPeopleService servicePersonCsv(String path){
        return getProxyInstance(new PeopleCsvService(csvFormat(), path));
    }

    public static IPeopleService servicePersonBin(String path){
        return getProxyInstance(new PeopleBinService(binFormat(), path));
    }

    public static IPeopleService servicePersonJson(String path){
        return getProxyInstance(new PeopleJsonService(jsonFormat(), path));
    }

    public static IPeopleService servicePersonXml(String path){
        return getProxyInstance(new PeopleXmlService(xmlFormat(), path));
    }

    public static IPeopleService servicePersonYml(String path){
        return getProxyInstance(new PeopleYamlService(ymlFormat(), path));
    }

    public static IPeopleService servicePeopleCassandra(){
        return getProxyInstance(new PeopleCassandraService(RepositoryConfig.peopleRepoCassandra()));
    }

    public static IPeopleService servicePeopleGraphDB(){
        return getProxyInstance(new PeopleGraphDBService(RepositoryConfig.peopleRepoGraphDB()));
    }

    public static IPeopleService servicePeopleH2(){
        return getProxyInstance(new PeopleH2Service(RepositoryConfig.peopleRepoH2()));
    }

    public static IPeopleService servicePeopleMongoDB(){
        return getProxyInstance(new PeopleMongoDBService(RepositoryConfig.peopleRepoMongoDB()));
    }

    public static IPeopleService servicePeopleMySql(){
        return getProxyInstance(new PeopleMySqlService(RepositoryConfig.peopleRepoMySql()));
    }

    public static IPeopleService servicePeoplePostgreSQL(){
        return getProxyInstance(new PeoplePostgreSQLService(RepositoryConfig.peopleRepoPostgreSql()));
    }

    public static IPeopleService servicePeopleRedis(){
        return getProxyInstance(new PeopleRedisService(RepositoryConfig.peopleRepoRedis()));
    }

    private static IPeopleService getProxyInstance(IPeopleService origin) {
        return (IPeopleService) Proxy.newProxyInstance(
                origin.getClass().getClassLoader(),
                new Class[] {IPeopleService.class},
                new PersonServiceHandler(origin)
        );
    }
}
