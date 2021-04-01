package com.github.gui.crud.services;

import com.github.gui.crud.utils.people.PersonNotNull;
import com.github.gui.crud.entity.Person;

import java.util.List;

public interface IPeopleService {

    Person create(@PersonNotNull Person person);

    List<Person> readAll();

    void update(long id, @PersonNotNull Person person);

    void delete(long id);

    default IPeopleService path(String path) {
        return null;}

    default void clear(){

    }

    default List<Person> getPeople() {
        return null;
    }

}
