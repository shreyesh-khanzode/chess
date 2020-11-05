package client;

import chess.Position;
import chess.actionfigures.ActionFigureEnum;
import chess.actionfigures.ActionFigureFactory;
import chess.actionfigures.BaseActionFigure;
import chess.actionfigures.exceptions.InvalidActionFigureTypeException;
import chess.actionfigures.exceptions.InvalidPositionException;

import java.util.List;

public class ChessClient {
    public static void main(String[] args) {
        String actionFigure = args[0];
        String position = args[1];
        ActionFigureEnum actionFigureType = ActionFigureEnum.getActionFigureType(actionFigure).get();
        if(actionFigureType == null) {
            System.out.println("Invalid type :" + actionFigure);
            return;
        }
        try {
            BaseActionFigure baseActionFigure = ActionFigureFactory.getInstance(actionFigureType);
            assert baseActionFigure != null;
            baseActionFigure.setCurrentPosition(new Position(position.charAt(0), Integer.parseInt(""+position.charAt(1))));
            List<String> moves = baseActionFigure.move();
            StringBuilder sb = new StringBuilder();
            moves.forEach(entry -> sb.append(entry).append(","));
            System.out.println(sb.substring(0, sb.length() - 1));
        } catch (InvalidActionFigureTypeException | InvalidPositionException e) {
            e.printStackTrace();
        }
    }
}
