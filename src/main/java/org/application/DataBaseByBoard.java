package org.application;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
public class DataBaseByBoard {


    private String[][] board;
    private int count = 0;
    private HashMap<String, Integer[]> mapOfNumberСellsToPositionInArray;

    public DataBaseByBoard() {
        board = new String[3][3];
        mapOfNumberСellsToPositionInArray = new HashMap<>();
    }

    public void fillingTheBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ++count;
                board[i][j] = String.valueOf(count);
                mapOfNumberСellsToPositionInArray.put(String.valueOf(count), new Integer[]{i, j});
            }
        }
    }

    public boolean isAllCellsOccupied() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (Character.isDigit(board[i][j].charAt(0))) {
                    return false;
                }
            }
        }
        return true;
    }

}
