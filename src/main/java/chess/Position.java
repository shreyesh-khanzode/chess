package chess;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Position {
    char row;
    int col;

    public Position(char row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position(Position other) {
        this.row = other.getRow();
        this.col = other.getCol();
    }

    public void setRow(int row) {
        this.row = (char)row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char getRow() {return row;}

    public int getCol() {return col;}

    public boolean isInvalid() {
        return (int)row < 65 || col < 1 || (int)row > 72 || col > 8;
    }

    @Override
    public String toString() {
        return new String(row +""+ col);
    }
}
