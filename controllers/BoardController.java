package controllers;

import models.Board;
import views.BoardView;

public class BoardController {
    private Board model;
    private BoardView view;

    public BoardController(Board b, BoardView bv) {
        this.model = b;
        this.view = bv;
        view.setBoard(model); // connect view with model
    }

    public void setBoardDimension(int dimensionX, int dimensionY) {
        model.setDimensionX(dimensionX);
        model.setDimensionY(dimensionY);
    }

    public void updateBoard() {
        view.repaint();
    }
}
