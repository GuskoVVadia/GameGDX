package com.geekbrains;

public class ScreenManager {
    //вывод окна приложения, указываем габариты окна
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    //количество звёзд
    public static final int STARS_COUNT = SCREEN_WIDTH / 2;

    //включить/выключить на весь экран
    //Esc - выход из игры
    public static final boolean FULL_SCREEN = false;

    //звёздам реагировать на пользователя
    public static final boolean STAR_JOIN_HERO = true;
}
