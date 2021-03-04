package com.github.crud.dao.impl;

import com.github.crud.dao.IDaoPerson;
import com.github.crud.exeptions.NotValidParameterException;
import com.github.crud.formats.BaseFormat;
import com.github.crud.models.Person;
import com.github.crud.utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPersonCsv implements IDaoPerson {

    private final BaseFormat baseFormat;

    private final String fileName;

    private final List<Person> people = new ArrayList<>();

    public DaoPersonCsv(BaseFormat baseFormat, String fileName) {
        this.baseFormat = baseFormat;
        this.fileName = fileName;
    }


    @Override
    public Person create(Person person) {
        if (person == null) {
            throw new NotValidParameterException("Person is null!");
        }
        Utils.isPerson(person);

        this.people.add(person);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileName, Boolean.FALSE))) {
            bw.write(this.baseFormat.toFormatArray(this.people));
        } catch (IOException e) {
            delete(person.getId());
            System.out.println(e.getMessage());
        }
        return person;
    }

    @Override
    public List<Person> readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
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

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileName, Boolean.FALSE))) {
            bw.write(this.baseFormat.toFormatArray(this.people));
        } catch (IOException e) {
            delete(person.getId());
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(long personId) {
        this.people.removeIf(p -> p.getId() == personId);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileName, Boolean.FALSE))) {
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
