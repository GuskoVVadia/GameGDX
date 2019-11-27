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

    //скорость полёта корабля
    public static final float SPEED_HERO = 1000.0f;

    //hp астероида привязана к его величине
    public static final int HP_ASTEROID = 10;

    //определяем количество астероидов.
    public static final int COUNT_ASTEROIDS = 2;

    //количество очков жизни корабля
    public static final int HP_HERO = 100;

    //количество бонусов
    public static final int BONUS_VALUE = 100;

}
