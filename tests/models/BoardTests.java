import models.*;
import org.junit.Test;
import org.junit.Assertion;

public class BoardTests {
    @Test
    public void getDimension() {
        Board b = new Board(800, 500);
        Assertion.assertEquals(800, b.getDimensionX());
        Assertion.assertEquals(500, b.getDimensionY());
    }

}
