package chess.actionfigures;

import chess.Position;
import chess.actionfigures.exceptions.InvalidPositionException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestQueen {
    private static BaseActionFigure actionFigure;

    @BeforeClass
    public static void setup() throws Exception {
        actionFigure = ActionFigureFactory.getInstance(ActionFigureEnum.QUEEN);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        actionFigure = null;
    }

    @Test
    public void testObjectCreation() throws Exception {
        Assert.assertNotNull(actionFigure);
    }

    @Test(expected = InvalidPositionException.class)
    public void testMoveInvalidPosition() throws Exception {
        actionFigure.setCurrentPosition(new Position('a', 5));
        List<String> move = actionFigure.move();
    }

    @Test
    public void testMove() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("D3");add("D2");add("D1");add("D5");add( "D6");add( "D7");add( "D8");
            add( "C4");add( "B4");add( "A4");add( "E4");add( "F4");add( "G4");add( "H4");
            add( "C3");add( "B2");add( "A1");add( "E5");add( "F6");add( "G7");add( "H8");
            add( "C5");add( "B6");add( "A7");add( "E3");add( "F2");add( "G1");
        }};

        actionFigure.setCurrentPosition(new Position('D', 4));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveBottomRow() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("H3");add("H2");add("H1");add("H5");add( "H6");add( "H7");add( "H8");
            add( "G4");add( "F4");add( "E4");add( "D4");add( "C4");add( "B4");add( "A4");
            add( "G3");add( "F2");add( "E1");
            add( "G5");add( "F6");add( "E7");add( "D8");
        }};

        actionFigure.setCurrentPosition(new Position('H', 4));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveTopRow() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("A3");add("A2");add("A1");add("A5");add( "A6");add( "A7");add( "A8");
            add( "B4");add( "C4");add( "D4");add( "E4");add( "F4");add( "G4");add( "H4");
            add( "B3");add( "C2");add( "D1");
            add( "B5");add( "C6");add( "D7");add( "E8");
        }};

        actionFigure.setCurrentPosition(new Position('A', 4));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveRightCol() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("D1");add("D2");add("D3");add("D4");add( "D5");add( "D6");add( "D7");
            add( "B8");add( "C8");add( "A8");add( "E8");add( "F8");add( "G8");add( "H8");
            add( "E7");add( "F6");add( "G5");add( "H4");
            add( "C7");add( "B6");add( "A5");
        }};

        actionFigure.setCurrentPosition(new Position('D', 8));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveLeftCol() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("D8");add("D2");add("D3");add("D4");add( "D5");add( "D6");add( "D7");
            add( "B1");add( "C1");add( "A1");add( "E1");add( "F1");add( "G1");add( "H1");
            add( "E2");add( "F3");add( "G4");add( "H5");
            add( "C2");add( "B3");add( "A4");
        }};

        actionFigure.setCurrentPosition(new Position('D', 1));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveUpLeftCol() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("A8");add("A2");add("A3");add("A4");add( "A5");add( "A6");add( "A7");
            add( "B1");add( "C1");add( "D1");add( "E1");add( "F1");add( "G1");add( "H1");
            add( "B2");add( "C3");add( "D4");add( "E5");add( "F6");add( "G7");add( "H8");
        }};

        actionFigure.setCurrentPosition(new Position('A', 1));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveBottomLeftCol() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("H8");add("H2");add("H3");add("H4");add( "H5");add( "H6");add( "H7");
            add( "B1");add( "C1");add( "D1");add( "E1");add( "F1");add( "G1");add( "A1");
            add( "G2");add( "F3");add( "E4");add( "D5");add( "C6");add( "B7");add( "A8");
        }};

        actionFigure.setCurrentPosition(new Position('H', 1));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveUpRightCol() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("A1");add("A2");add("A3");add("A4");add( "A5");add( "A6");add( "A7");
            add( "B8");add( "C8");add( "D8");add( "E8");add( "F8");add( "G8");add( "H8");
            add( "G2");add( "F3");add( "E4");add( "D5");add( "C6");add( "B7");add( "H1");
        }};

        actionFigure.setCurrentPosition(new Position('A', 8));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveBottomRightCol() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("H1");add("H2");add("H3");add("H4");add( "H5");add( "H6");add( "H7");
            add( "B8");add( "C8");add( "D8");add( "E8");add( "F8");add( "G8");add( "A8");
            add( "G7");add( "F6");add( "E5");add( "D4");add( "C3");add( "B2");add( "A1");
        }};

        actionFigure.setCurrentPosition(new Position('H', 8));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveRandom() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("E1");add("E3");add("E4");add("E5");add( "E6");add( "E7");add( "E8");
            add( "A2");add( "B2");add( "C2");add( "D2");add( "F2");add( "G2");add( "H2");
            add( "F1");add( "D3");add( "C4");add( "B5");add( "A6");
            add( "F3");add( "G4");add( "H5");add( "D1");
        }};

        actionFigure.setCurrentPosition(new Position('E', 2));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

}
