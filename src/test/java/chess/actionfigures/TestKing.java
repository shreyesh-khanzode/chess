package chess.actionfigures;

import chess.Position;
import chess.actionfigures.exceptions.InvalidActionFigureTypeException;
import chess.actionfigures.exceptions.InvalidPositionException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestKing {
    private static BaseActionFigure actionFigure;

    @BeforeClass
    public static void setup() throws Exception {
        actionFigure = ActionFigureFactory.getInstance(ActionFigureEnum.KING);
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
            add("D4");add("D6");add("C4");add("C5");add( "C6");add( "E4");add( "E5");add( "E6");
        }};
        actionFigure.setCurrentPosition(new Position('D', 5));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );

    }

    @Test
    public void testMoveWithExtremeRightColPosition() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("D7");add("C7");add("C8");add( "E7");add( "E8");
        }};
        actionFigure.setCurrentPosition(new Position('D', 8));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0, positions.size());
        Assert.assertEquals(expectedPositions.size(), positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );

    }

    @Test
    public void testMoveWithExtremeLeftColPosition() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("D2");add("C1");add("C2");add( "E1");add( "E2");
        }};
        actionFigure.setCurrentPosition(new Position('D', 1));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0, positions.size());
        Assert.assertEquals(expectedPositions.size(), positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );

    }

    @Test
    public void testMoveWithExtremeUpRowPosition() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("A4");add("A6");add("B4");add( "B5");add( "B6");
        }};
        actionFigure.setCurrentPosition(new Position('A', 5));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0, positions.size());
        Assert.assertEquals(expectedPositions.size(), positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );

    }

    @Test
    public void testMoveWithExtremeDownRowPosition() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("H4");add("H6");add("G4");add( "G5");add( "G6");
        }};
        actionFigure.setCurrentPosition(new Position('H', 5));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0, positions.size());
        Assert.assertEquals(expectedPositions.size(), positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );

    }

    @Test
    public void testMoveWithExtremeLeftDownRowColPosition() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("H2");add("G1");add("G2");
        }};
        actionFigure.setCurrentPosition(new Position('H', 1));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0, positions.size());
        Assert.assertEquals(expectedPositions.size(), positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );

    }

    @Test
    public void testMoveWithExtremeLeftUpRowColPosition() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("A2");add("B1");add("B2");
        }};
        actionFigure.setCurrentPosition(new Position('A', 1));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0, positions.size());
        Assert.assertEquals(expectedPositions.size(), positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );

    }

    @Test
    public void testMoveWithExtremeRightUpRowColPosition() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("A7");add("B7");add("B8");
        }};
        actionFigure.setCurrentPosition(new Position('A', 8));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0, positions.size());
        Assert.assertEquals(expectedPositions.size(), positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );

    }

    @Test
    public void testMoveWithExtremeRightDownRowColPosition() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("H7");add("G7");add("G8");
        }};
        actionFigure.setCurrentPosition(new Position('H', 8));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0, positions.size());
        Assert.assertEquals(expectedPositions.size(), positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );

    }

}
