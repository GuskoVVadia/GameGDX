package com.geekbrains.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.StringBuilder;
import com.geekbrains.app.game.Background;
import com.geekbrains.app.game.Hero;
import com.geekbrains.app.screen.utils.Assets;

public class GameOverScreen extends AbstractScreen{
    private Background background;
    private BitmapFont font72;
    private BitmapFont font24;
    private Hero defeatedHero;
    private StringBuilder stringBuilder;

    public void setDefeatedHero(Hero defeatedHero) {
        this.defeatedHero = defeatedHero;
    }

    public GameOverScreen(SpriteBatch batch){
        super(batch);
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void show() {
        this.background = new Background(null);
        this.font72 = Assets.getInstance().getAssetManager().get("fonts/font72.ttf");
        this.font24 = Assets.getInstance().getAssetManager().get("fonts/font24.ttf");

    }

    public void update(float dt){
        background.update(dt);
        if (Gdx.input.isButtonPressed(Input.Keys.M)){
            ScreenManager.getInstance().changeScreen(ScreenManager.ScreenType.MENU);
        }
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);
        font72.draw(batch, "Game Over", 0, 600, ScreenManager.SCREEN_WIDTH, Align.center, false);
        stringBuilder.clear();
        stringBuilder.append("Score: ").append(defeatedHero.getScore()).append("\n");
        font24.draw(batch, stringBuilder, 200, 500);

        batch.end();
    }

    @Override
    public void dispose(){
        background.dispose();
    }
}
