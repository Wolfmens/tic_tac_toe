package org.application;

import java.util.Arrays;

public interface Constants {

    int COUNT_USERS = 2;
    SymbolType[] VAR_SYMBOL_GAME = {SymbolType.O,SymbolType.X};
//    -- Menu game --
    String START = "Для старта игры нажмите \"Enter\"";
    String[] DISPLAY_USER_WHICH_ADDING = {"Напишите имя первого игрока (только буквы): "
                                        , "Напишите имя второго игрока (только буквы): "};
    String HELP_IN_GAME = "Если вы хотите выйти задайте BREAK\n" +
            "Если же хотите обратно в меню задайте MENU\n" +
            "Если же хотите переиграть, задайте REPLAY";
//    -- Answers user --
    String EXIT_FROM_GAME = "BREAK";
    String SHOW_LIST_OF_USERS = "LIST";
    String PLAY_GAME = "PLAY";
    String REPLAY = "REPLAY";
    String MENU = "MENU";
    String[] VAR_ANSWERS = {EXIT_FROM_GAME,REPLAY,MENU,"1","2","3","4","5","6","7","8","9"};
//    -- Check verification of entered data
    String REGEX_CHECK_NAME_USER_BY_RIGHT = "[A-Za-zА-Яа-я]*";
    String DISPLAY_INCORRECT_NAME_MASSAGE = "Внимание, некорректно введенное имя, игрок не добавлен !!!\n";
//    -- Answers server --
    String EXIT = "0";
    String PLAY_AGAIN = "1";
    String RETURN_TO_MENU = "2";
    String WIN_IN_GAME = "3";
    String GAME_CONTINUE = "4";
    String DRAW_IN_THE_GAME = "5";

    static boolean hasVar (String var) {
        return Arrays.asList(VAR_ANSWERS).contains(var);
    }
}
