package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Type;

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
}
