package models;

import java.text.MessageFormat;

import controllers.PieceController;
import controllers.PointController;
import views.PieceView;

public class Point extends Piece {
    private boolean forward = true;

    public Point(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
        
    }

    @Override
    public PieceController createController(Piece piece, PieceView view) {
        return new PointController(piece, view);
    }

    public boolean isForward() {
        return forward;
    }

    public void setToForward() {
        forward = true;
    }

    public void setToBackward() {
        forward = false;
    }

    @Override
    public void movePiece(String newCoordinate) {
        System.out.println(MessageFormat.format("Time piece moved to ({0})", newCoordinate));
        super.setCoordinate(newCoordinate);
    }
}
