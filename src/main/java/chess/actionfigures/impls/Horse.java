package chess.actionfigures.impls;

import chess.Board;
import chess.Position;
import chess.actionfigures.AllowedMovementsEnum;
import chess.actionfigures.BaseActionFigure;
import chess.actionfigures.exceptions.InvalidPositionException;

import java.util.List;

import static chess.actionfigures.AllowedMovementsEnum.TWO_AND_HALF;

public class Horse extends BaseActionFigure {
    public Horse() {
        super(new AllowedMovementsEnum[]{TWO_AND_HALF});
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

        if(currRow - 2 >= Board.MINIMUM_ROW_VALUE) {
            newPos.setRow(currRow - 2);
            if(currCol -1 >= Board.MINIMUM_COLUMN_VALUE) {
                newPos.setCol(currCol - 1);
                allowedPositions.add(newPos.toString());
            }
            if(currCol + 1 <= Board.MAXIMUM_COLUMN_VALUE) {
                newPos.setCol(currCol + 1);
                allowedPositions.add(newPos.toString());
            }
        }

        if(currRow - 1 >= Board.MINIMUM_ROW_VALUE) {
            newPos.setRow(currRow - 1);
            if(currCol - 2 >= Board.MINIMUM_COLUMN_VALUE) {
                newPos.setCol(currCol - 2);
                allowedPositions.add(newPos.toString());
            }
            if(currCol + 2 <= Board.MAXIMUM_COLUMN_VALUE) {
                newPos.setCol(currCol + 2);
                allowedPositions.add(newPos.toString());
            }
        }

        if(currRow + 2 <= Board.MAXIMUM_ROW_VALUE) {
            newPos.setRow(currRow + 2);
            if(currCol - 1 >= Board.MINIMUM_COLUMN_VALUE) {
                newPos.setCol(currCol - 1);
                allowedPositions.add(newPos.toString());
            }
            if(currCol + 1 <= Board.MAXIMUM_COLUMN_VALUE) {
                newPos.setCol(currCol + 1);
                allowedPositions.add(newPos.toString());
            }
        }

        if(currRow + 1 <= Board.MAXIMUM_ROW_VALUE) {
            newPos.setRow(currRow + 1);
            if(currCol - 2 >= Board.MINIMUM_COLUMN_VALUE) {
                newPos.setCol(currCol - 2);
                allowedPositions.add(newPos.toString());
            }
            if(currCol + 2 <= Board.MAXIMUM_COLUMN_VALUE) {
                newPos.setCol(currCol + 2);
                allowedPositions.add(newPos.toString());
            }
        }

        return allowedPositions;
    }
}
