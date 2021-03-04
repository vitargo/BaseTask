package com.github.crud.view;

import com.github.crud.exeptions.CrudException;

public class ViewMainMenu {

    public static void start(int helloMsg) {
        if (helloMsg == 0) {
            ViewMessages.helloMessage();
        }
        ViewMessages.mainMenuMessage();
        System.out.println("Enter one of available commands - 'create'/'update'/'read'/'delete'" +
                "\nand space-separated 'filename.extension' or \nenter simply command 'help'/'exit'.");
        String[] userInputSeparated = null;
        try {
            userInputSeparated = UserInputForCommand.separateUserInputToArray();
            OperationToExecute.setOptions(userInputSeparated[0], userInputSeparated[1], userInputSeparated[2]);
        } catch (CrudException e) {
            System.out.println(e.getMessage());
            ViewMainMenu.start(1);
        }

        assert userInputSeparated != null;
        String command = userInputSeparated[1].toLowerCase();
        switch (command) {
            case "create":
                OperationToExecute.create();
                start(1);
                break;
            case "read":
                OperationToExecute.read();
                break;
            case "update":
                OperationToExecute.update();
                break;
            case "delete":
                OperationToExecute.delete();
                break;
            case "help":
                ViewMessages.helpMessage();
                start(1);
            default:
                System.out.println("No such command!");
                start(1);
                break;
        }
    }
}
