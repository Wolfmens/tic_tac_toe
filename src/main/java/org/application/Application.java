package org.application;

import java.util.Scanner;

public class Application {

    final private Repository repository = new UserRepository();
    final private Game game = new Game();
    final Scanner scanner = new Scanner(System.in);

    public void start () {
        System.out.print(Constants.START);
        scanner.nextLine();
        createUsers();

        while (true) {
            System.out.println("Выберите дальнейшие действия: ");
            System.out.println(Constants.SHOW_LIST_OF_USERS + " -> Посмотреть список игроков");
            System.out.println(Constants.PLAY_GAME + " -> Играть");
            System.out.println(Constants.EXIT_FROM_GAME + " -> Выход из игры");
            String command = scanner.nextLine();
            if (command.equals(Constants.EXIT_FROM_GAME)) {
                break;
            }
            if (command.equals(Constants.SHOW_LIST_OF_USERS)) {
                repository.showAllUsers();
            }
            if (command.equals(Constants.PLAY_GAME)) {
                if (!game.playGame(scanner, repository.getUsers())) {
                    break;
                }
            }
        }
    }

    private void createUsers() {
        int count = 1;

        while (count <= Constants.COUNT_USERS) {
            System.out.println(Constants.DISPLAY_USER_WHICH_ADDING[count - 1]);
            String nameUser = scanner.nextLine();
            if (addingUser(nameUser, Constants.VAR_SYMBOL_GAME[count - 1])){
                ++count;
            } else {
                System.out.println(Constants.DISPLAY_INCORRECT_NAME_MASSAGE);
            }
        }
//        String nameFirstUser = scanner.nextLine();
//        repository.addUserToList(nameFirstUser, SymbolType.X);
//        System.out.print(Constants.WRITE_SECOND_USER);
//        String nameSecondUser = scanner.nextLine();
//        repository.addUserToList(nameSecondUser, SymbolType.O);
    }

    private boolean addingUser(String nameUser, SymbolType type) {
        if (nameHasOnlyLetters(nameUser)) {
            repository.addUserToList(nameUser, type);
            return true;
        } else {
            return false;
        }
    }

    private boolean nameHasOnlyLetters(String nameUser) {
        return nameUser.matches(Constants.REGEX_CHECK_NAMEUSER_BY_RIGHT);
    }


}
