package chess.actionfigures.impls;

import chess.Board;
import chess.Position;
import chess.actionfigures.AllowedMovementsEnum;
import chess.actionfigures.BaseActionFigure;
import chess.actionfigures.exceptions.InvalidPositionException;

import java.util.ArrayList;
import java.util.List;

import static chess.actionfigures.AllowedMovementsEnum.ALL;

public class Queen extends BaseActionFigure {

    public Queen() {
        super(new AllowedMovementsEnum[] {ALL});
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
        //current row
        for(int i = currRow - 1; i >= Board.MINIMUM_ROW_VALUE && i != (int)currentPosition.getRow(); i--) {
            newPos.setRow((char)i);
            allowedPositions.add(newPos.toString());
        }
        for(int i = currRow + 1; i <= Board.MAXIMUM_ROW_VALUE ; i++) {
            newPos.setRow((char)i);
            allowedPositions.add(newPos.toString());
        }

        //current column
        newPos.setRow(currRow);
        for(int i = currCol - 1; i >= Board.MINIMUM_COLUMN_VALUE; i--) {
            newPos.setCol(i);
            allowedPositions.add(newPos.toString());
        }
        for(int i = currCol + 1; i <= Board.MAXIMUM_COLUMN_VALUE; i++) {
            newPos.setCol(i);
            allowedPositions.add(newPos.toString());
        }

        // left-right diagonal
        for(int i = currRow - 1, j = currCol - 1; i >= Board.MINIMUM_ROW_VALUE && j >= Board.MINIMUM_COLUMN_VALUE ;
        i--, j--) {
            newPos.setRow(i);
            newPos.setCol(j);
            allowedPositions.add(newPos.toString());
        }
        for(int i = currRow + 1, j = currCol + 1; i <= Board.MAXIMUM_ROW_VALUE && j <= Board.MAXIMUM_COLUMN_VALUE ;
            i++, j++) {
            newPos.setRow(i);
            newPos.setCol(j);
            allowedPositions.add(newPos.toString());
        }

        // right-left diagonal
        for(int i = currRow - 1, j = currCol + 1; i >= Board.MINIMUM_ROW_VALUE && j <= Board.MAXIMUM_COLUMN_VALUE ;
            i--, j++) {
            newPos.setRow(i);
            newPos.setCol(j);
            allowedPositions.add(newPos.toString());
        }
        for(int i = currRow + 1, j = currCol - 1; i <= Board.MAXIMUM_ROW_VALUE && j >= Board.MINIMUM_COLUMN_VALUE ;
            i++, j--) {
            newPos.setRow(i);
            newPos.setCol(j);
            allowedPositions.add(newPos.toString());
        }

        return allowedPositions;
    }
}
