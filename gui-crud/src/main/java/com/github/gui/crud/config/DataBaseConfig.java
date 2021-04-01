package com.github.gui.crud.config;

import com.github.gui.crud.config.type.DataBaseType;
import com.github.gui.crud.exceptions.CrudException;
import com.github.gui.crud.services.IPeopleService;

public class DataBaseConfig {

    public static IPeopleService newInstance(DataBaseType dataBaseType) {
        switch (dataBaseType) {
            case CASSANDRA:
                return ServicesConfig.servicePeopleCassandra();
            case GRAPH_DB:
                return ServicesConfig.servicePeopleGraphDB();
            case H2:
                return ServicesConfig.servicePeopleH2();
            case MONGO_DB:
                return ServicesConfig.servicePeopleMongoDB();
            case MYSQL:
                return ServicesConfig.servicePeopleMySql();
            case POSTGRES:
                return ServicesConfig.servicePeoplePostgreSQL();
            case REDIS:
                return ServicesConfig.servicePeopleRedis();
            default:
                throw new CrudException("DataBase name is not valid.\n" +
                        "Please choose one of accessible format: " +
                        "'Cassandra', 'GraphDB', 'H2', 'MongoDB', 'MySql', 'PostgreSql', 'Redis'.");
        }
    }
}
