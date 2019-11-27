package com.geekbrains.app.game.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.geekbrains.app.game.bonus.AbstractBonus;
import com.geekbrains.app.game.bonus.ChestBonus;
import com.geekbrains.app.game.bonus.GunsBonus;
import com.geekbrains.app.game.bonus.MoneyBonus;

import java.util.ArrayList;
import java.util.List;

public class BonusController {
    private List<AbstractBonus> bonusList = new ArrayList<>();
    private MoneyBonus money;
    private ChestBonus chest;
    private GunsBonus guns;
    private int localValue;

    BonusController(GameController gc){
        bonusList.add(new MoneyBonus(gc));
        bonusList.add(new ChestBonus(gc));
        bonusList.add(new GunsBonus(gc));
        this.localValue = 0;
    }

    public void getChance(Vector2 positionAsteroid){
        localValue = MathUtils.random(3);
        bonusList.get(localValue).getActiveChance(positionAsteroid);
    }

    public void render(SpriteBatch batch){
        for (int i = 0; i < bonusList.size(); i++) {
            bonusList.get(i).render(batch);
        }
    }
    public void update(float dt){
        for (int i = 0; i < bonusList.size(); i++) {
            bonusList.get(i).update(dt);
        }
    }
}
