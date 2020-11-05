package chess.actionfigures;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public enum ActionFigureEnum {
    KING("king"),
    QUEEN("queen"),
    BISHOP("bishop"),
    HORSE("horse"),
    ROOK("rook"),
    PAWN("pawn");

    private String instance;

    private ActionFigureEnum(String type){
        this.instance = type;
    }

    public static Supplier<ActionFigureEnum> getActionFigureType(String type) {
        return () -> {
            try {
                return Arrays.stream(ActionFigureEnum.values())
                        .filter(value -> value.instance.equalsIgnoreCase(type))
                        .findFirst()
                        .orElse(null);
            }
            catch (IllegalArgumentException ignored) {
                //no op
            }
            return null;
        };
    }
}
