package com.geekbrains.app.game.helpers;

import com.badlogic.gdx.math.Circle;

public interface Strike {

    public boolean isActive();
    public void deactivate();
    public Circle getHitArea();
}
