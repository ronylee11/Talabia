import java.util.*;
import models.Board;
import views.BoardView;
import controllers.BoardController;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Talabia Chess");
        BoardView bv = new BoardView(new Board(500, 500));
    }
}
