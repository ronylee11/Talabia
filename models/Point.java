package models;

public class Point extends Piece {
    private boolean forward = true;
    private String imageUrl2; // in opposite direction
    private boolean switchDone = false;

    public Point(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
        this.setName("Point");
    }

    private boolean isForward() {
        return forward;
    }

    private void setToForward() {
        forward = true;
    }

    private void setToBackward() {
        forward = false;
    }

    public void setImageUrl2(String url) {
        imageUrl2 = url;
    }

    private boolean isSwitchDone() {
        return switchDone;
    }

    private void setSwitchDone(boolean b) {
        switchDone = b;
    }

    @Override
    public void switchUrl() {
        String temp = getImageUrl();
        setImageUrl(imageUrl2);
        imageUrl2 = temp;
    }

    // check all the possible move
    @Override
    public void checkPossibleMove() {
        clearPossibleMovesList();
        setBlock(false); 
        String currentCoordinate = getCoordinate();

        checkReachEnd(currentCoordinate);

        String targetCoordinate;
        for (int i = 1; i < 3; i++) {
            char char1 = currentCoordinate.charAt(0);
            int char2 = Character.getNumericValue(currentCoordinate.charAt(1));
            if (isForward()) {
                targetCoordinate = "" + char1 + (char2 + i);
            }
            else {
                targetCoordinate = "" + char1 + (char2 - i);
            }

            if (isMoveValid(targetCoordinate, this)) {
                addToPossibleMovesList(targetCoordinate);
            }
            
            // stop when have obstacles
            if (isBlocking())
                i = 3;
        }
    }

    // change direction when reach end
    private void checkReachEnd(String coordinate) {
        if (Game.getCurrentColor().equals(getColor())) {
            if (coordinate.charAt(1) == '6' || coordinate.charAt(1) == '1') { 
                if (!isSwitchDone()) {
                    switchUrl();
                    setSwitchDone(true);
                    if (coordinate.charAt(1) == '6')
                        setToBackward();
                    else 
                        setToForward();
                } 
            }
            else {
                setSwitchDone(false);
            }
        }
    }
}
