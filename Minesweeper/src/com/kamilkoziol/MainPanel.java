package com.kamilkoziol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainPanel extends JPanel implements ActionListener, KeyListener {
    Timer timer;
    CellBoard cb;
    public MainPanel() {
        setBounds(0,0,600,600);

        timer = new Timer(5, this);
        timer.start();

        cb = new CellBoard(20,20);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        cb.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
