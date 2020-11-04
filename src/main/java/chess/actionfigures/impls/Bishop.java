package chess.actionfigures.impls;

import chess.Board;
import chess.Position;
import chess.actionfigures.AllowedMovementsEnum;
import chess.actionfigures.BaseActionFigure;
import chess.actionfigures.exceptions.InvalidPositionException;

import java.util.List;

import static chess.actionfigures.AllowedMovementsEnum.*;

public class Bishop extends BaseActionFigure {
    public Bishop() {
        super(new AllowedMovementsEnum[] {DIAGONAL_LEFT_DOWN, DIAGONAL_RIGHT_UP,DIAGONAL_LEFT_UP,DIAGONAL_RIGHT_DOWN});
    }

    @Override
    public List<String> move() throws InvalidPositionException {
        allowedPositions.clear();
        Position currentPosition = getCurrentPosition();
        if(currentPosition.isInvalid()) {
            throw new InvalidPositionException(getCurrentPosition());
        }

        Position newPos = new Position(currentPosition);
        int currRow = (int)currentPosition.getRow();
        int currCol = currentPosition.getCol();

        for(int i = currRow - 1, j = currCol - 1; i >= Board.MINIMUM_ROW_VALUE && j >= Board.MINIMUM_COLUMN_VALUE; i--, j--) {
            newPos.setRow(i);
            newPos.setCol(j);
            allowedPositions.add(newPos.toString());
        }
        for(int i = currRow + 1, j = currCol + 1; i <= Board.MAXIMUM_ROW_VALUE && j <= Board.MAXIMUM_COLUMN_VALUE; i++, j++) {
            newPos.setRow(i);
            newPos.setCol(j);
            allowedPositions.add(newPos.toString());
        }

        for(int i = currRow - 1, j = currCol + 1; i >= Board.MINIMUM_ROW_VALUE && j <= Board.MAXIMUM_COLUMN_VALUE; i--, j++) {
            newPos.setRow(i);
            newPos.setCol(j);
            allowedPositions.add(newPos.toString());
        }
        for(int i = currRow + 1, j = currCol - 1; i <= Board.MAXIMUM_ROW_VALUE && j >= Board.MINIMUM_COLUMN_VALUE; i++, j--) {
            newPos.setRow(i);
            newPos.setCol(j);
            allowedPositions.add(newPos.toString());
        }

        return allowedPositions;
    }
}
