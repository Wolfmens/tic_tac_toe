package org.example;

import java.util.List;

public interface Repository {

    void addUserToList (String name, SymbolType symbol);
    void showAllUsers();
    List<User> getUsers();
}
