package com.geekbrains.app.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
    private GameController gc;
    private SpriteBatch batch;

    public WorldRenderer(GameController gc, SpriteBatch batch) {
        this.batch = batch;
        this.gc = gc;
    }

    public void render(){
        Gdx.gl.glClearColor(0, 0, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        gc.getBackground().render(batch);
        gc.getHero().render(batch);
        gc.getAsteroid().render(batch);
        batch.end();
    }
}
