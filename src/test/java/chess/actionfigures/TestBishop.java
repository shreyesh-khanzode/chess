package chess.actionfigures;

import chess.Position;
import chess.actionfigures.exceptions.InvalidPositionException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBishop {

    private static BaseActionFigure actionFigure;

    @BeforeClass
    public static void setup() throws Exception {
        actionFigure = ActionFigureFactory.getInstance(ActionFigureEnum.BISHOP);
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
            add("C3");add("B2");add("A1");add("E5");add( "F6");add( "G7");add( "H8");
            add("E3");add("F2");add("G1");add("C5");add( "B6");add( "A7");
        }};

        actionFigure.setCurrentPosition(new Position('D',4));
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
            add("C7");add("B6");add("A5");
            add("E7");add("F6");add("G5");add("H4");
        }};

        actionFigure.setCurrentPosition(new Position('D',8));
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
            add("C2");add("B3");add("A4");
            add("E2");add("F3");add("G4");add("H5");
        }};

        actionFigure.setCurrentPosition(new Position('D',1));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveUpRow() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("C2");add("B3");add("D1");
            add("B5");add("C6");add("D7");add("E8");
        }};

        actionFigure.setCurrentPosition(new Position('A',4));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveDownRow() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("G5");add("F6");add("E7");add("D8");
            add("G3");add("F2");add("E1");
        }};

        actionFigure.setCurrentPosition(new Position('H',4));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveUpLeftRow() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("B2");add("C3");add("D4");add("E5");
            add("F6");add("G7");add("H8");
        }};

        actionFigure.setCurrentPosition(new Position('A',1));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveBottomLeftRow() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("B7");add("C6");add("D5");add("E4");
            add("F3");add("G2");add("A8");
        }};

        actionFigure.setCurrentPosition(new Position('H',1));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveTopRightRow() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("B7");add("C6");add("D5");add("E4");
            add("F3");add("G2");add("H1");
        }};

        actionFigure.setCurrentPosition(new Position('A',8));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveBottomRightRow() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("B2");add("C3");add("D4");add("E5");
            add("F6");add("G7");add("A1");
        }};

        actionFigure.setCurrentPosition(new Position('H',8));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }
}
