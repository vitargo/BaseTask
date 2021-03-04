package com.github.crud.formats;

import com.github.crud.models.Person;

import java.util.List;

public interface IDataFormat {

    List<Person> loadObject(String fileName);

    void saveObject(List<Person> people, String fileName);

}
