package com.github.crud.formats.impl;

import com.github.crud.formats.BaseFormat;
import com.github.crud.models.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinFormat implements BaseFormat {

    @Override
    public List<Person> loadObject(String path) {
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(path))) {
            return cast(o.readObject());
        } catch (ClassNotFoundException | IOException e) {
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T cast(Object o) {
        return (T) o;
    }

    @Override
    public void saveObject(List<Person> people, String path) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(path))) {
            o.writeObject(people);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toFormat(Person person) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Person fromFormat(String str) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toFormatArray(List<Person> people) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Person> fromFormatArray(String str) {
        throw new UnsupportedOperationException();
    }
}
