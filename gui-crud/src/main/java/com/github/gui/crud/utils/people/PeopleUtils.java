package com.github.gui.crud.utils.people;

import com.github.gui.crud.entity.Person;
import com.github.gui.crud.exceptions.NotValidParameterException;

public class PeopleUtils {

    public static void isPerson(Person data) {
        if (data.getId() <= 0) {
            throw new NotValidParameterException("Person has a not valid Id! Check and try again.");
        } else if (data.getFirstName() == null || data.getAge() <= 0 ||
                "".equals(data.getFirstName()) || data.getLastName() == null ||
                "".equals(data.getLastName()) || data.getCity() == null || "".equals(data.getCity())) {
            throw new NotValidParameterException("Person has a not valid parameter! Check and try again.");
        }
    }
}
