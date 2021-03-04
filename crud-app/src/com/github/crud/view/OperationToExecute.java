package com.github.crud.view;

import com.github.crud.config.FDaoPerson;
import com.github.crud.dao.IDaoPerson;
import com.github.crud.exeptions.CrudException;
import com.github.crud.exeptions.NotValidParameterException;
import com.github.crud.models.Person;
import com.github.crud.utils.FileUtils;
import com.github.crud.view.optionaloperations.Options;

import java.util.List;

public class OperationToExecute {

    private static String fileFormat;

    private static String relativePath;

    public static Person create() {
        Person person = null;
        try {
            IDaoPerson daoPerson = FDaoPerson.newInstance(fileFormat, relativePath);
            daoPerson.readAll();
            NewPerson.setPeople(daoPerson.getPeople());
            person = daoPerson.create(NewPerson.newPersonFromConsole());
            System.out.println("\nInformation save successfully!\n");
        } catch (NotValidParameterException e) {
            System.out.println(e.getMessage() + " Returning to main menu....\n");
            ViewMainMenu.start(1);
        } catch (CrudException e) {
            System.out.println(e.getMessage() + "Returning to main menu....\n");
            ViewMainMenu.start(1);
        }
        return person;
    }

    public static void read() {
        try {
            IDaoPerson daoPerson = FDaoPerson.newInstance(fileFormat, relativePath);
            List<Person> peopleList = daoPerson.readAll();
            if (peopleList.isEmpty()) {
                System.out.println("\nFile is empty!\n");
            } else {
                for (Person person : peopleList) {
                    System.out.println("\n" + person + "\n");
                }
            }
            ViewMainMenu.start(1);
        } catch (CrudException e) {
            System.out.println(e.getMessage() + "Returning to main menu....\n");
            ViewMainMenu.start(1);
        } catch (NumberFormatException e) {
            System.out.println("Returning to main menu....\n");
            ViewMainMenu.start(1);
        }
    }

    public static void update() {
        try {
            IDaoPerson daoPerson = FDaoPerson.newInstance(fileFormat, relativePath);
            List<Person> peopleList = daoPerson.readAll();
            if (peopleList.isEmpty()) {
                System.out.println("\nNothing to update in empty file!\n");
            } else {
                System.out.println("Enter Id of Person you want to change: ");
                long updateId = ScannerWrapper.getLong();
                int index = NewPerson.findPersonById(daoPerson.getPeople(), updateId);
                if (index == -1) {
                    System.out.println("Person with this ID isn`t in file.");
                    update();
                } else {
                    Person person = NewPerson.updatePerson(index, daoPerson.getPeople());
                    daoPerson.update(person);
                    System.out.println("\nInformation update successfully!\n");
                }
            }
            ViewMainMenu.start(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Entered ID value not exist in array or incorrect");
            ViewMainMenu.start(1);
        } catch (NotValidParameterException e) {
            System.out.println(e.getMessage() + " Returning to main menu....\n");
            ViewMainMenu.start(1);
        } catch (CrudException e) {
            System.out.println(e.getMessage() + "Returning to main menu....\n");
            ViewMainMenu.start(1);
        }
    }

    public static void delete() {
        try {
            IDaoPerson daoPerson = FDaoPerson.newInstance(fileFormat, relativePath);
            daoPerson.readAll();
            if (!daoPerson.getPeople().isEmpty()) {
                System.out.println("Enter id of Person you want to delete:");
                long personToDeleteById = ScannerWrapper.getLong(); // задаем номер ID персоны, которую нужно удалить
                int index = NewPerson.findPersonById(daoPerson.getPeople(), personToDeleteById);
                if (index == -1) {
                    System.out.println("Person with this ID isn`t in file.");
                    delete();
                } else {
                    daoPerson.delete(personToDeleteById);
                    System.out.println("\nInformation delete successfully!\n");
                    Options.confirmationToDeleteNext(daoPerson.getPeople());
                }
            } else {
                ViewMessages.emptyFileMessage();
            }
            ViewMainMenu.start(1);
        } catch (CrudException e) {
            System.out.println(e.getMessage() + "Returning to main menu....\n");
            ViewMainMenu.start(1);
        }
    }

    public static void setOptions(String format, String command, String fileNameAndFormat) {
        String pathOfFile;
        if (command.equals("create")) {
            if (FileUtils.isValid(format)) {
                pathOfFile = FileUtils.createFile(fileNameAndFormat);
            } else {
                pathOfFile = FileUtils.isExist(fileNameAndFormat);
            }
        } else {
            pathOfFile = FileUtils.isExist(fileNameAndFormat);
            if (pathOfFile.equals("")) {
                throw new CrudException("Not existing file! Check and try again.");
            }
        }
        fileFormat = format;
        relativePath = pathOfFile;
    }
}
