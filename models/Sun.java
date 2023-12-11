package models;

public class Sun extends Piece {

  public Sun(String imageUrl) {
    super(imageUrl, 0, 0);
  }

  @Override
  public void movePiece(int x, int y) {
    System.out.println("Plus piece moved to (" + x + ", " + y + ")");
    super.setCoordinateX(x);
    super.setCoordinateY(y);
  }
}
