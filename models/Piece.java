package models;

public abstract class Piece {
    private String imageUrl;
    private int coordinateX;
    private int coordinateY;

    public Piece(String imageUrl, int coordinateX, int coordinateY) {
        this.imageUrl = imageUrl;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getCoordinateX() {
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

    public abstract void movePiece(int coordinateX, int coordinateY);
}
