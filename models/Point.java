package models;

import java.text.MessageFormat;

public class Point extends Piece {
    private int step;

    public Point(String imageUrl, String coordinate) {
        super(imageUrl, coordinate);
    }

    public int getStep() {
        return step;
    }

    public void setStep(int st) {
        step = st;
    }

    @Override
    public void movePiece(String newCoordinate) {
        System.out.println(MessageFormat.format("Time piece moved to ({0})", newCoordinate));
        super.setCoordinate(newCoordinate);
    }
}
