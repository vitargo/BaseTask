package com.github.crud.utils;

import com.github.crud.models.Person;
import com.github.crud.view.ScannerWrapper;

import java.io.IOException;
import java.util.List;

public class CheckPersonId {

    public static long checkForExistingID(List<Person> people) {
        System.out.println("Enter id: ");
        String line;
        long personId = 0;
        if (people != null) {
            line = ScannerWrapper.getString().toLowerCase();
            CheckForExitSwitch.checkForCommand(line);
            try {
                personId = Long.parseLong(line);
            } catch (NumberFormatException e) {
                System.out.println("Letters are entered, please enter digits for ID, or call command: 'switch', 'help' or 'exit'.\n");
                personId = checkForExistingID(people);
            }
            if (personId <= 0) {
                System.out.println("This Id is not valid! Please check and try again, or call command: 'switch', 'help' or 'exit'.\n");
                personId = checkForExistingID(people);
            }
            for (Person p : people) {
                if (p.getId() == personId) {
                    System.out.println("This Id already exists. Please set another Id, or call command: 'switch', 'help' or 'exit'.\n");
                    personId = checkForExistingID(people);
                }
            }
        }
        return personId;
    }
}

