package com.github.gui.crud.services.impl.file;

import com.github.gui.crud.entity.Person;
import com.github.gui.crud.exceptions.NotValidParameterException;
import com.github.gui.crud.formats.IFormats;
import com.github.gui.crud.services.IPeopleService;
import com.github.gui.crud.utils.people.PeopleUtils;

import java.util.ArrayList;
import java.util.List;

public class PeopleBinService implements IPeopleService {

    private final IFormats baseFormat;

    private final String path;

    private final List<Person> people = new ArrayList<>();

    public PeopleBinService(IFormats baseFormat, String path) {
        this.baseFormat = baseFormat;
        this.path = path;
    }

    @Override
    public Person create(Person person) {
        if (person == null) {
            throw new NotValidParameterException("Person is null!");
        }
        PeopleUtils.isPerson(person);

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
    public void update(long id, Person person) {
        if (person == null) {
            throw new NotValidParameterException("Person is null!");
        }
        PeopleUtils.isPerson(person);

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
    public void delete(long id) {
        this.people.removeIf(p -> p.getId() == id);
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
