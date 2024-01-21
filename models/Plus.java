package models;

import controllers.PieceController;
import controllers.PlusController;
import views.PieceView;

public class Plus extends Piece {

    public Plus(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
    }

    @Override
    public PieceController createController(Piece piece, PieceView view) {
        return new PlusController(piece, view);
    }

}
