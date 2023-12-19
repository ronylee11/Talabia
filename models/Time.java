package models;

public class Time extends Piece {
    public Time(String imageUrl, int coordinateX, int coordinateY) {
        super(imageUrl, coordinateX, coordinateY);
    }

    @Override
    public void movePiece(int x, int y) {
        System.out.println("Time piece moved to (" + x + ", " + y + ")");
        super.setCoordinateX(x);
        super.setCoordinateY(y);
    }
}
