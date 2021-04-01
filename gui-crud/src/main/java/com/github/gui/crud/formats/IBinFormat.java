package com.github.gui.crud.formats;

import com.github.gui.crud.entity.Person;

import java.util.List;

public interface IBinFormat {

    List<Person> loadObject(String fileName);

    void saveObject(List<Person> people, String fileName);
}
