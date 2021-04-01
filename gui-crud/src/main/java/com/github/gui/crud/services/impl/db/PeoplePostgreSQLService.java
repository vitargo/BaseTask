package com.github.gui.crud.services.impl.db;

import com.github.gui.crud.entity.Person;
import com.github.gui.crud.repository.IPeopleRepo;
import com.github.gui.crud.services.IPeopleService;

import java.util.List;

public class PeoplePostgreSQLService implements IPeopleService {

    private final IPeopleRepo peopleRepo;

    public PeoplePostgreSQLService(IPeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    @Override
    public Person create(Person person) {
        return this.peopleRepo.save(person);
    }

    @Override
    public List<Person> readAll() {
        return this.peopleRepo.findAll();
    }

    @Override
    public void update(long id, Person person) {
        this.peopleRepo.update(id, person);
    }

    @Override
    public void delete(long id) {
        this.peopleRepo.remove(id);
    }
}