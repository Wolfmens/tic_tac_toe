package org.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class User {

    final private int id;
    final private String name;
    final private SymbolType symbol;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && symbol == user.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, symbol);
    }
}
