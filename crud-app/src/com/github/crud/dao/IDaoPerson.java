package com.github.crud.dao;

import com.github.crud.models.Person;

import java.util.List;

public interface IDaoPerson {

    Person create (Person person);

    List<Person> readAll();

    void update (Person person);

    void delete (long personId);

    default IDaoPerson path(String path) {return null;}

    default void clear(){

    }

    default List<Person> getPeople() {
        return null;
    }

}
