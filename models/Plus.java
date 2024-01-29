package models;

// Wong Guang Yu
public class Plus extends Piece {

    public Plus(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
        this.setName("Plus");
    }

    @Override
    public void checkPossibleMove() {
        setBlock(false);
        String currentCoordinate = getCoordinate();
        int currentRow = Integer.parseInt(currentCoordinate.substring(1));
        char currentCol = currentCoordinate.charAt(0);

        // Clear the possible moves list before recalculating
        clearPossibleMovesList();

        // move left (-)
        checkMoveInLeft(currentCol, currentRow);
        setBlock(false);

        // move right (+)
        checkMoveInRight(currentCol, currentRow);
        setBlock(false);

        // move down (-)
        checkMoveInDown(currentCol, currentRow);
        setBlock(false);

        // move up (+)
        checkMoveInUp(currentCol, currentRow);
    }

    private void checkMoveInLeft(char currentCol, int currentRow) {
        for (int left = 1; left < 7; left++) {
            char col = (char) (currentCol - left);
            String newCoordinate = col + Integer.toString(currentRow);
            if (isMoveValid(newCoordinate, this)) {
                addToPossibleMovesList(newCoordinate);
            }
            if (isBlocking())
                left = 7;
        }
    }

    private void checkMoveInRight(char currentCol, int currentRow) {
        for (int right = 1; right < 7; right++) {
            char col = (char) (currentCol + right);
            String newCoordinate = col + Integer.toString(currentRow);
            if (isMoveValid(newCoordinate, this)) {
                addToPossibleMovesList(newCoordinate);
            }
            if (isBlocking())
                right = 7;
        }
    }

    private void checkMoveInDown(char currentCol, int currentRow) {
        for (int down = 1; down < 6; down++) {
            String newCoordinate = currentCol + Integer.toString(currentRow-down);
            if (isMoveValid(newCoordinate, this)) {
                addToPossibleMovesList(newCoordinate);
            }
            if (isBlocking())
                down = 6;
        }
    }

    private void checkMoveInUp(char currentCol, int currentRow) {
        for (int up = 1; up < 6; up++) {
            String newCoordinate = currentCol + Integer.toString(currentRow+up);
            if (isMoveValid(newCoordinate, this)) {
                addToPossibleMovesList(newCoordinate);
            }
            if (isBlocking())
                up = 6;
        }
    }


}
