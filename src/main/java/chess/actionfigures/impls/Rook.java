package chess.actionfigures.impls;

import chess.Board;
import chess.Position;
import chess.actionfigures.AllowedMovementsEnum;
import chess.actionfigures.BaseActionFigure;
import chess.actionfigures.exceptions.InvalidPositionException;

import java.util.List;

import static chess.actionfigures.AllowedMovementsEnum.*;

public class Rook extends BaseActionFigure {
    public Rook() {
        super(new AllowedMovementsEnum[]{DOWN, UP, LEFT, RIGHT});
    }

    @Override
    public List<String> move() throws InvalidPositionException {
        allowedPositions.clear();
        Position currentPosition = getCurrentPosition();
        if(currentPosition.isInvalid()) {
            throw new InvalidPositionException(currentPosition);
        }

        Position newPos = new Position(currentPosition);
        int currRow = (int)currentPosition.getRow();
        int currCol = currentPosition.getCol();
        for(int i = currRow - 1; i >= Board.MINIMUM_ROW_VALUE; i--) {
            newPos.setRow(i);
            allowedPositions.add(newPos.toString());
        }
        for(int i = currRow + 1; i <= Board.MAXIMUM_ROW_VALUE; i++) {
            newPos.setRow(i);
            allowedPositions.add(newPos.toString());
        }

        newPos.setRow(currRow);
        for(int i = currCol - 1; i >= Board.MINIMUM_COLUMN_VALUE; i--) {
            newPos.setCol(i);
            allowedPositions.add(newPos.toString());
        }
        for(int i = currCol + 1; i <= Board.MAXIMUM_COLUMN_VALUE; i++) {
            newPos.setCol(i);
            allowedPositions.add(newPos.toString());
        }

        return allowedPositions;
    }
}
