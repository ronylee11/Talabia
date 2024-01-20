import models.*;
import views.*;
import org.junit.Test;
import org.junit.Assertion;

public class BoardViewTests {
    @Test
    public void testBoardView() {
        Board board = new Board();
        BoardView view = new BoardView(board);
    }
}
