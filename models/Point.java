package models;

import java.text.MessageFormat;

public class Point extends Piece {
    private boolean forward = true;

    public Point(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
        
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
