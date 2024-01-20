package models;

import java.text.MessageFormat;

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
    
    @Override
    public void movePiece(String newCoordinate) {
        System.out.println(MessageFormat.format("Time piece moved to ({0})", newCoordinate));
        super.setCoordinate(newCoordinate);
    }

}
