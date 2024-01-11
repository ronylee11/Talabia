package models;

public abstract class Piece {
    private String imageUrl;
    private String coordinate;

    public Piece(String imageUrl, String coordinate) {
        this.imageUrl = imageUrl;
        this.coordinate = coordinate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public abstract void movePiece(String newCoordinate);
}
