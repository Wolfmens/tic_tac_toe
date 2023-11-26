package org.application;

import java.util.*;

public class Game {

    private final DataBaseByBoard dataBaseByBoard = new DataBaseByBoard();

    public boolean playGame(Scanner scanner, List<User> userList) {
        dataBaseByBoard.fillingTheBoard();
        showBoard();

        while (true) {
            for (User user : userList) {
                String answer = usersStepAnswer(user, scanner);
                if (answer.equals(Constants.WIN_IN_GAME)) {
                    System.out.println();
                    System.out.println("ПОЗДРАВЛЯЕМ!!!! Победитель: Игрок №" + user.getId() +
                            " с именем " + user.getName() + " который играл символом " + user.getSymbol());
                    System.out.println();
                    dataBaseByBoard.setCount(0);
                    return true;
                }
                if (answer.equals(Constants.PLAY_AGAIN)) {
                    dataBaseByBoard.setCount(0);
                    return playGame(scanner, userList);
                }
                if (answer.equals(Constants.RETURN_TO_MENU)) {
                    dataBaseByBoard.setCount(0);
                    return true;
                }
                if (answer.equals(Constants.EXIT)) {
                    return false;
                }
                if (answer.equals(Constants.DRAW_IN_THE_GAME)) {
                    dataBaseByBoard.setCount(0);
                    System.out.println("\nВсе ячейки заполнены, НИЧЬЯ!!\n");
                    return true;
                }
            }
        }
    }

    private void showBoard() {
        for (String[] strings : dataBaseByBoard.getBoard()) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j]);
                System.out.print(j < 2 ? " " : "\n");
            }
        }
    }

    private String usersStepAnswer(User user, Scanner scanner) {
        if (dataBaseByBoard.isAllCellsOccupied()) {
            return Constants.DRAW_IN_THE_GAME;
        }
        System.out.println(Constants.HELP_IN_GAME);
        System.out.println("Ходит игрок №" + user.getId());
        System.out.print("Задайте пожалуйста номер клетки или команду: ");
        String numberUserOrCommand = getResultStep(scanner).strip();
        if (numberUserOrCommand.equals(Constants.EXIT_FROM_GAME)) {
            return Constants.EXIT;
        }
        if (numberUserOrCommand.equals(Constants.REPLAY)) {
            return Constants.PLAY_AGAIN;
        }
        if (numberUserOrCommand.equals(Constants.MENU)) {
            return Constants.RETURN_TO_MENU;
        }
        int X = dataBaseByBoard.getMapOfNumberСellsToPositionInArray().get(numberUserOrCommand)[0];
        int Y = dataBaseByBoard.getMapOfNumberСellsToPositionInArray().get(numberUserOrCommand)[1];
        if (!Character.isDigit(dataBaseByBoard.getBoard()[X][Y].charAt(0))) {
            System.out.println("\nДанная ячейка уже выбрана, выберете другую ячейку или команду\n");
            showBoard();
            return usersStepAnswer(user, scanner);
        }
        String symbol = user.getSymbol().toString();
        dataBaseByBoard.getBoard()[X][Y] = symbol;
        showBoard();
        if (checkForVictory(numberUserOrCommand, symbol)) {
            return Constants.WIN_IN_GAME;
        }
        return Constants.GAME_CONTINUE;
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
        int number = Integer.parseInt(numberUser);
        if (number % 2 == 0) {
            return isWinIfEvenNumber(numberUser, symbol);
        } else {
            return isWinIfOddNumber(numberUser, symbol);
        }
    }

    private boolean isWinIfOddNumber(String numberUser, String symbol) {
        switch (numberUser) {
            case "1" -> {
                if (dataBaseByBoard.getBoard()[0][1].equals(symbol) && dataBaseByBoard.getBoard()[0][2].equals(symbol) ||
                        dataBaseByBoard.getBoard()[1][0].equals(symbol) && dataBaseByBoard.getBoard()[2][0].equals(symbol) ||
                        dataBaseByBoard.getBoard()[1][1].equals(symbol) && dataBaseByBoard.getBoard()[2][2].equals(symbol)) {
                    return true;
                }
            }
            case "3" -> {
                if (dataBaseByBoard.getBoard()[0][0].equals(symbol) && dataBaseByBoard.getBoard()[0][1].equals(symbol) ||
                        dataBaseByBoard.getBoard()[1][2].equals(symbol) && dataBaseByBoard.getBoard()[2][2].equals(symbol) ||
                        dataBaseByBoard.getBoard()[1][1].equals(symbol) && dataBaseByBoard.getBoard()[2][0].equals(symbol)) {
                    return true;
                }
            }
            case "7" -> {
                if (dataBaseByBoard.getBoard()[1][0].equals(symbol) && dataBaseByBoard.getBoard()[0][0].equals(symbol) ||
                        dataBaseByBoard.getBoard()[2][1].equals(symbol) && dataBaseByBoard.getBoard()[2][2].equals(symbol) ||
                        dataBaseByBoard.getBoard()[1][1].equals(symbol) && dataBaseByBoard.getBoard()[0][2].equals(symbol)) {
                    return true;
                }
            }
            case "9" -> {
                if (dataBaseByBoard.getBoard()[1][2].equals(symbol) && dataBaseByBoard.getBoard()[0][2].equals(symbol) ||
                        dataBaseByBoard.getBoard()[2][1].equals(symbol) && dataBaseByBoard.getBoard()[2][0].equals(symbol) ||
                        dataBaseByBoard.getBoard()[1][1].equals(symbol) && dataBaseByBoard.getBoard()[0][0].equals(symbol)) {
                    return true;
                }
            }
            case "5" -> {
                if (dataBaseByBoard.getBoard()[1][0].equals(symbol) && dataBaseByBoard.getBoard()[1][2].equals(symbol) ||
                        dataBaseByBoard.getBoard()[0][1].equals(symbol) && dataBaseByBoard.getBoard()[2][1].equals(symbol) ||
                        dataBaseByBoard.getBoard()[2][2].equals(symbol) && dataBaseByBoard.getBoard()[0][0].equals(symbol) ||
                        dataBaseByBoard.getBoard()[2][0].equals(symbol) && dataBaseByBoard.getBoard()[0][2].equals(symbol)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinIfEvenNumber(String numberUser, String symbol) {
        switch (numberUser) {
            case "2" -> {
                if (dataBaseByBoard.getBoard()[0][0].equals(symbol) && dataBaseByBoard.getBoard()[0][2].equals(symbol) ||
                        dataBaseByBoard.getBoard()[1][1].equals(symbol) && dataBaseByBoard.getBoard()[2][1].equals(symbol)) {
                    return true;
                }
            }
            case "4" -> {
                if (dataBaseByBoard.getBoard()[0][0].equals(symbol) && dataBaseByBoard.getBoard()[2][0].equals(symbol) ||
                        dataBaseByBoard.getBoard()[1][1].equals(symbol) && dataBaseByBoard.getBoard()[1][2].equals(symbol)) {
                    return true;
                }
            }
            case "8" -> {
                if (dataBaseByBoard.getBoard()[2][0].equals(symbol) && dataBaseByBoard.getBoard()[2][2].equals(symbol) ||
                        dataBaseByBoard.getBoard()[1][1].equals(symbol) && dataBaseByBoard.getBoard()[0][1].equals(symbol)) {
                    return true;
                }
            }
            case "6" -> {
                if (dataBaseByBoard.getBoard()[0][2].equals(symbol) && dataBaseByBoard.getBoard()[2][2].equals(symbol) ||
                        dataBaseByBoard.getBoard()[1][1].equals(symbol) && dataBaseByBoard.getBoard()[1][0].equals(symbol)) {
                    return true;
                }
            }
        }
        return false;
    }
}
