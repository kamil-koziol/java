package com.company.collisions;

import java.awt.*;

public class CollisionBox extends Rectangle {

    CollisionBoxSide[] collisionBoxSides;

    public CollisionBox(int x, int y, int width, int height) {
        super(x, y, width, height);

        this.collisionBoxSides = new CollisionBoxSide[] {
                new CollisionBoxSide(CollisionBoxSideType.TOP),
                new CollisionBoxSide(CollisionBoxSideType.BOTTOM),
                new CollisionBoxSide(CollisionBoxSideType.LEFT),
                new CollisionBoxSide(CollisionBoxSideType.RIGHT),
        };

        updateCollisionSides();
    }

    public void paint(Graphics g) {
        g.setColor(Color.green);
        for(CollisionBoxSide collisionBoxSide: collisionBoxSides) {
            g.drawRect(collisionBoxSide.x, collisionBoxSide.y, collisionBoxSide.width, collisionBoxSide.height);
        }
    }

    public void update(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        updateCollisionSides();
    }

    private void updateCollisionSides() {
        int gap = 0;

        this.collisionBoxSides[0].setBounds(x + gap, y, width - gap, 1);
        this.collisionBoxSides[1].setBounds(x + gap, y + height, width - gap, 1);
        this.collisionBoxSides[2].setBounds(x, y + gap, 1, height - gap);
        this.collisionBoxSides[3].setBounds(x + width, y + gap, 1, height - gap);
    }

    public boolean collides(CollisionBox other) {
        for(int i=0; i<collisionBoxSides.length; i++) {
            for(int j=0; j<other.collisionBoxSides.length; j++) {
                if(collisionBoxSides[i].intersects(other.collisionBoxSides[j])) {
                    return true;
                }
            }
        }

        return false;
    }
    public CollisionBoxSideType getCollisionSide(CollisionBox other) {
        for(int i=0; i<collisionBoxSides.length; i++) {
            for(int j=0; j<other.collisionBoxSides.length; j++) {
                if(collisionBoxSides[i].intersects(other.collisionBoxSides[j])) {
                    return  collisionBoxSides[i].type;
                }
            }
        }

        return null;
    }

}
