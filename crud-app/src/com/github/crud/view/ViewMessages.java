package com.github.crud.view;

public class ViewMessages {

    private static final int symbolsQuantity = 75;

    private static final String textForHelloMsg = "WELCOME to CRUD APP!!!";

    private static final String textForHelpMsg = "HELP";

    private static final String textForExitMsg = "GOOD-BYE";

    private static final String textForMainMenuMsg = "MAIN MENU";

    private static final int spaceBetweenMsg = 25;

    private static final int getSpaceBetweenHelpMsg = 32;

    public static void helloMessage() {
        for (int i = 0; i < symbolsQuantity; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < spaceBetweenMsg; i++) {
            System.out.print(" ");
        }
        System.out.println(textForHelloMsg);
        for (int i = 0; i < symbolsQuantity; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void mainMenuMessage() {
        for (int i = 0; i < symbolsQuantity; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < spaceBetweenMsg + 5; i++) {
            System.out.print(" ");
        }
        System.out.println(textForMainMenuMsg);
        for (int i = 0; i < symbolsQuantity; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void helpMessage() {
        for (int i = 0; i < symbolsQuantity; i++) {
            if (i == 0) {
                System.out.println("\n");
            }
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < getSpaceBetweenHelpMsg; i++) {
            System.out.print(" ");
        }
        System.out.println(textForHelpMsg);
        for (int i = 0; i < symbolsQuantity; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("The CRUD APP lets you create, view, edit and delete records of Person." +
                "\nApp designed to run with Binary, JSON, CSV, YML and XML files." +
                "\nApp has the next lines for Persons: id, Firstname, Lastname, age and city." +
                "\nUser can use 4 available commands with space-separated 'filename.extension': " +
                "\n'create' - create a new Person from console and save it in a chosen file," +
                "\n'update' - change info about Person by id and save it in a chosen file," +
                "\n\nWARNING - you cannot enter invalid characters specified below: " +
                "\n\" < > ( ) { } | \\ / ; : , . + = % $ # @ ^ & * \"" +
                "\n\n'read' - print info from chosen file to console," +
                "\n'delete' -  delete info about Person from file by id," +
                "\n and use 3 additional commands without filename:" +
                "\n'switch' - go to main menu, " +
                "\n'help' - print info about APP," +
                "\n'exit' - close app." +
                "\nDevelopers: Nadopta Volodymyr, Anufriev Andriy, Boyko Mykola, Zhmurchyk Vasyl, Redko Viktoria.");
        for (int i = 0; i < symbolsQuantity; i++) {
            System.out.print("-");
        }
        ViewMainMenu.start(1);
    }

    public static void exitMessage() {
        for (int i = 0; i < symbolsQuantity; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < spaceBetweenMsg; i++) {
            System.out.print(" ");
        }
        System.out.println(textForExitMsg);
        for (int i = 0; i < symbolsQuantity; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void emptyFileMessage() {
        System.out.println("\nFile is empty!");
        returningMessage();
    }

    public static void returningMessage() {
        System.out.println("\nReturning to menu...\n");
    }

}
