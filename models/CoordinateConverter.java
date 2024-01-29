package models;

// Chia Zhi Xuan
public class CoordinateConverter {
    private CoordinateConverter(){};

    public static String convertCoordinate(String coordinate) {
        char ch1 = convertColumn(coordinate.charAt(0));
        char ch2 = convertRow(coordinate.charAt(1));

        coordinate = "" + ch1 + ch2;
        return coordinate;
    }

    private static char convertColumn(char col) {
        switch (col) {
            case 'a' :
                col = 'g';
                break;
            case 'b' :
                col = 'f';
                break;
            case 'c' :
                col = 'e';
                break;
            case 'g' :
                col = 'a';
                break;
            case 'f' :
                col = 'b';
                break;
            case 'e' :
                col = 'c';
                break;
        }
        return col;
    }

    private static char convertRow(char row) {
        switch (row) {
            case '1' :
                row = '6';
                break;
            case '2' :
                row = '5';
                break;
            case '3' :
                row = '4';
                break;
            case '6' :
                row = '1';
                break;
            case '5' :
                row = '2';
                break;
            case '4' :
                row = '3';
                break;
        }
        return row;
    }
}
