package models;

public class Hourglass extends Piece {

    public Hourglass(String imageUrl) {
        super(imageUrl, 0, 0);
    }

    @Override
    public void movePiece(int x, int y) {
        System.out.println("Hourglass piece moved to (" + x + ", " + y + ")");
        super.setCoordinateX(x);
        super.setCoordinateY(y);
    }
}
