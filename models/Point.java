package models;

public class Point extends Piece {
    private int step;

    public Point(String imageUrl, int coordinateX, int coordinateY) {
        super(imageUrl, coordinateX, coordinateY);
    }

    public int getStep() {
        return step;
    }

    public void setStep(int st) {
        step = st;
    }

    @Override
    public void movePiece(int x, int y) {
        System.out.println("Point piece moved to (" + x + ", " + y + ")");
        super.setCoordinateX(x);
        super.setCoordinateY(y);
    }
}
