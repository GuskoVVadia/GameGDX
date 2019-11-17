package com.geekbrains;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;
    //переменная speed создана для минимизации дублирования кода и просчёта скорости в одном месте.
    private int speed;

    public Asteroid(){
        this.texture = new Texture("Asteroid.png");
        this.position = new Vector2(MathUtils.random(0, ScreenManager.SCREEN_WIDTH),
                MathUtils.random(0, ScreenManager.SCREEN_HEIGHT));
        this.speed = MathUtils.random(10, 100);
        this.velocity = new Vector2(speed, speed);
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x , position.y);
    }

    public void update(float dt){
        position.x += velocity.x * dt;
        position.y += velocity.y * dt;

        if (position.x > ScreenManager.SCREEN_WIDTH + texture.getWidth()){
            position.x = 0 - texture.getWidth();
            recountSpeed();
        }
        if (position.y > ScreenManager.SCREEN_HEIGHT + texture.getHeight()){
            position.y = 0 - texture.getHeight();
            recountSpeed();
        }

        if (position.x < (- 20 - texture.getWidth())){
            position.x = ScreenManager.SCREEN_WIDTH + texture.getWidth();
            recountSpeed();
        }
        if (position.y < (- 20 - texture.getHeight())){
            position.y = ScreenManager.SCREEN_HEIGHT + texture.getHeight();
            recountSpeed();
        }

    }

    private void recountSpeed(){
        speed = MathUtils.random(10, 500);
        velocity.set(speed, speed);
    }
}
