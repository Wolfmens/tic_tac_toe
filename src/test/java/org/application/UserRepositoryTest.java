package org.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Проверка репозитория")
class UserRepositoryTest {

    private Repository repository = new UserRepository();

    @DisplayName("Проверка на добавление пользователя в базу")
    @Test
    void addUserToList() {
        User userOne = new User(0, "Oleg", SymbolType.O);
        User userTwo = new User(1, "Jack", SymbolType.X);
        ArrayList<User> userList = new ArrayList<>(List.of(userOne, userTwo));
        repository.addUserToList("Oleg", SymbolType.O);
        repository.addUserToList("Jack", SymbolType.X);
        int sizeUserListLocal = userList.size();
        int sizeUserListFromRepository = repository.getUsers().size();

        assertThat(sizeUserListLocal).isEqualTo(sizeUserListFromRepository);
    }

    @DisplayName("Проверка имени пользователя на некорректность")
    @ParameterizedTest
    @CsvSource({"1234", ".,!@#$%&*(){}", "Oleg123", "Malen!.,@#"})
    void checkUserNameByIncorrect(String parameter) {
        boolean actual = repository.addUserToList(parameter, SymbolType.O);
        assertFalse(actual);
    }

    @DisplayName("Проверка имени пользователя на корректность")
    @ParameterizedTest
    @CsvSource({"Олег", "Светлана", "Oleg", "Svetlana"})
    void checkUserNameByСorrect(String parameter) {
        boolean actual = repository.addUserToList(parameter, SymbolType.O);
        assertTrue(actual);
    }

    @DisplayName("Проверка пользователя на совпадение при добавлении")
    @Test
    void haveUserInList() {
        repository.addUserToList("Bob", SymbolType.X);
        boolean isAdded = repository.addUserToList("Bob",SymbolType.O);

        assertFalse(isAdded);
    }
}