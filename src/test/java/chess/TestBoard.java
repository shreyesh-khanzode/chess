package chess;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBoard {
    private static Board board;

    @BeforeClass
    public static void setup() throws Exception {
        board = new Board();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        board = null;
    }

    @Test
    public void testPrint() throws Exception {
        board.print();
    }
}
