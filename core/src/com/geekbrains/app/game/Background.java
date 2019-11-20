package com.geekbrains.app.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.geekbrains.app.GameOptions;

public class Background {
    private class Star{
        private Vector2 position;
        private Vector2 velocity;
        private float scale;


        public Star(){
            this.position = new Vector2(MathUtils.random(-GameOptions.COEFFSTARSSPACE,
                    GameOptions.SCREEN_WIDTH  + GameOptions.COEFFSTARSSPACE),
                    MathUtils.random(-GameOptions.COEFFSTARSSPACE,
                            GameOptions.SCREEN_HEIGHT + GameOptions.COEFFSTARSSPACE));
            this.velocity = new Vector2(MathUtils.random(-40, -5), 0);
            this.scale = Math.abs(velocity.x) / 40.0f * 0.7f;
        }

        public void update(float dt){
            if (GameOptions.STAR_JOIN_HERO) {
                position.x += (velocity.x - gc.getHero().getVelocity().x) * dt;
                position.y += (velocity.y - gc.getHero().getVelocity().y) * dt;
            }else {
                position.x += velocity.x * dt;
                position.y += velocity.y * dt;
            }

            if (position.x < -GameOptions.COEFFSTARSSPACE){
                position.x = GameOptions.SCREEN_WIDTH + GameOptions.COEFFSTARSSPACE;
                position.y = MathUtils.random(-GameOptions.COEFFSTARSSPACE,
                        GameOptions.SCREEN_HEIGHT + GameOptions.COEFFSTARSSPACE);
                scale = Math.abs(velocity.x) / 40.0f * 0.7f;
            }
        }
    }

    private GameController gc;
    private Texture textureCosmos;
    private Texture textureStar;
    private Star[] stars;

    public Background(GameController gc) {
        this.gc = gc;
        this.textureCosmos = new Texture("bg.png");
        this.textureStar = new Texture("star16.png");
        this.stars = new Star[GameOptions.STARS_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch){
        batch.draw(textureCosmos, 0, 0);
        for (int i = 0; i < stars.length; i++) {
            float scl = 1.0f;
            batch.draw(textureStar, stars[i].position.x - 8, stars[i].position.y - 8,
                    8, 8, 16, 16, stars[i].scale, stars[i].scale, 0, 0, 0,
                    16, 16, false, false);
            if (MathUtils.random(0, 500) < 2){
                batch.draw(textureStar, stars[i].position.x - 8, stars[i].position.y - 8,
                        8, 8, 16, 16, stars[i].scale * 2, stars[i].scale * 2, 0, 0, 0,
                        16, 16, false, false);
            }
        }
    }

    public void update(float dt){
        for (int i = 0; i < stars.length; i++) {
            stars[i].update(dt);
        }
    }
}
