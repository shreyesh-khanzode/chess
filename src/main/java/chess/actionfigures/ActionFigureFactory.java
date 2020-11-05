package chess.actionfigures;

import chess.actionfigures.exceptions.InvalidActionFigureTypeException;
import chess.actionfigures.impls.*;

public class ActionFigureFactory {
    public static BaseActionFigure getInstance(ActionFigureEnum intendedType) throws InvalidActionFigureTypeException {
        switch (intendedType) {
            case KING:
                return new King();
            case QUEEN:
                return new Queen();
            case BISHOP:
                return new Bishop();
            case HORSE:
                return new Horse();
            case ROOK:
                return new Rook();
            case PAWN:
                return new Pawn();
            default:
                throw new InvalidActionFigureTypeException();
        }
    }
}
