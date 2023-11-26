package org.application;

import java.util.List;

public interface Repository {

    boolean addUserToList (String name, SymbolType symbol);
    void showAllUsers();
    List<User> getUsers();
}
