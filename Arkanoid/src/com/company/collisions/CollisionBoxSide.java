package com.company.collisions;

import java.awt.*;

public class CollisionBoxSide extends Rectangle {
    CollisionBoxSideType type;

    public CollisionBoxSide(int x, int y, int width, int height, CollisionBoxSideType type) {
        super(x, y, width, height);
        this.type = type;
    }

    public CollisionBoxSide(CollisionBoxSideType type) {
        super(0, 0, 0, 0);
        this.type = type;
    }
}
