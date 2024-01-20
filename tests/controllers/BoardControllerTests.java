import models.*;
import views.*;
import controllers.*;
//import org.junit.Test;
//import org.junit.Assertion;

public class BoardControllerTests {
    public BoardControllerTests() {
        Board board = new Board();
        BoardView view = new BoardView(board);
        BoardController controller = new BoardController(board, view);
    }
}
