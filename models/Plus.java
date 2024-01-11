package models;

import java.text.MessageFormat;

public class Plus extends Piece {

    public Plus(String imageUrl, String coordinate) {
        super(imageUrl, coordinate);
    }

    @Override
    public void movePiece(String newCoordinate) {
        System.out.println(MessageFormat.format("Time piece moved to ({0})", newCoordinate));
        super.setCoordinate(newCoordinate);
    }
}
