package org.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseByBoardTest {

    private final DataBaseByBoard dataBaseByBoard = new DataBaseByBoard();

    @Test
    @DisplayName("Заполнение доски")
    void fillingTheBoard() {
        dataBaseByBoard.fillingTheBoard();
        String[][] board = dataBaseByBoard.getBoard();

        boolean answer = false;

        for (String[] strings : board) {
            for (int j = 0; j < strings.length; j++) {
                if (!Character.isDigit(strings[j].charAt(0))) {
                    answer = true;
                }
            }
        }
        assertFalse(answer);
    }
}