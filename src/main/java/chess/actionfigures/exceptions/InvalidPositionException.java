package chess.actionfigures.exceptions;

import chess.Position;

public class InvalidPositionException extends Exception {
    public InvalidPositionException(Position position) {
        super("Invalid Position given " + position.toString());
    }
}
