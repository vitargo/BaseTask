package com.github.gui.crud.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.github.gui.crud.repository.IPeopleRepo;
import com.github.gui.crud.repository.impl.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.github.gui.crud.utils.JDBCConnectionPool;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RepositoryConfig {

    public static IPeopleRepo peopleRepoCassandra() {
        return new PeopleCassandraRepo(createCassandraSession());
    }

    public static IPeopleRepo peopleRepoGraphDB() {
        HTTPRepository repository = new HTTPRepository("http://localhost:7200/repositories/repository");
        RepositoryConnection connection = repository.getConnection();
        return new PeopleGraphDBRepo(connection);
    }

    public static IPeopleRepo peopleRepoMongoDB() {
        return new PeopleMongoDBRepo(createMongoClient());
    }

    public static IPeopleRepo peopleRepoH2() {
        return new PeopleH2Repo(new JDBCConnectionPool(
                ApplicationConfig.DB_TIMEOUT,
                "org.h2.Driver",
                "jdbc:h2:tcp://localhost:1521/~/test",
                ApplicationConfig.DB_H2_USER,
                ApplicationConfig.DB_H2_PASSWORD));
    }

    public static IPeopleRepo peopleRepoMySql() {
        return new PeopleMySqlRepo(new JDBCConnectionPool(
                ApplicationConfig.DB_TIMEOUT,
                "com.mysql.cj.jdbc.Driver",
                getUrl("mysql", ApplicationConfig.DB_HOST, ApplicationConfig.DB_MYSQL_PORT, ApplicationConfig.DB_NAME),
                ApplicationConfig.DB_MYSQL_USER,
                ApplicationConfig.DB_MYSQL_PASSWORD));
    }

    public static IPeopleRepo peopleRepoPostgreSql() {
        return new PeoplePostgreSQLRepo(new JDBCConnectionPool(
                ApplicationConfig.DB_TIMEOUT,
                "org.postgresql.Driver",
                getUrl("postgresql", ApplicationConfig.DB_HOST, ApplicationConfig.DB_POSTGRES_PORT, ApplicationConfig.DB_NAME),
                ApplicationConfig.DB_POSTGRES_USER,
                ApplicationConfig.DB_POSTGRES_PASSWORD));
    }

    public static IPeopleRepo peopleRepoRedis() {
        return new PeopleRedisRepo(createRedisClient());
    }

    private static String getUrl(String dbTypeName, String host, int port, String dbName) {
        return "jdbc:" + dbTypeName + "://" + host + ":" + port + "/" + dbName;
    }

    private static RedissonClient createRedisClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + ApplicationConfig.DB_HOST + ":" + ApplicationConfig.DB_REDIS_PORT);

        return Redisson.create(config);
    }

    private static MongoClient createMongoClient() {
        return MongoClients.create("mongodb://" + ApplicationConfig.DB_HOST + ":" + ApplicationConfig.DB_MONGO_PORT + "/" + ApplicationConfig.DB_NAME);
    }

    private static Session createCassandraSession() {
        return Cluster.builder()
                .addContactPoint(ApplicationConfig.DB_HOST)
                .withPort(ApplicationConfig.DB_CASSANDRA_PORT)
                .withCredentials(ApplicationConfig.DB_CASSANDRA_USER, ApplicationConfig.DB_CASSANDRA_PASSWORD)
                .build()
                .connect();
    }
}
