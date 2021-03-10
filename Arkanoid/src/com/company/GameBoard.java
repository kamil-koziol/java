package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameBoard extends JPanel implements ActionListener {

    Timer timer;

    private BrickWall brickWall;
    private Platform platform;
    private Ball ball;

    public GameBoard() {
        setBounds(0,0, Config.mainWindow.width, Config.mainWindow.height);

        timer = new Timer(Config.timerDelay, this);
        timer.start();

        brickWall = new BrickWall();
        platform = new Platform(Config.startingPlatformPoint.x, Config.startingPlatformPoint.y, Config.startingPlatformDimensions.width, Config.startingPlatformDimensions.height);
        ball = new Ball(Config.startingBallPosition.x, Config.startingBallPosition.y, Config.startingBallRadius);

        addKeyListener(platform);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        brickWall.paint(g);
        platform.paint(g);
        ball.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        platform.update();

        ball.update();
        ball.checkCollisions(brickWall);
        ball.checkCollisions(platform);

        repaint();
    }


}
