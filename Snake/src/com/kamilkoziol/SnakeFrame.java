package com.kamilkoziol;

import javax.swing.*;

public class SnakeFrame extends JFrame {
    int width = 1024;
    int height = 1024;

    SnakeWindow mainWindow;

    public SnakeFrame() {
        super();
        setSize(width, height);
        setTitle("Snake");

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainWindow = new SnakeWindow();
        this.add(mainWindow);

        setVisible(true);
    }
}
