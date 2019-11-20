package com.geekbrains.app.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.geekbrains.app.GameOptions;

public class Asteroid extends SpaceObject {
    private int speed;

    public Asteroid(GameController gc){
        super(gc, new Texture("Asteroid.png"),
                new Vector2(MathUtils.random(0, GameOptions.SCREEN_WIDTH), MathUtils.random(0, GameOptions.SCREEN_HEIGHT)),
                new Vector2(MathUtils.random(10, 100), MathUtils.random(10, 100)));
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x , position.y);
    }

    public void update(float dt){
        position.x += velocity.x * dt;
        position.y += velocity.y * dt;

        if (position.x > GameOptions.SCREEN_WIDTH + texture.getWidth()){
            position.x = 0 - texture.getWidth();
            recountSpeed();
        }
        if (position.y > GameOptions.SCREEN_HEIGHT + texture.getHeight()){
            position.y = 0 - texture.getHeight();
            recountSpeed();
        }

        if (position.x < (- 20 - texture.getWidth())){
            position.x = GameOptions.SCREEN_WIDTH + texture.getWidth();
            recountSpeed();
        }
        if (position.y < (- 20 - texture.getHeight())){
            position.y = GameOptions.SCREEN_HEIGHT + texture.getHeight();
            recountSpeed();
        }
    }

    private void recountSpeed(){
        speed = MathUtils.random(10, 11);
        velocity.set(speed, speed);
    }


}
