package models;

import controllers.HourglassController;
import controllers.PieceController;
import views.PieceView;

public class Hourglass extends Piece {

    public Hourglass(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
    }

    @Override
    public PieceController createController(Piece piece, PieceView view) {
        return new HourglassController(piece, view);
    }

}
