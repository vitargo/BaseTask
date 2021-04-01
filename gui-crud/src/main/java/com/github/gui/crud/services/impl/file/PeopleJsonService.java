package com.github.gui.crud.services.impl.file;

import com.github.gui.crud.entity.Person;
import com.github.gui.crud.exceptions.NotValidParameterException;
import com.github.gui.crud.formats.IFormats;
import com.github.gui.crud.services.IPeopleService;
import com.github.gui.crud.utils.people.PeopleUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleJsonService implements IPeopleService {

    private final IFormats baseFormat;

    private final String path;

    private final List<Person> people = new ArrayList<>();

    public PeopleJsonService(IFormats baseFormat, String path) {
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.path, Boolean.FALSE))) {
            bw.write(this.baseFormat.toFormatArray(this.people));
        } catch (IOException e) {
            delete(person.getId());
            System.out.println(e.getMessage());
        }
        return person;
    }

    @Override
    public List<Person> readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            List<Person> pp = this.baseFormat.fromFormatArray(sb.toString());
            this.people.addAll(pp);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return this.people;
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
            System.out.println("This Id does not exist!");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.path, Boolean.FALSE))) {
            bw.write(this.baseFormat.toFormatArray(this.people));
        } catch (IOException e) {
            delete(person.getId());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        this.people.removeIf(p -> p.getId() == id);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.path, Boolean.FALSE))) {
            bw.write(this.baseFormat.toFormatArray(this.people));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void clear() {
        this.people.clear();
    }

    @Override
    public List<Person> getPeople() {
        return this.people;
    }
}
