package models;

import controllers.PieceController;
import controllers.SunController;
import views.PieceView;

public class Sun extends Piece {
    public Sun(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
    }

    @Override
    public PieceController createController(Piece piece, PieceView view) {
        return new SunController(piece, view);
    }
}
