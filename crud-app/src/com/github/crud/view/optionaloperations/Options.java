package com.github.crud.view.optionaloperations;

import com.github.crud.models.Person;
import com.github.crud.view.OperationToExecute;
import com.github.crud.view.ScannerWrapper;
import com.github.crud.view.ViewMessages;

import java.util.List;

public class Options {

    public static void confirmationToDeleteNext(List<Person> people) {
        if (!people.isEmpty()) {
            System.out.println("Delete one more person?(y/n)");
            String confirmationToDelete = ScannerWrapper.getString().toLowerCase();
            switch (confirmationToDelete) {
                case "y":
                case "yes":
                    OperationToExecute.delete();
                    break;
                case "n":
                case "no":
                    break;
                default:
                    System.out.println("No such command!");
                    confirmationToDeleteNext(people);
                    break;
            }
        } else {
            ViewMessages.emptyFileMessage();
        }

    }
}
