package com.github.gui.crud.repository.impl;

import com.datastax.driver.core.*;
import com.github.gui.crud.entity.Person;
import com.github.gui.crud.repository.IPeopleRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PeopleCassandraRepo implements IPeopleRepo {

    private final Session session;

    public PeopleCassandraRepo(Session session) {
        this.session = session;
    }

    @Override
    public Person save(Person p) {
        PreparedStatement statement = session
                .prepare("INSERT INTO crud.people "
                        + "(id, first_name, last_name, age, city) "
                        + "VALUES (?, ?, ?, ?, ?);");

        BoundStatement boundStatement = new BoundStatement(statement);
        session.execute(boundStatement.bind(
                p.getId(),
                p.getFirstName(),
                p.getLastName(),
                p.getAge(),
                p.getCity()
        ));

        return p;
    }

    @Override
    public List<Person> findAll() {
        List<Person> result = new ArrayList<>();
        ResultSet resultSet = session.execute("SELECT * FROM crud.people;");

        for (Row row : resultSet.all()) {
            Person p = new Person(
                    row.getLong("id"),
                    row.getString("first_name"),
                    row.getString("last_name"),
                    row.getInt("age"),
                    row.getString("city")
            );
            result.add(p);
        }

        return result.stream()
                .sorted(Comparator.comparingLong(Person::getId))
                .collect(Collectors.toList());
    }

    @Override
    public void update(long id, Person p) {
        PreparedStatement statement = session
                .prepare("UPDATE crud.people SET first_name = ?, last_name = ?, age = ?, city = ? WHERE id = ?;");

        BoundStatement boundStatement = new BoundStatement(statement);
        session.execute(boundStatement.bind(
                p.getFirstName(),
                p.getLastName(),
                p.getAge(),
                p.getCity(),
                p.getId()
        ));
    }

    @Override
    public void remove(long id) {
        PreparedStatement statement = session.prepare("DELETE FROM crud.people WHERE id = ?");

        BoundStatement boundStatement = new BoundStatement(statement);
        session.execute(boundStatement.bind(id));
    }
}
