package org.application;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository {

    private List<User> userList = new ArrayList<>();
    private int count = 0;

    @Override
    public boolean addUserToList (String name, SymbolType symbol) {
        if (hasNotUserInList(name)) {
            System.out.println("Это имя уже занято!");
            return false;
        }
        if (nameHasOnlyLetters(name)) {
            int id = ++count;
            User user = new User(id, name, symbol);
            userList.add(user);
            System.out.println("Игрок №" + user.getId() + " по имени " + name + " зарегистрирован." +
                    "Играет символом " + symbol);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void showAllUsers() {
        System.out.println("Зарегистрированы следующие игроки: ");
        userList.forEach(u ->
                System.out.println("№ " + u.getId() + " -> " + u.getName() + ", который играет " + u.getSymbol()));
        System.out.println();
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userList);
    }

    private boolean nameHasOnlyLetters(String nameUser) {
        return nameUser.matches(Constants.REGEX_CHECK_NAME_USER_BY_RIGHT);
    }

    private boolean hasNotUserInList(String name) {
       return userList.stream().anyMatch(u -> u.getName().toLowerCase().equals(name.toLowerCase()));
    }
}
