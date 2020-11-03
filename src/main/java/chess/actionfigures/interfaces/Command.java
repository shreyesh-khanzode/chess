package chess.actionfigures.interfaces;

import java.util.List;

public interface Command {
    List<String> move();
    default void attack() {/* no op*/}
}
