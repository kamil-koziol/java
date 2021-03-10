package com.company;

import java.awt.*;

public class Config {
    // Window
    static Dimension mainWindow = new Dimension(600,600);

    static int bricksInColumnAmount = 5;
    static int bricksInRowAmount = 20;

    // Brick
    static Dimension brickDimensions = new Dimension(mainWindow.width/(Config.bricksInColumnAmount+2), mainWindow.height/(Config.bricksInRowAmount * 2));

    // Platform
    static Point startingPlatformPoint = new Point(mainWindow.width/2, mainWindow.height-60);
    static Dimension startingPlatformDimensions = new Dimension(150,20);

    // Ball
    static Point startingBallPosition = new Point(300, 400);
    static int startingBallRadius = 20;
    // Timer
    static int timerDelay = 5;
}
