package com.kamilkoziol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JPanel implements ActionListener {
    int frameRate;

    Point mouse;

    int width;
    int height;

    Timer timer;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
        updateMouseInfo();

        setSize(width, height);

        setFramerate(60);
        timer = new Timer(1000/frameRate, this);
        timer.start();

        setBackground(Color.BLACK);
        setLayout(null);
        setFocusable(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateMouseInfo();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void setFramerate(int frameRate) {
        this.frameRate = frameRate;
    }

    public void updateMouseInfo() {
        mouse = MouseInfo.getPointerInfo().getLocation();
    }
}
