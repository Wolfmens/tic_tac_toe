package org.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Проверка репозитория")
class UserRepositoryTest {

    @DisplayName("Проверка на добавление пользователя в базу")
    @Test
    void addUserToList() {
        Repository repository = new UserRepository();
        User userOne = new User(0,"Oleg",SymbolType.O);
        User userTwo = new User(1,"Jack",SymbolType.X);
        ArrayList<User> userList = new ArrayList<>(List.of(userOne,userTwo));
        repository.addUserToList("Oleg",SymbolType.O);
        repository.addUserToList("Jack",SymbolType.X);
        int sizeUserListLocal = userList.size();
        int sizeUserListFromRepository = repository.getUsers().size();

        assertThat(sizeUserListLocal).isEqualTo(sizeUserListFromRepository);
    }



}