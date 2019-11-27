package com.geekbrains.app.game.bonus;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.geekbrains.app.GameOptions;
import com.geekbrains.app.game.controllers.GameController;
import com.geekbrains.app.screen.utils.Assets;

public class GunsBonus extends AbstractBonus{
    public GunsBonus(GameController gc) {
        this.position = new Vector2(0, 0);
        this.texture = Assets.getInstance().getAtlas().findRegion("guns");
        this.bonusArea = new Circle(position, 24);
        this.nameBonus = "guns";
        this.active = false;
        this.gc = gc;
        this.bonus = GameOptions.BONUS_VALUE;
    }

    @Override
    void getBonus() {
        gc.getHero().getCurrentWeapon().setMaxBullets(bonus);
    }
}
