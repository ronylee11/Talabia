package models;

public class Piece {
    private String imageUrl;
    private int coordinateX;
    private int coordinateY;

    public Piece() {

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getCoordnateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCoordinateX(int x) {
        coordinateX = x;
    }

    public void setCoordinateY(int y) {
        coordinateY = y;
    }

}