package com.github.gui.crud.repository;

import com.github.gui.crud.entity.Person;

import java.util.List;

public interface IPeopleRepo {

    Person save(Person p);

    List<Person> findAll();

    void update(long id, Person p);

    void remove(long id);
}
