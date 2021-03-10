package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Platform extends GameObject implements KeyListener {

    public Color color = Color.BLACK;

    public Platform(int x, int y, int width, int radius) {
        super(x, y, width, radius);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, this.width, this.height);
    }


    public void checkEdges() {
        if(x < 0) {
            x = 0;
        }
        else if(x+width > Config.mainWindow.width) {
            x = Config.mainWindow.width-width;
        }
    }

    public void update() {
        this.y += speedY;
        this.x += speedX;
        checkEdges();
        updateCollisionBox();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == e.VK_LEFT) {
            setSpeedX(-1);
        }
        else if(e.getKeyCode() == e.VK_RIGHT) {
            setSpeedX(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        setSpeedX(0);
    }

}
