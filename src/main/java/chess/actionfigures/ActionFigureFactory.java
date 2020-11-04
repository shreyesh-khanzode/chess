package chess.actionfigures;

import chess.actionfigures.exceptions.InvalidActionFigureTypeException;
import chess.actionfigures.impls.Bishop;
import chess.actionfigures.impls.Horse;
import chess.actionfigures.impls.King;
import chess.actionfigures.impls.Queen;

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
            case PAWN:
                return null;
            default:
                throw new InvalidActionFigureTypeException();
        }
    }
}
