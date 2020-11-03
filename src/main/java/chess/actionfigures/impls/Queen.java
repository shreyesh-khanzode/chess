package chess.actionfigures.impls;

import chess.actionfigures.AllowedMovementsEnum;
import chess.actionfigures.BaseActionFigure;
import chess.actionfigures.exceptions.InvalidPositionException;

import java.util.List;

import static chess.actionfigures.AllowedMovementsEnum.ALL;

public class Queen extends BaseActionFigure {

    public Queen() {
        super(new AllowedMovementsEnum[] {ALL});
    }

    @Override
    public List<String> move() throws InvalidPositionException {
        return null;
    }
}
