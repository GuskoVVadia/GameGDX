package com.geekbrains.app.game.bonus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.geekbrains.app.GameOptions;
import com.geekbrains.app.game.controllers.GameController;

public abstract class AbstractBonus {
    protected Vector2 position;
    protected Circle bonusArea;
    protected TextureRegion texture;
    protected int bonus;
    protected String nameBonus;
    protected boolean active;
    protected GameController gc;

    abstract void getBonus();

    public boolean isActive() {
        return active;
    }
    public void getActiveChance(Vector2 positionAsteroid){
        this.position = positionAsteroid;
        this.active = true;
    }

    public void deActive(){
        this.active = false;
    }

    public void render(SpriteBatch batch){
        if (active)
        batch.draw(texture, position.x - 24, position.y - 24, 24, 48);
    }

    public void update(float dt){
        if (active){
            position.y += 10 * dt;
            if (position.y > GameOptions.SCREEN_WIDTH) {
                deActive();
            }
            bonusArea.setPosition(position);
            if (bonusArea.overlaps(gc.getHero().getHitArea())){
                getBonus();
                deActive();
            }
        }
    }
}
