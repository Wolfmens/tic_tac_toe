package org.example;

import java.util.*;

public class Game {

    private String[][] board = new String[3][3];
    private int count = 0;
    private HashMap<String,Integer[]> map = new HashMap<>();

    public User playGame(Scanner scanner, List<User> userList) {

        fillingTheBoard();
        showBoard();

        while (true) {
            for (User user : userList) {
                if (usersStep(user,scanner)) {
                    return user;
                } else {
                    return null;
                }
            }
        }
    }

    private void showBoard() {
        for (String[] strings : board) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j]);
                System.out.print(j < 2 ? " " : "\n");
            }
        }
    }

    private void fillingTheBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ++count;
                board[i][j] = String.valueOf(count);
                map.put(String.valueOf(count),new Integer[]{i,j});
            }
        }
    }

    private boolean usersStep(User user, Scanner scanner) {
        System.out.println("Ходит игрок №" + user.getId());
        System.out.println("Задайте пожалуйста номер клетки:");
        String numberUser = scanner.nextLine().strip();
        int numberOne = map.get(numberUser)[0];
        int numberTwo = map.get(numberUser)[1];
        String symbol = user.getSymbol().toString();
        board[numberOne][numberTwo] = symbol;
        showBoard();

        return checkForVictory(numberUser, symbol);
    }

    private boolean checkForVictory (String numberUser, String symbol) {
            switch (numberUser) {
               case "2" -> {
                   if (board[0][0].equals(symbol) && board[0][2].equals(symbol) ||
                           board[1][1].equals(symbol) && board[2][1].equals(symbol)) {
                       return true;
                   }
                }
                case "4" -> {
                    if (board[0][0].equals(symbol) && board[2][0].equals(symbol) ||
                            board[1][1].equals(symbol) && board[1][2].equals(symbol)) {
                        return true;
                    }
                }
                case "8" -> {
                    if (board[2][0].equals(symbol) && board[2][2].equals(symbol) ||
                            board[1][1].equals(symbol) && board[0][1].equals(symbol)) {
                        return true;
                    }
                }
                case "6" -> {
                    if (board[0][2].equals(symbol) && board[2][2].equals(symbol) ||
                            board[1][1].equals(symbol) && board[1][0].equals(symbol)) {
                        return true;
                    }
                }
                case "1" -> {
                    if (board[0][1].equals(symbol) && board[0][2].equals(symbol) ||
                            board[1][0].equals(symbol) && board[2][0].equals(symbol) ||
                            board[1][1].equals(symbol) && board[2][2].equals(symbol)) {
                        return true;
                    }
                }
                case "3" -> {
                    if (board[0][0].equals(symbol) && board[0][1].equals(symbol) ||
                            board[1][2].equals(symbol) && board[2][2].equals(symbol) ||
                            board[1][1].equals(symbol) && board[2][0].equals(symbol)) {
                        return true;
                    }
                }
                case "7" -> {
                    if (board[1][0].equals(symbol) && board[0][0].equals(symbol) ||
                            board[2][1].equals(symbol) && board[2][2].equals(symbol) ||
                            board[1][1].equals(symbol) && board[0][2].equals(symbol)) {
                        return true;
                    }
                }
                case "9" -> {
                    if (board[1][2].equals(symbol) && board[0][2].equals(symbol) ||
                            board[2][1].equals(symbol) && board[2][0].equals(symbol) ||
                            board[1][1].equals(symbol) && board[0][0].equals(symbol)) {
                        return true;
                    }
                }
            }
        return false;
    }
}
