package com.github.crud.view;

import com.github.crud.exeptions.CrudException;
import com.github.crud.utils.CheckForExitSwitch;

public class UserInputForCommand {

    public static String[] separateUserInputToArray() {
        String line;
        line = ScannerWrapper.getString().toLowerCase();
        String[] array = line.split(" ");
        if (array.length == 1) {
            if (line.equals("switch") || line.equals("help") || line.equals("exit")) {
                CheckForExitSwitch.checkForCommand(line);
            } else if (line.equals("create") || line.equals("update") || line.equals("read") || line.equals("delete")) {
                System.out.println("Not valid input! Enter also 'filename.extension'. Check and try again.\n");
                ViewMainMenu.start(1);
            } else {
                throw new CrudException("Not valid input! Check and try again.\n");
            }
        } else if (array.length == 2) {
            String[] words = line.split(" ");
            String command = words[0];
            String fileNameAndFormat = words[1];
            String[] nameAndFormatSeparated;
            String fileFormat = null;
            try {
                nameAndFormatSeparated = words[1].split("\\.");
                fileFormat = nameAndFormatSeparated[1];
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Not valid input! Check and try again.\n");
                ViewMainMenu.start(1);
            }
            array = new String[]{fileFormat, command, fileNameAndFormat};
        } else {
            throw new CrudException("Not valid input! Check and try again.\n");
        }
        return array;
    }
}
