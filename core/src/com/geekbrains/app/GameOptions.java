package com.geekbrains.app;

public class GameOptions {
    //вывод окна приложения, указываем габариты окна
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    //количество звёзд
    public static final int STARS_COUNT = 800;

    //включить/выключить на весь экран
    //Esc - выход из игры
    public static final boolean FULL_SCREEN = false;

    //звёздам реагировать на пользователя
    public static final boolean STAR_JOIN_HERO = true;

    //скорость полёта корабля
    public static final float SPEED_HERO = 1000.0f;

    //величина межзвёздного пространства по краям игровой области
    public static final float COEFFSTARSSPACE = 400.0f;

}
