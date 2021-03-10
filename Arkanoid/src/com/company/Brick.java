package com.company;

import java.awt.*;
import java.util.Random;

public class Brick extends GameObject {

    public int toughness = 1;

    public Color mainColor = Color.WHITE;
    public Color borderColor = Color.BLACK;


    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Brick() {
        super(0, 0, 0, 0);
        toughness = 0;
    }

    public void paint(Graphics g) {
        g.setColor(borderColor);
        g.fillRect(x, y, this.width, this.height);
        g.setColor(mainColor);
        g.fillRect(x+1, y+1, width-2, height-2);
    }

    public void damage(int amount) {
        toughness -= amount;
        if(toughness < 0) {
            toughness=0;
        }
    }

    public boolean isDestroyed() {
        return toughness == 0;
    }

    public void onBallCollision() {
        this.damage(1);
    }
}
