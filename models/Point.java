package models;

import java.text.MessageFormat;

public class Point extends Piece {

    public Point(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
        
    }

    @Override
    public void movePiece(String newCoordinate) {
        System.out.println(MessageFormat.format("Time piece moved to ({0})", newCoordinate));
        super.setCoordinate(newCoordinate);
    }
}
