package com.kamilkoziol.menu;

import com.kamilkoziol.MainWindow;
import com.kamilkoziol.menu.MainMenuItems.MainMenuEdycja;
import com.kamilkoziol.menu.MainMenuItems.MainMenuInfo;
import com.kamilkoziol.menu.MainMenuItems.MainMenuPlik;
import com.kamilkoziol.menu.MainMenuItems.MainMenuWidok;

import javax.swing.*;

public class MainMenu extends  JMenuBar {
    public MainMenu(MainWindow mainWindow) {
        super();

        MainMenuPlik plik = new MainMenuPlik(mainWindow);
        this.add(plik);

        MainMenuEdycja edycja = new MainMenuEdycja(mainWindow);
        this.add(edycja);

        MainMenuWidok widok = new MainMenuWidok(mainWindow);
        this.add(widok);

        MainMenuInfo info = new MainMenuInfo(mainWindow);
        this.add(info);
    }

}
