package chess.actionfigures;

import chess.Position;
import chess.actionfigures.exceptions.InvalidPositionException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static chess.actionfigures.AllowedMovementsEnum.ALL;

@Setter
@NoArgsConstructor
abstract public class BaseActionFigure {
    private AllowedMovementsEnum[] allowedMovements;
    private Position currentPosition;
    protected List<String> allowedPositions;

    public BaseActionFigure(AllowedMovementsEnum[] allowedMovements) {
        this.allowedMovements = allowedMovements;
        currentPosition = new Position((char)48, -1);
        allowedPositions = new ArrayList<String>();
    }

    protected Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position position) {
        currentPosition = position;
    }

    abstract public List<String> move() throws InvalidPositionException;

}
