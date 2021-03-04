package com.github.crud.view;

import com.github.crud.models.Person;
import com.github.crud.utils.CheckForExitSwitch;
import com.github.crud.utils.CheckPersonId;

import java.util.List;

public class NewPerson {

    private static List<Person> people;

    public static Person newPersonFromConsole() {
        Person person = new Person();

        person.setId(CheckPersonId.checkForExistingID(people));

        System.out.println("Enter firstname: ");
        person.setFirstName(ScannerWrapper.getNext());

        System.out.println("Enter lastname: ");
        person.setLastName(ScannerWrapper.getNext());

        System.out.println("Enter age: ");
        person.setAge(ScannerWrapper.getInt());

        System.out.println("Enter city: ");
        person.setCity(ScannerWrapper.getNext());

        return person;
    }

    public static int findPersonById(List<Person> people, long id) {
        int index = -1;
        if (people.isEmpty()) {
            return index;
        }
        for (Person p : people) {
            if (p.getId() == id) {
                index = people.indexOf(p);
            }
        }
        return index;
    }

    public static Person updatePerson(int index, List<Person> people) {
        Person person = people.get(index);
        String line;
        int count = 0;
        do {
            System.out.println("Do you want to change Firstname? (y/n)?");
            line = ScannerWrapper.getNext().toLowerCase();
            CheckForExitSwitch.checkForCommand(line);
            switch (line) {
                case "y":
                case "yes":
                    System.out.println("Enter Firstname: ");
                    person.setFirstName(ScannerWrapper.getNext());
                    count++;
                    break;
                case "n":
                    count++;
                    break;
                default:
                    System.out.println("Not valid command!");
                    break;
            }
        } while (count == 0);
        count = 0;
        do {
            System.out.println("Do you want to change Lastname? (y/n)?");
            line = ScannerWrapper.getNext().toLowerCase();
            CheckForExitSwitch.checkForCommand(line);
            switch (line) {
                case "y":
                case "yes":
                    System.out.println("Enter Lastname: ");
                    person.setLastName(ScannerWrapper.getNext());
                    count++;
                    break;
                case "n":
                case "no":
                    count++;
                    break;
                default:
                    System.out.println("Not valid command!");
                    break;
            }
        } while (count == 0);
        count = 0;
        do {
            System.out.println("Do you want to change age? (y/n)?");
            line = ScannerWrapper.getNext().toLowerCase();
            CheckForExitSwitch.checkForCommand(line);
            switch (line) {
                case "y":
                case "yes":
                    System.out.println("Enter age: ");
                    person.setAge(ScannerWrapper.getInt());
                    count++;
                    break;
                case "n":
                case "no":
                    count++;
                    break;
                default:
                    System.out.println("Not valid command!");
            }
        } while (count == 0);
        count = 0;
        do {
            System.out.println("Do you want to change city? (y/n)?");
            line = ScannerWrapper.getNext().toLowerCase();
            CheckForExitSwitch.checkForCommand(line);
            switch (line) {
                case "y":
                case "yes":
                    System.out.println("Enter city: ");
                    person.setCity(ScannerWrapper.getNext());
                    count++;
                    break;
                case "n":
                case "no":
                    count++;
                    break;
                default:
                    System.out.println("Not valid command!");
            }
        } while (count == 0);
        return person;
    }

    public static void setPeople(List<Person> listOfPeople) {
        people = listOfPeople;
    }
}
