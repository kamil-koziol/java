package com.kamilkoziol;

import java.awt.*;

public class Cell {

    int value;
    int width;
    int height;
    Point pos;


    public Cell(int _value, int _width, int _height ,Point _pos) {
        value = _value;
        width = _width;
        height = _height;
        pos = _pos;
    }

    boolean isMine() {
        return value == -1;
    }

    void getNeigbours(Cell[][] cells) {

    }

    int getAroundMines() {
        return 0;
    }

    void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(pos.x, pos.y, width, height);
        g.setColor(Color.RED);
        g.fillRect(pos.x+1, pos.y+1, width-2, height-2);
    }
}
