package models;

import java.util.Map;

public class Board {
    private int dimensionX = 800;
    private int dimensionY = 800;

    public Board() {
    }

    public Board(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

    public int getDimensionX() {
        return this.dimensionX;
    }

    public int getDimensionY() {
        return this.dimensionY;
    }

    // Chia Zhi Xuan
    public void flipBoard() {
        PieceCoordinate pc = PieceCoordinate.getPieceCoordinate();
        pc.changeCoordinate();
        Map<String, Piece> map = pc.getCoordinateMap();
        // change image direction for point
        map.forEach((key, value) -> {
            value.switchUrl();
        });
    }
}
