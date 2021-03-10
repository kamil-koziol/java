package com.kamilkoziol;

import java.awt.*;
import java.util.ArrayList;

public class GameController {
    public ArrayList<GameObject> gameObjects;
    public Snake snake;

    public GameController() {
        gameObjects = new ArrayList<GameObject>();

        snake = new Snake();
        gameObjects.add(snake);
    }

    public void updateObjects() {
        for(GameObject o: gameObjects) { o.update(); }
    }

    public void paintObjects(Graphics g) {
        for(GameObject o: gameObjects) { o.paint(g); }
    }
}
