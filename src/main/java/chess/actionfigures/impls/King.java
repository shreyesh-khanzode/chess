package chess.actionfigures.impls;

import chess.Board;
import chess.Position;
import chess.actionfigures.AllowedMovementsEnum;
import chess.actionfigures.BaseActionFigure;
import chess.actionfigures.exceptions.InvalidPositionException;
import chess.actionfigures.interfaces.Command;

import java.util.List;

import static chess.actionfigures.AllowedMovementsEnum.ALL;

public class King extends BaseActionFigure {

    public King() {
        super(new AllowedMovementsEnum[] {ALL});
    }

    @Override
    public List<String> move() throws InvalidPositionException {
        allowedPositions.clear();
        Position currentPosition = getCurrentPosition();
        if(currentPosition.isInvalid()) {
            throw new InvalidPositionException(getCurrentPosition());
        }

        // Do for the current row
        int currRow = (int) currentPosition.getRow();
        int currCol = currentPosition.getCol();
        Position newPos = new Position((char)currRow, currCol);
        if(currCol + 1 <= Board.MAXIMUM_COLUMN_VALUE) {
            newPos.setCol(currCol + 1);
            allowedPositions.add(newPos.toString());
        }

        if(currCol - 1 >= Board.MINIMUM_COLUMN_VALUE) {
            newPos.setCol(currCol - 1);
            allowedPositions.add(newPos.toString());
        }

        // Do for upper row
//        newPos = new Position(currentPosition);
        if(currCol - 1 >= Board.MINIMUM_COLUMN_VALUE
            && currRow - 1 >= Board.MINIMUM_ROW_VALUE) {
            newPos.setRow(currRow - 1);
            newPos.setCol(currCol - 1);
            allowedPositions.add(newPos.toString());
        }

        if(currRow - 1 >= Board.MINIMUM_ROW_VALUE) {
            newPos.setRow(currRow - 1);
            newPos.setCol(currCol);
            allowedPositions.add(newPos.toString());
        }

        if(currCol + 1 <= Board.MAXIMUM_COLUMN_VALUE
        && currRow - 1 >= Board.MINIMUM_ROW_VALUE) {
            newPos.setRow(currRow - 1);
            newPos.setCol(currCol + 1);
            allowedPositions.add(newPos.toString());
        }

        // Do for bottom row
//        newPos = new Position(currentPosition);
        if(currCol - 1 >= Board.MINIMUM_COLUMN_VALUE
        && currRow + 1 <= Board.MAXIMUM_ROW_VALUE) {
            newPos.setRow(currRow + 1);
            newPos.setCol(currCol - 1);
            allowedPositions.add(newPos.toString());
        }

        if(currRow + 1 <= Board.MAXIMUM_ROW_VALUE){
            newPos.setRow(currRow + 1);
            newPos.setCol(currCol);
            allowedPositions.add(newPos.toString());
        }

        if(currCol + 1 <= Board.MAXIMUM_COLUMN_VALUE
        && currRow + 1 <= Board.MAXIMUM_ROW_VALUE) {
            newPos.setRow(currRow + 1);
            newPos.setCol(currCol + 1);
            allowedPositions.add(newPos.toString());
        }

        return allowedPositions;
    }
}
