package com.geekbrains.app.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.StringBuilder;
import com.geekbrains.app.screen.utils.Assets;

public class WorldRenderer {
    private GameController gc;
    private SpriteBatch batch;
    private BitmapFont font32;
    private StringBuilder strBuilder;
    private StringBuilder strHeroHP;

    public WorldRenderer(GameController gc, SpriteBatch batch) {
        this.gc = gc;
        this.batch = batch;
        this.font32 = Assets.getInstance().getAssetManager().get("fonts/font32.ttf", BitmapFont.class);
        this.strBuilder = new StringBuilder();
        this.strHeroHP = new StringBuilder();
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        gc.getBackground().render(batch);
        gc.getHero().render(batch);
        gc.getAsteroidController().render(batch);
        gc.getBulletController().render(batch);
        strBuilder.clear();
        strHeroHP.clear();
        strBuilder.append("SCORE: ").append(gc.getHero().getScoreView());
        strHeroHP.append("HP: ").append(gc.getHero().getHpCurrent());
        font32.draw(batch, strBuilder, 20, 700);
        font32.draw(batch, strHeroHP, 20, 650);
        batch.end();
    }
}
