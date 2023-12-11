import java.util.*;
import models.Board;
import views.BoardView;
import controllers.BoardController;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Talabia Chess");
        Board b = new Board(300, 300);

        BoardView bv = new BoardView();

        BoardController bc = new BoardController(b, bv);

        bc.updateBoard();

    }
}
