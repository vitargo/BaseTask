package com.github.gui.crud.repository.impl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.github.gui.crud.entity.Person;
import com.github.gui.crud.repository.IPeopleRepo;
import org.bson.Document;
import org.bson.codecs.ValueCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.jsr310.Jsr310CodecProvider;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import static com.github.gui.crud.config.ApplicationConfig.DB_NAME;

public class PeopleMongoDBRepo implements IPeopleRepo {

    private final MongoDatabase database;

    public PeopleMongoDBRepo(MongoClient mongoClient) {
        database = mongoClient.getDatabase(DB_NAME)
                .withCodecRegistry(CodecRegistries
                        .fromProviders(PojoCodecProvider.builder()
                                        .register(Person.class, Document.class)
                                        .build(),
                                new Jsr310CodecProvider(),
                                new ValueCodecProvider()));
    }

    @Override
    public Person save(Person p) {
        MongoCollection<Person> people = database.getCollection("people", Person.class);
        people.insertOne(p);
        return p;
    }

    @Override
    public List<Person> findAll() {
        MongoCollection<Person> people = database.getCollection("people", Person.class);
        MongoCursor<Person> cursor = people.find().cursor();

        List<Person> persons = new ArrayList<>();
        while (cursor.hasNext()) {
            persons.add(cursor.next());
        }

        return persons.stream()
                .sorted(Comparator.comparingLong(Person::getId))
                .collect(Collectors.toList());
    }

    @Override
    public void update(long id, Person p) {
        MongoCollection<Person> people = database.getCollection("people", Person.class);

        people.updateOne(eq("_id", id), combine(
                set("firstName", p.getFirstName()),
                set("firstName", p.getFirstName()),
                set("lastName", p.getLastName()),
                set("age", p.getAge()),
                set("city", p.getCity())));
    }

    @Override
    public void remove(long id) {
        MongoCollection<Person> people = database.getCollection("people", Person.class);
        people.deleteOne(eq("_id", id));
    }
}
