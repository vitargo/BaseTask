package com.github.crud.formats.impl;

import com.github.crud.formats.BaseFormat;
import com.github.crud.models.Person;

import java.util.ArrayList;
import java.util.List;

public class CsvFormat implements BaseFormat {

    @Override
    public String toFormat(Person person) {
        if (person == null) {
            return null;
        }
        return String.format(
                "%d,%s,%s,%d,%s\n",
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getAge(),
                person.getCity()
        );
    }

    @Override
    public Person fromFormat(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        str = str.replace("\n", "");
        String[] array = str.split(",");
        return new Person(
                Long.parseLong(array[0]),
                array[1],
                array[2],
                Integer.parseInt(array[3]),
                array[4]
        );
    }

    @Override
    public String toFormatArray(List<Person> people) {
        if (people == null || people.isEmpty()) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        for (Person p : people) {
            str.append(toFormat(p));
        }
        return str.toString();
    }

    @Override
    public List<Person> fromFormatArray(String str) {
        if (str == null || "".equals(str)) {
            return new ArrayList<>();
        }
        List<Person> people = new ArrayList<>();
        String[] array = str.split("\n");
        for (String s : array) {
            people.add(fromFormat(s));
        }
        return people;
    }
}
