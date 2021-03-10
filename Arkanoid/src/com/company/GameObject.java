package com.company;

import com.company.collisions.CollisionBox;
import com.company.collisions.CollisionBoxSideType;

import java.awt.*;

public class GameObject {
    public int x;
    public int y;

    public int width;
    public int height;

    public int speedX;
    public int speedY;

    public CollisionBox collisionBox;

    public GameObject(int x, int y, int width, int height) {
        this.collisionBox = new CollisionBox(x, y, width, height);

        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setSpeedX(0);
        setSpeedY(0);
    }

    public void paint(Graphics g) { }
    public void update() { }
    public void updateCollisionBox() { this.collisionBox.update(x, y, width, height); }

    public boolean collides(GameObject other) { return this.collisionBox.collides(other.collisionBox); }
    public CollisionBoxSideType getCollisionSide(GameObject other) { return this.collisionBox.getCollisionSide(other.collisionBox); }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public CollisionBox getCollisionBox() {
        return collisionBox;
    }

    public void setCollisionBox(CollisionBox collisionBox) {
        this.collisionBox = collisionBox;
    }
}
