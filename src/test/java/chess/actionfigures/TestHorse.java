package chess.actionfigures;

import chess.Position;
import chess.actionfigures.exceptions.InvalidPositionException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestHorse {
    private static BaseActionFigure actionFigure;

    @BeforeClass
    public static void setup() throws Exception {
        actionFigure = ActionFigureFactory.getInstance(ActionFigureEnum.HORSE);
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
            add("B3");add("B5");add("C2");add("C6");add( "E2");add( "E6");
            add("F3");add("F5");
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
    public void testMoveTop() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("C3");add("C5");add("B2");add("B6");
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
    public void testMoveBottom() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("F3");add("F5");add("G2");add("G6");
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
    public void testMoveLeft() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("C3");add("E3");add("B2");add("F2");
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
    public void testMoveRight() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("C6");add("E6");add("B7");add("F7");
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
    public void testMoveTopLeft() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("C2");add("B3");
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
    public void testMoveBottomLeft() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("F2");add("G3");
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
    public void testMoveTopRight() throws Exception {
        List<String> expectedPositions = new ArrayList<String>(){{
            add("C7");add("B6");
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
            add("F7");add("G6");
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

}
