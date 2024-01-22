package models;

public class Sun extends Piece {
    public Sun(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
    }

    // check all the possible move
    @Override
    public void checkPossibleMove() {
        clearPossibleMovesList();
        String currentCoordinate = getCoordinate();

        int[] columns = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] rows = {1, 1, 0, -1, -1, -1, 0, 1};

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
