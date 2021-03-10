package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public Main() {
        initUI();
    }

    public void initUI() {
        setTitle("Arkanoid");

        GameBoard gameBoard = new GameBoard();
        add(gameBoard);

        setSize(Config.mainWindow.width, Config.mainWindow.height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Main mainWindow = new Main();
            mainWindow.setVisible(true);
        });

    }
}
