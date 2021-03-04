package com.github.crud.formats.impl;

import com.github.crud.formats.BaseFormat;
import com.github.crud.models.Person;

import java.util.ArrayList;
import java.util.List;

public class YmlFormat implements BaseFormat {

    public List<Person> personList = new ArrayList<>();

    @Override
    public String toFormat(Person person) {
        if (person == null) {
            return null;
        }
        return String.format(
                "- Person:\n" +
                        "\tid: %d \n" +
                        "\tfirstname: %s \n" +
                        "\tlastname: %s \n" +
                        "\tage: %d \n" +
                        "\tcity: %s \n",
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
        long personId = 0;
        String name = null;
        String lastName = null;
        int age = 0;
        String city = null;
        String[] splitString = str.split("\\t");

        for (int i = 0; i < splitString.length; i++) {
            String [] newStr = splitString[i].split(":");
            if(newStr.length !=2){
                continue;
            }
            String value = newStr[1].trim();
            switch (newStr[0]) {
                case "id":
                    personId = Long.parseLong(value);
                    break;
                case "firstname":
                    name = value;
                    break;
                case "lastname":
                    lastName = value;
                    break;
                case "age":
                    age = Integer.parseInt(value);
                    break;
                case "city":
                    city = value;
                    break;
                default:
                    break;
            }
        }
        return new Person(personId, name, lastName, age, city);
    }
    @Override
    public String toFormatArray(List<Person> people) {
        if (people == null || people.isEmpty()){
            return "";
        }
        StringBuilder str = new StringBuilder();
        for (Person p : people){
            str.append(toFormat(p));
        }
        return str.toString();
    }

    @Override
    public List<Person> fromFormatArray(String str){
        if(str == null || "".equals(str)){
            return this.personList;
        }
        List<Person> people = new ArrayList<>();
        String[] array = str.split("- Person:");
        for (String s: array){
            if (!s.equals("")) {
                people.add(fromFormat(s));
            }
        }
        return people;
    }
}

