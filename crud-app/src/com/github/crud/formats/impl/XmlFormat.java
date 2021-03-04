package com.github.crud.formats.impl;

import com.github.crud.formats.BaseFormat;
import com.github.crud.models.Person;

import java.util.ArrayList;
import java.util.List;

public class XmlFormat implements BaseFormat {

    public List<Person> personList = new ArrayList<>();

    @Override
    public String toFormat(Person person) {
        if (person == null) {
            return null;
        }
        return String.format(
                "<Person>\n" +
                        "\t<id>%d</id>\n" +
                        "\t<Firstname>%s</Firstname>\n" +
                        "\t<Lastname>%s</Lastname>\n" +
                        "\t<Age>%d</Age>\n" +
                        "\t<City>%s</City>\n"+
                "</Person>\n",
                person.getId(),
                person.getFirstName().replace(" ", "_"),
                person.getLastName().replace(" ", "_"),
                person.getAge(),
                person.getCity().replace(" ", "_")
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
        String[] splitString = newStr.split(" ");
        for(int i = 0; i < splitString.length; i++){
            String buffer = splitString[i].replaceAll("\\s", "");
            splitString[i] = buffer;
        }
        for(int i = 0; i < splitString.length; i++){
            switch(splitString[i]){
                case "id":
                    personId = Long.parseLong(splitString[i+1]);
                    break;
                case "Firstname":
                    name = splitString[i+1].replace("_", " ");
                    break;
                case "Lastname":
                    lastName = splitString[i+1].replace("_", " ");
                    break;
                case "Age":
                    age = Integer.parseInt(splitString[i+1]);
                    break;
                case "City":
                    city = splitString[i+1].replace("_", " ");
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
            return null;
        }
        StringBuilder peopleStr = new StringBuilder();
        peopleStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        peopleStr.append("<People>\n");
        for (int i = 0; i < people.size(); i++) {
            peopleStr.append(toFormat(people.get(i)));
            peopleStr.append("\n");
        }
        peopleStr.append("</People>");
        return peopleStr.toString();
    }

    @Override
    public List<Person> fromFormatArray(String str) {
        if(str == null || "".equals(str)){
            return this.personList;
        }
        String qqq = str.replaceAll("[\\t\\n]", "");
        List<Person> people = new ArrayList<>();
        String[] array = qqq.split("<Person>");
        for (int i=1; i<array.length; i++){
            if (!array[i].equals("")) {
                people.add(fromFormat(array[i]));
            }
        }
        return people;
    }
}
