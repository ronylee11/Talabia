package models;

public class Time extends Piece {

    public Time(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
        this.setName("Time");
    }

    @Override
    public void checkPossibleMove() {
        clearPossibleMovesList();
        setBlock(false);

        String currentCoordinate = getCoordinate();
        int currentRow = Integer.parseInt(currentCoordinate.substring(1));
        char currentCol = currentCoordinate.charAt(0);

        // Check diagonal capturing moves
        checkDiagonalMoves(currentCol, currentRow, 1, 1, true);  // Top right
        checkDiagonalMoves(currentCol, currentRow, 1, -1, true); // Top left
        checkDiagonalMoves(currentCol, currentRow, -1, 1, true); // Bottom right
        checkDiagonalMoves(currentCol, currentRow, -1, -1, true); // Bottom left

        // Check diagonal non-capturing moves
        checkDiagonalMoves(currentCol, currentRow, 1, 1, false);  // Top right
        checkDiagonalMoves(currentCol, currentRow, 1, -1, false); // Top left
        checkDiagonalMoves(currentCol, currentRow, -1, 1, false); // Bottom right
        checkDiagonalMoves(currentCol, currentRow, -1, -1, false); // Bottom left
    }

    private void checkDiagonalMoves(char currentCol, int currentRow, int rowDirection, int colDirection, boolean capturing) {
        for (int i = 1; i < 7; i++) {
            char col = (char) (currentCol + i * colDirection);
            int row = currentRow + i * rowDirection;
    
            if (row < 1 || row > 6 || col < 'a' || col > 'g') {
                // Stop if the move goes out of bounds
                break;
            }
    
            String targetCoordinate = col + Integer.toString(row);
    
            // Check if the move is capturing or non-capturing
            if (capturing) {
                if (isMoveValid(targetCoordinate, this)) {
                    addToPossibleMovesList(targetCoordinate);
                    if (PieceCoordinate.getPieceCoordinate().isOccupied(targetCoordinate)) {
                        setBlock(true);
                        // Stop capturing loop if there's an obstacle or an opponent piece
                        break;
                    }
                } else {
                    // Stop capturing loop if there's an obstacle or an opponent piece
                    break;
                }
            } else {
                if (isMoveValid(targetCoordinate, this)) {
                    addToPossibleMovesList(targetCoordinate);
                    if (PieceCoordinate.getPieceCoordinate().isOccupied(targetCoordinate)) {
                        setBlock(true);
                        // Stop non-capturing loop if there's an obstacle
                        break;
                    }
                } else {
                    // Stop non-capturing loop if there's an obstacle
                    break;
                }
            }
        }
    }
}

