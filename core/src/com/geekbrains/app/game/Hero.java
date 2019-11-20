package com.geekbrains.app.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.geekbrains.app.GameOptions;

public class Hero extends SpaceObject {
    private float angle;

    public Hero(GameController gc){
        super(gc, new Texture("ship.png"),
                new Vector2(GameOptions.SCREEN_WIDTH / 2, GameOptions.SCREEN_HEIGHT / 2),
                new Vector2(0, 0));
        this.angle = 0.0f;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x - 32, position.y - 32, 32, 32, 64, 64,
                1, 1, angle, 0, 0, 64, 64, false, false);
    }

    public void update(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            angle += 180.0f * dt;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            angle -= 180.0f * dt;
        }
        //добавляем движение назад при нажатии S
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            velocity.x -= (float) Math.cos(Math.toRadians(angle)) * (GameOptions.SPEED_HERO / 2) * dt;
            velocity.y -= (float) Math.sin(Math.toRadians(angle)) * (GameOptions.SPEED_HERO / 2) * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            velocity.x += (float) Math.cos(Math.toRadians(angle)) * GameOptions.SPEED_HERO * dt;
            velocity.y += (float) Math.sin(Math.toRadians(angle)) * GameOptions.SPEED_HERO * dt;
        }

        position.mulAdd(velocity, dt);
        float stopKoef = 1.0f - 2.0f * dt;
        if (stopKoef < 0.0f){
            stopKoef = 0.0f;
        }
        velocity.scl(stopKoef);

        if (position.x < 0.0f){
            position.x = 0.0f;
            velocity.x *= -1;
        }
        if (position.x > GameOptions.SCREEN_WIDTH){
            position.x = GameOptions.SCREEN_WIDTH;
            velocity.x *= -1;
        }
        if (position.y < 0.0f){
            position.y = 0.0f;
            velocity.y *= -1;
        }
        if (position.y > GameOptions.SCREEN_HEIGHT){
            position.y = GameOptions.SCREEN_HEIGHT;
            velocity.y *= -1;
        }
    }
}
