package org.example;

import java.util.Scanner;

public class App {

    final static private Repository repository = new UserRepository();
    final static private Game game = new Game();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Для старта игры нажмите \"Enter\"");
        scanner.nextLine();
        System.out.print("Напишите имя первого игрока: ");
        String nameFirstUser = scanner.nextLine();
        repository.addUserToList(nameFirstUser, SymbolType.X);
        System.out.print("Напишите имя второго игрока: ");
        String nameSecondUser = scanner.nextLine();
        repository.addUserToList(nameSecondUser, SymbolType.O);

        while (true) {
            System.out.println("Выберите дальнейшие действия: ");
            System.out.println("LIST -> Посмотреть список игроков");
            System.out.println("PLAY -> Играть");
            System.out.println("BREAK -> Выход из игры");
            String command = scanner.nextLine();
            if (command.equals(Constants.EXIT_FROM_GAME)) {
                break;
            }
            if (command.equals(Constants.SHOW_LIST_OF_USERS)) {
                repository.showAllUsers();
            }
            if (command.equals(Constants.PLAY_GAME)) {
                User user = game.playGame(scanner, repository.getUsers());
                System.out.println();
                System.out.println("ПОЗДРАВЛЯЕМ!!!! Победитель: Игрок №" + user.getId() +
                        " с именем " + user.getName() + " который играл символом" + user.getSymbol());
                System.out.println();
            }
        }
    }
}
