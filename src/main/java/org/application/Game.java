package org.application;

import java.util.*;

public class Game {

    private String[][] board = new String[3][3];
    private int count = 0;
    private HashMap<String, Integer[]> mapOfNumberСellsToPositionInArray = new HashMap<>();

    public boolean playGame(Scanner scanner, List<User> userList) {

        fillingTheBoard();
        showBoard();

        while (true) {
            for (User user : userList) {
                String answer = usersStep(user, scanner);
                if (answer.equals("3")) {
                    System.out.println();
                    System.out.println("ПОЗДРАВЛЯЕМ!!!! Победитель: Игрок №" + user.getId() +
                            " с именем " + user.getName() + " который играл символом " + user.getSymbol());
                    System.out.println();

                    return true;
                }
                if (answer.equals("1")) {
                    count = 0;
                    playGame(scanner, userList);
                }
                if (answer.equals("2")) {
                    count = 0;
                    return true;
                }
                if (answer.equals("0")) {
                    return false;
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
                mapOfNumberСellsToPositionInArray.put(String.valueOf(count), new Integer[]{i, j});
            }
        }
    }

    private String usersStep(User user, Scanner scanner) {
        System.out.println(Constants.HELP_IN_GAME);
        System.out.println("Ходит игрок №" + user.getId());
        System.out.print("Задайте пожалуйста номер клетки или команду: ");
        String numberUserOrCommand = getResultStep(scanner).strip();
        if (numberUserOrCommand.equals(Constants.EXIT_FROM_GAME)) {
            return "0";
        }
        if (numberUserOrCommand.equals(Constants.REPLAY)) {
            return "1";
        }
        if (numberUserOrCommand.equals(Constants.MENU)) {
            return "2";
        }
        int numberOne = mapOfNumberСellsToPositionInArray.get(numberUserOrCommand)[0];
        int numberTwo = mapOfNumberСellsToPositionInArray.get(numberUserOrCommand)[1];
        String symbol = user.getSymbol().toString();
        board[numberOne][numberTwo] = symbol;
        showBoard();
        if (checkForVictory(numberUserOrCommand, symbol)) {
            return "3";
        }
        return "4";
    }

    private String getResultStep(Scanner scanner) {
        String numberUserOrCommand = scanner.nextLine().strip();
        if (!Constants.hasVar(numberUserOrCommand)) {
            System.out.print("\nВыбрана несуществующая команда или номер клетки, повторите выбор: ");
            numberUserOrCommand = getResultStep(scanner);
        }
        return numberUserOrCommand;
    }

    private boolean checkForVictory(String numberUser, String symbol) {
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
            case "5" -> {
                if (board[1][0].equals(symbol) && board[1][2].equals(symbol) ||
                        board[0][1].equals(symbol) && board[2][1].equals(symbol) ||
                        board[2][2].equals(symbol) && board[0][0].equals(symbol) ||
                        board[2][0].equals(symbol) && board[0][2].equals(symbol)) {
                    return true;
                }
            }
        }
        return false;
    }
}
