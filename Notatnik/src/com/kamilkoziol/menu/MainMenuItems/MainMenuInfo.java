package com.kamilkoziol.menu.MainMenuItems;

import com.kamilkoziol.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuInfo extends JMenu {

    MainWindow mainWindow;

    public MainMenuInfo(MainWindow mainWindow) {
        super();

        this.mainWindow = mainWindow;

        setText("Informacje");

        JMenuItem Autor = new JMenuItem("Autor");
        Autor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Kamil Kozioł",
                        "Autor",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        this.add(Autor);
    }
}
