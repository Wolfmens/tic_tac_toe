package org.application;

import java.util.Arrays;
import java.util.Scanner;

public interface Constants {

    int COUNT_USERS = 2;
    String START = "Для старта игры нажмите \"Enter\"";
    String[] DISPLAY_USER_WHICH_ADDING = {"Напишите имя первого игрока (только буквы): "
                                        , "Напишите имя второго игрока (только буквы): "};
    SymbolType[] VAR_SYMBOL_GAME = {SymbolType.O,SymbolType.X};
    String HELP_IN_GAME = "Если вы хотите выйти задайте BREAK\n" +
            "Если же хотите обратно в меню задайте MENU\n" +
            "Если же хотите переиграть, задайте REPLAY";
    String EXIT_FROM_GAME = "BREAK";
    String SHOW_LIST_OF_USERS = "LIST";
    String PLAY_GAME = "PLAY";
    String REPLAY = "REPLAY";
    String MENU = "MENU";
    String[] VAR_ANSWERS = {EXIT_FROM_GAME,REPLAY,MENU,"1","2","3","4","5","6","7","8","9","10"};
    String REGEX_CHECK_NAMEUSER_BY_RIGHT = "[A-Za-zА-Яа-я]*";
    String DISPLAY_INCORRECT_NAME_MASSAGE = "Внимание, некорректно введенное имя, игрок не добавлен !!!";

    static boolean hasVar (String var) {
        return Arrays.asList(VAR_ANSWERS).contains(var);
    }
}
