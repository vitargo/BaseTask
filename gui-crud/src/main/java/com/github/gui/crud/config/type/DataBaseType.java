package com.github.gui.crud.config.type;

public enum DataBaseType {

    NOT_SELECTED(""),
    CASSANDRA("Cassandra"),
    GRAPH_DB("GraphDB"),
    H2("H2"),
    MONGO_DB("MongoDB"),
    MYSQL("MySql"),
    POSTGRES("PostgreSql"),
    REDIS("Redis");

    private final String dataBaseTypeName;

    DataBaseType(String dataBaseTypeName) {
        this.dataBaseTypeName = dataBaseTypeName;
    }

    public String getDataBaseTypeName() {
        return dataBaseTypeName;
    }

    public static DataBaseType from(String dataBaseTypeName) {
        for (DataBaseType type : DataBaseType.values()) {
            if (type.getDataBaseTypeName().equalsIgnoreCase(dataBaseTypeName)) {
                return type;
            }
        }
        throw new RuntimeException("Incorrect data base type name: " + dataBaseTypeName);
    }
}
