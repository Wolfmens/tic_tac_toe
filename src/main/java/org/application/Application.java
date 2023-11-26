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
        int countNumber = 1;
        while (countNumber <= Constants.COUNT_USERS) {
            System.out.println(Constants.DISPLAY_USER_WHICH_ADDING[countNumber - 1]);
            String nameUser = scanner.nextLine().strip();
            if (repository.addUserToList(nameUser, Constants.VAR_SYMBOL_GAME[countNumber - 1])){
                ++countNumber;
            } else {
                System.out.println(Constants.DISPLAY_INCORRECT_NAME_MASSAGE);
            }
        }
    }
}
