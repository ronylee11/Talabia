package models;

import java.text.MessageFormat;

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

    @Override
    public void movePiece(String newCoordinate) {
        System.out.println(MessageFormat.format("Time piece moved to ({0})", newCoordinate));
        super.setCoordinate(newCoordinate);
    }
}
