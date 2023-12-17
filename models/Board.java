package models;

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
}
