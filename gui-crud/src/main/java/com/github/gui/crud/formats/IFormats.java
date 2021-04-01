package com.github.gui.crud.formats;

import com.github.gui.crud.entity.Person;

import java.util.List;

public interface IFormats extends IBinFormat {

    String toFormat(Person person);

    Person fromFormat(String str);

    String toFormatArray(List<Person> people);

    List<Person> fromFormatArray(String str);

    @Override
    default List<Person> loadObject(String fileName) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void saveObject(List<Person> people, String fileName) {
        throw new UnsupportedOperationException();
    }
}
