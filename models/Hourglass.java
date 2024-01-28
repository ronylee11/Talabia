package models;

public class Hourglass extends Piece {

    public Hourglass(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
        this.setName("Hourglass");
    }

    // check all the possible move
    @Override
    public void checkPossibleMove() {
        clearPossibleMovesList();
        String currentCoordinate = getCoordinate();

        int[] columns = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] rows = {2, -2, 2, -2, 1, -1, 1, -1};

        String targetCoordinate;
        for (int i = 0; i < columns.length; i++) {
            char newColumn = (char) (currentCoordinate.charAt(0) + columns[i]);
            int newRow = (Character.getNumericValue(currentCoordinate.charAt(1)) + rows[i]);
            targetCoordinate = "" + newColumn + newRow;
            if (isMoveValid(targetCoordinate, this)) {
                addToPossibleMovesList(targetCoordinate);
            }
        }
    }

}
