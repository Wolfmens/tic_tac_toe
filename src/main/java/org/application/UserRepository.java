package org.application;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository {

    private List<User> userList = new ArrayList<>();
    private int count = 0;

    @Override
    public void addUserToList (String name, SymbolType symbol) {
        int id = ++count;
        User user = new User(id,name,symbol);
        userList.add(user);
        System.out.println("Игрок №" + user.getId() + " по имени " + name + " зарегистрирован." +
                "Играет символом " + symbol);
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
}
