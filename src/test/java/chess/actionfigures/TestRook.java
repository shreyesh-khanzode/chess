package chess.actionfigures;

import chess.Position;
import chess.actionfigures.exceptions.InvalidPositionException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRook {
    private static BaseActionFigure actionFigure;

    @BeforeClass
    public static void setup() throws Exception {
        actionFigure = ActionFigureFactory.getInstance(ActionFigureEnum.ROOK);
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
            add("D4");add("D3");add("D2");add("D1");add( "D6");add( "D7");add("D8");
            add("A5");add("B5");add("C5");add("E5");add("F5");add("G5");add("H5");
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
    public void testMoveTop() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("A4");add("A3");add("A2");add("A1");add( "A6");add( "A7");add("A8");
            add("D5");add("B5");add("C5");add("E5");add("F5");add("G5");add("H5");
        }};

        actionFigure.setCurrentPosition(new Position('A', 5));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveBottom() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("H4");add("H3");add("H2");add("H1");add( "H6");add( "H7");add("H8");
            add("D5");add("B5");add("C5");add("E5");add("F5");add("G5");add("A5");
        }};

        actionFigure.setCurrentPosition(new Position('H', 5));
        List<String> positions = actionFigure.move();

        Assert.assertNotNull(positions);
        Assert.assertNotEquals(0,positions.size());
        Assert.assertEquals(expectedPositions.size(),positions.size());
        Assert.assertTrue(
                expectedPositions.containsAll(positions)
        );
    }

    @Test
    public void testMoveRight() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("A8");add("B8");add("C8");add("E8");add( "F8");add( "G8");add("H8");
            add("D1");add("D2");add("D3");add("D4");add("D5");add("D6");add("D7");
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
    public void testMoveLeft() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("A1");add("B1");add("C1");add("E1");add( "F1");add( "G1");add("H1");
            add("D8");add("D2");add("D3");add("D4");add("D5");add("D6");add("D7");
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
    public void testMoveTopLeft() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("D1");add("B1");add("C1");add("E1");add( "F1");add( "G1");add("H1");
            add("A2");add("A3");add("A4");add("A5");add("A6");add("A7");add("A8");
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
    public void testMoveTopRight() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("D8");add("B8");add("C8");add("E8");add( "F8");add( "G8");add("H8");
            add("A2");add("A3");add("A4");add("A5");add("A6");add("A7");add("A1");
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
    public void testMoveBottomRight() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("D8");add("B8");add("C8");add("E8");add( "F8");add( "G8");add("A8");
            add("H2");add("H3");add("H4");add("H5");add("H6");add("H7");add("H1");
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
    public void testMoveBottomLeft() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("D1");add("B1");add("C1");add("E1");add( "F1");add( "G1");add("A1");
            add("H2");add("H3");add("H4");add("H5");add("H6");add("H7");add("H8");
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
}
