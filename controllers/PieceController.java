package controllers;

import models.Piece;
import views.PieceView;

public class PieceController {
    private Piece model;
    private PieceView view;

    public PieceController(Piece p, PieceView pv) {
        this.model = p;
        this.view = pv;
    }

    public void movePiece(int x, int y) {

    }

    public void switchMovingMethod() {

    }

    public boolean isMoveValid() {
        return false;
    }

}
