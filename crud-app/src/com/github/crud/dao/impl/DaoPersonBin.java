package com.github.crud.dao.impl;

import com.github.crud.dao.IDaoPerson;
import com.github.crud.exeptions.NotValidParameterException;
import com.github.crud.formats.BaseFormat;
import com.github.crud.models.Person;
import com.github.crud.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class DaoPersonBin implements IDaoPerson {

    private final String path;

    private final BaseFormat baseFormat;

    private final List<Person> people = new ArrayList<>();

    public DaoPersonBin(BaseFormat baseFormat, String path) {
        this.baseFormat = baseFormat;
        this.path = path;
    }

    @Override
    public Person create(Person person) {
        if (person == null) {
            throw new NotValidParameterException("Person is null!");
        }
        Utils.isPerson(person);

        this.people.add(person);
        this.baseFormat.saveObject(this.people, this.path);
        return person;
    }

    @Override
    public List<Person> readAll() {
        List<Person> all = this.baseFormat.loadObject(this.path);
        this.people.addAll(all);
        return all;
    }

    @Override
    public void update(Person person) {
        if (person == null) {
            throw new NotValidParameterException("Person is null!");
        }
        Utils.isPerson(person);

        int index = -1;
        for (Person p : people) {
            if (p.getId() == person.getId()) {
                index = people.indexOf(p);
            }
        }
        try {
            this.people.set(index, person);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This Id not exist!");
        }
        this.baseFormat.saveObject(this.people, this.path);
    }

    @Override
    public void delete(long personId) {
        this.people.removeIf(p -> p.getId() == personId);
        this.baseFormat.saveObject(this.people, this.path);
    }

    @Override
    public void clear() {

    }

    @Override
    public List<Person> getPeople() {
        return this.people;
    }
}
