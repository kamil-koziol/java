package com.kamilkoziol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeWindow extends JPanel implements ActionListener {
    int width = 1024;
    int height = 1024;
    int frameRate = 60;

    Timer timer;
    GameController gameController;

    public SnakeWindow() {
        setSize(width, height);

        timer = new Timer(1000/frameRate, this);
        timer.start();

        gameController = new GameController();

        setLayout(null);
        setFocusable(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameController.updateObjects();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        gameController.paintObjects(g);
    }
}
