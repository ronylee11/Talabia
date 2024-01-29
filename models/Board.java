package models;

import java.util.Map;

public class Board {
    private int dimensionX = 800;
    private int dimensionY = 800;

    // Lee Rong Yi
    public Board() {
    }

    // Lee Rong Yi
    public Board(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    // Lee Rong Yi
    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    // Lee Rong Yi
    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

    // Lee Rong Yi
    public int getDimensionX() {
        return this.dimensionX;
    }

    // Lee Rong Yi
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
