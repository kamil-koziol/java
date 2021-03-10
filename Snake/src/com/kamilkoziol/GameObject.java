package com.kamilkoziol;

import java.awt.*;
import java.awt.geom.Point2D;

public class GameObject {

    Point position;

    public GameObject() {
        position = new Point(0, 0);
    }

    public void update() {
    }

    public void paint(Graphics g) {
        g.fillRect((int) position.getX(), (int) position.getY(), 16, 16);
    }
}
