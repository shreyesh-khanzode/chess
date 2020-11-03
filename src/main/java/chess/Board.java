package chess;

import javafx.geometry.Pos;

import java.util.stream.IntStream;

public class Board {
    public static final int ROW_LENGTH = 8, COLUMN_LENGTH = 8;
    public static final int MINIMUM_ROW_VALUE = 65, MINIMUM_COLUMN_VALUE = 1, MAXIMUM_ROW_VALUE = 72, MAXIMUM_COLUMN_VALUE = 8;
    private Position[][] area;

    public Board() {
        area = new Position[ROW_LENGTH][COLUMN_LENGTH];
        init();
    }

    private void init() {
        int rowVal = 65;
        for(int i = 0; i < ROW_LENGTH; i++) {
            for(int j = 0; j < COLUMN_LENGTH; j++) {
                area[i][j] = new Position((char)rowVal,j+1);// ((char)rowVal) + "" + (j+1);
            }
            rowVal++;
        }
    }

    public void print() {
        IntStream.range(0, ROW_LENGTH).forEach(
                row -> IntStream.range(0, COLUMN_LENGTH).forEach(
                        col -> System.out.println(area[row][col])
                )
        );
    }
}
