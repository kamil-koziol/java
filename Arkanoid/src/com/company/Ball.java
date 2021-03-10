package com.company;

import com.company.collisions.CollisionBox;
import com.company.collisions.CollisionBoxSideType;

import java.awt.*;

public class Ball extends GameObject {
    public int radius;

    private Color color = Color.red;

    public Ball(int x, int y, int radius) {
        super(x, y, radius, radius);
        this.radius = radius;

        this.setSpeedX(3);
        this.setSpeedY(3);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius, radius);
    }

    @Override
    public void update() {

        this.x += speedX;
        this.y += speedY;

        checkEdges();
        updateCollisionBox();
    }

    public void checkEdges() {
        if(collisionBox.x < 0) {
            x += Math.abs(2*speedX);
            y += speedY;
            speedX *= -1;
        }
        else if(collisionBox.x + collisionBox.width > Config.mainWindow.width) {
            x -= Math.abs(2*speedX);
            y += speedY;
            speedX *= -1;
        }

        if(collisionBox.y < 0) {
            y += Math.abs(2*speedY);
            x += speedX;
            speedY *= -1;
        }
        else if(collisionBox.y+(2*collisionBox.height) > Config.mainWindow.height) {
            y -= Math.abs(2*speedY);
            x += speedX;
            speedY *= -1;
        }
    }


    public void onCollision(CollisionBoxSideType type) {
        if(type != null) {
            switch (type) {
                case BOTTOM, TOP -> {
                    speedY *= -1;
                    y += 2 * speedY;
                }

                case LEFT, RIGHT -> {
                    speedX *= -1;
                    x += 2 * speedX;
                }
            }
        }
    }

    public void checkCollisions(BrickWall bw) {
        boolean collided = false;
        for(int i=0; i<bw.bricks.length; i++) {
            for (Brick brick: bw.bricks[i]) {

                if(brick.isDestroyed()) {
                    continue;
                }

                if(collides(brick)) {
                    brick.onBallCollision();
                    CollisionBoxSideType collisionBoxSideType = this.getCollisionSide(brick);
                    onCollision(collisionBoxSideType);

                    collided = true;
                    break;
                }
            }

            if(collided) {
                break;
            }
        }
    }

    public void checkCollisions(Platform p) {
        if(collides(p)) {
            CollisionBoxSideType collisionBoxSideType = this.getCollisionSide(p);
            onCollision(collisionBoxSideType);
        }
    }




}
