package com.github.crud.formats.impl;

import com.github.crud.formats.BaseFormat;
import com.github.crud.models.Person;

import java.util.ArrayList;
import java.util.List;

public class JsonFormat implements BaseFormat {

    public List<Person> personList = new ArrayList<>();

    @Override
    public String toFormat(Person person) {
        if (person == null) {
            return null;
        }
        return String.format("\t{\n" +
                        "\t\t\"id\": %d,\n" +
                        "\t\t\"name\": \"%s\",\n" +
                        "\t\t\"lastName\": \"%s\",\n" +
                        "\t\t\"age\": %d,\n" +
                        "\t\t\"city\": \"%s\"\n" +
                        "\t}",
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
        String name = "";
        String lastName = "";
        int age = 0;
        String city = "";
        String newStr = str.replaceAll("[\\[\\]{}<>!?.\"\\t\\n\\s]", " ");
        String[] splitString = newStr.split("([:,])");
        for (int i = 0; i < splitString.length; i++) {
            splitString[i] = splitString[i].trim();
        }
        for (int i = 0; i < splitString.length; i++) {
            switch (splitString[i]) {
                case "id":
                    personId = Long.parseLong(splitString[i + 1]);
                    break;
                case "name":
                    name = splitString[i + 1];
                    break;
                case "lastName":
                    lastName = splitString[i + 1];
                    break;
                case "age":
                    age = Integer.parseInt(splitString[i + 1]);
                    break;
                case "city":
                    city = splitString[i + 1];
                    break;
                default:
                    break;
            }
        }
        return new Person(personId, name, lastName, age, city);
    }

    @Override
    public String toFormatArray(List<Person> people) {
        if (people == null || people.isEmpty()) {
            return "";
        }
        StringBuilder peopleStr = new StringBuilder();
        peopleStr.append("[\n");
        for (int i = 0; i < people.size(); i++) {
            peopleStr.append(toFormat(people.get(i)));
            if (i != (people.size() - 1)) {
                peopleStr.append(",");
            }
            peopleStr.append("\n");
        }
        peopleStr.append("]");
        return peopleStr.toString();
    }

    @Override
    public List<Person> fromFormatArray(String str) {
        if (str == null || "".equals(str)) {
            return this.personList;
        }
        String newString = str.replaceAll("[\\[\\]\\n]", "");
        String[] array = newString.split("},");
        for (int i = 0; i < array.length; i++) {
            this.personList.add(fromFormat(array[i]));
        }
        return this.personList;
    }
}
