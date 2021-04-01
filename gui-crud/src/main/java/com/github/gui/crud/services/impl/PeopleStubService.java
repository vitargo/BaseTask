package com.github.gui.crud.services.impl;

import com.github.gui.crud.entity.Person;
import com.github.gui.crud.services.IPeopleService;

import java.util.ArrayList;
import java.util.List;

public class PeopleStubService implements IPeopleService {


    public PeopleStubService() {
    }

    @Override
    public Person create(Person person) {
        return null;
    }

    @Override
    public List<Person> readAll() {
        return new ArrayList<>();
    }

    @Override
    public void update(long id, Person person) {
    }

    @Override
    public void delete(long id) {
    }
}
