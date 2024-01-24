package models;

// piece color
public enum PieceColor {
    YELLOW("y"), // Assign color strings here
    BLUE("b");

    private final String colorString;

    private PieceColor(String colorString) {
        this.colorString = colorString;
    }

    public String getColorString() {
        return colorString;
    }
}
