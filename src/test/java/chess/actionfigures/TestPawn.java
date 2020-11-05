package chess.actionfigures;

import chess.Position;
import chess.actionfigures.exceptions.InvalidPositionException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPawn {
    private static BaseActionFigure actionFigure;

    @BeforeClass
    public static void setup() throws Exception {
        actionFigure = ActionFigureFactory.getInstance(ActionFigureEnum.PAWN);
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
            add("C5");
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
        actionFigure.setCurrentPosition(new Position('A', 5));
        List<String> positions = actionFigure.move();
        Assert.assertNotNull(positions);
        Assert.assertEquals(0,positions.size());
    }
}
