package com.kamilkoziol;

import java.awt.*;
import java.util.Random;

public class CellBoard {

    Cell[][] cells;

    public CellBoard (int rows, int cols) {
        cells = new Cell[rows][cols];
        insertMines(5);
    }

    void paint(Graphics g) {
        for(int i=0; i<cells.length; i++) {
            for(int j=0; j<cells[i].length; j++) {
                if(cells[i][j] != null) {
                    System.out.println("elo");
                    cells[i][j].paint(g);
                }
            }
        }
    }

    void insertMines(int minesAmount) {
        Random r = new Random();
        int insertedMines = 0;
        while (insertedMines < minesAmount) {
            int randomRow = r.nextInt(cells.length -1);
            int randomCol = r.nextInt(cells[randomRow].length -1);

            if(cells[randomRow][randomCol] == null) {
                cells[randomRow][randomCol] = new Cell(
                        -1,
                        Config.CELL_SIZE,
                        Config.CELL_SIZE,
                        new Point(randomCol*Config.CELL_SIZE, randomRow*Config.CELL_SIZE)
                );
                insertedMines++;
            }
        }
    }

    void generateCellValues(int minesAmount) {
        insertMines(minesAmount);
        for(int i=0; i<cells.length; i++) {
            for(int j=0; j<cells[i].length; j++) {
                if(cells[i][j] != null) {
                    return;
                }
            }
        }
    }
}
