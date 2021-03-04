package com.github.crud.formats;

import com.github.crud.models.Person;

import java.util.List;

public interface BaseFormat extends IDataFormat {

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
