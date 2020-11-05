package chess.actionfigures.impls;

import chess.Board;
import chess.Position;
import chess.actionfigures.AllowedMovementsEnum;
import chess.actionfigures.BaseActionFigure;
import chess.actionfigures.exceptions.InvalidPositionException;

import java.util.List;

import static chess.actionfigures.AllowedMovementsEnum.UP;

public class Pawn extends BaseActionFigure {
    public Pawn() {
        super(new AllowedMovementsEnum[]{UP});
    }

    @Override
    public List<String> move() throws InvalidPositionException {
        allowedPositions.clear();
        Position currentPosition = getCurrentPosition();
        if(currentPosition.isInvalid()) {
            throw new InvalidPositionException(currentPosition);
        }
        int currRow = (int)currentPosition.getRow();
        if(currRow - 1 >= Board.MINIMUM_ROW_VALUE) {
            currentPosition.setRow(currRow - 1);
            allowedPositions.add(currentPosition.toString());
        }
        return allowedPositions;
    }
}
