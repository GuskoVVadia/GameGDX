package com.geekbrains.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.StringBuilder;
import com.geekbrains.app.screen.utils.Assets;


public class GameOverScreen extends AbstractScreen{

    private BitmapFont font72;
    private BitmapFont font16;
    private StringBuilder stringBuilder;
    private Stage stage;
    private int heroHP;
    private int heroMoney;
    private int heroScore;


    public GameOverScreen (SpriteBatch batch){
        super(batch);
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void show() {
        Assets.getInstance().makeLinks();
        this.stage = new Stage(ScreenManager.getInstance().getViewport(), batch);
        this.font72 = Assets.getInstance().getAssetManager().get("fonts/font72.ttf");
        this.font16 = Assets.getInstance().getAssetManager().get("fonts/font16.ttf");

        Gdx.input.setInputProcessor(stage);

        Skin skins = new Skin();
        skins.addRegions(Assets.getInstance().getAtlas());

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skins.getDrawable("simpleButton");
        textButtonStyle.font = font16;
        skins.add("simpleSkin", textButtonStyle);

        Button btnNewGame = new TextButton("New Game", textButtonStyle);
        btnNewGame.setPosition(480, 210);

        btnNewGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                ScreenManager.getInstance().changeScreen(ScreenManager.ScreenType.GAME);
            }
        });

        stage.addActor(btnNewGame);
        skins.dispose();
    }

    public void update(float dt){
        stage.act(dt);
    }

    public void addHeroStatics(int score, int money, int hp) {
        this.heroScore = score;
        this.heroMoney = money;
        this.heroHP = hp;
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        stringBuilder.clear();
        stringBuilder.append("Statistics: ").append("\n");
        stringBuilder.append("Score: ").append(heroScore).append("\n");
        stringBuilder.append("Money: ").append(heroMoney).append("\n");
        stringBuilder.append("HP: ").append(heroHP).append("\n");
        font16.draw(batch, stringBuilder, 200, 600);
        font72.draw(batch, "Star Game 2020", 0, 600, ScreenManager.SCREEN_WIDTH, 1, false);

        batch.end();
        stage.draw();
    }

    @Override
    public void dispose() {
    }

}
