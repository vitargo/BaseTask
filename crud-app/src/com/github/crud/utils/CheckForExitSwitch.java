package com.github.crud.utils;

import com.github.crud.view.ViewMainMenu;
import com.github.crud.view.ViewMessages;

public class CheckForExitSwitch {

    public static void checkForCommand(String userInput) {
        String lowerCaseUserInput = userInput.toLowerCase();
        switch (lowerCaseUserInput) {
            case "exit":
                ViewMessages.exitMessage();
                System.exit(1);
            case "switch":
                ViewMessages.returningMessage();
                ViewMainMenu.start(1);
                break;
            case "help":
                ViewMessages.helpMessage();
                ViewMainMenu.start(1);
                break;
        }
    }
}
