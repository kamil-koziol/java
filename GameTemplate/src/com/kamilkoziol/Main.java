package com.kamilkoziol;


import javax.swing.*;

public class Main extends JFrame {

    Window window;
    int width = 1024;
    int height = 1024;

    Main() {
        setSize(width, height);
        setTitle("Main");

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window = new Window(width, height);
        add(window);
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}
