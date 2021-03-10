package com.company;

import java.awt.*;

public class BrickWall {
    public Brick[][] bricks;

    public BrickWall(int rows, int columns) {
        bricks = populateBricks(rows, columns);
    }

    public BrickWall() {

        double widthPercentage = 1d;
        final int BRICKS_ROWS = (int) ((Config.mainWindow.width * widthPercentage)/Config.brickDimensions.width);
        final int BRICKS_COLUMNS = (int) ((Config.mainWindow.height * widthPercentage)/2/Config.brickDimensions.height);

        bricks = populateBricks(BRICKS_ROWS, BRICKS_COLUMNS);
    }

    private Brick[][] populateBricks(int rows, int columns) {
        bricks = new Brick[rows][columns];

        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                if(i == 0 || i == bricks.length - 1) {
                    bricks[i][j] = new Brick();
                    continue;
                }

                Point position = new Point(i * Config.brickDimensions.width, (j+1) * Config.brickDimensions.height);

                bricks[i][j] = new Brick(position.x, position.y, Config.brickDimensions.width - 5, Config.brickDimensions.height - 5);
            }
        }

        return bricks;
    }

    public void paint(Graphics g) {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                if(!bricks[i][j].isDestroyed()) {
                    bricks[i][j].paint(g);
                }
            }
        }
    }
}
