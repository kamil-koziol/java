package com.kamilkoziol;

import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Minesweeper");
        setSize(600,600);

        add(new MainPanel());

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
            Main mainWindow = new Main();
    }
}
