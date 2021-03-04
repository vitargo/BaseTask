package com.github.crud;

import com.github.crud.utils.FolderUtils;
import com.github.crud.view.ViewMainMenu;

public class Main {
    public static void main(String[] args) {
        FolderUtils.FolderUtils();
        int helloMessage = 0;
        ViewMainMenu.start(helloMessage);

    }
}
