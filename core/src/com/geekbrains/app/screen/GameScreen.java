package com.geekbrains.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.geekbrains.app.game.controllers.GameController;
import com.geekbrains.app.game.WorldRenderer;
import com.geekbrains.app.screen.utils.Assets;

public class GameScreen extends AbstractScreen {
    private GameController gameController;
    private WorldRenderer worldRenderer;
    private BitmapFont font24;
    private Stage stage;
    private boolean active;

    public GameScreen(SpriteBatch batch) {
        super(batch);
        this.active = true;
    }

    @Override
    public void show() {
        Assets.getInstance().loadAssets(ScreenManager.ScreenType.GAME);
        this.gameController = new GameController();
        this.worldRenderer = new WorldRenderer(gameController, batch);
        this.stage = new Stage(ScreenManager.getInstance().getViewport(), batch);
        this.font24 = Assets.getInstance().getAssetManager().get("fonts/font24.ttf");

        Gdx.input.setInputProcessor(stage);

        Skin skin = new Skin();
        skin.addRegions(Assets.getInstance().getAtlas());

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("smButton");
        textButtonStyle.font = font24;
        skin.add("simpleSkin", textButtonStyle);

        Button btnPauseGame = new TextButton("Pause", textButtonStyle);
        Button btnMenuGame = new TextButton("Menu", textButtonStyle);
        btnPauseGame.setPosition(1000, 650);
        btnMenuGame.setPosition(1000, 600);

        btnPauseGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getChangeState();
            }
        });

        btnMenuGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                ScreenManager.getInstance().changeScreen(ScreenManager.ScreenType.MENU);
            }
        });

        stage.addActor(btnPauseGame);
        stage.addActor(btnMenuGame);
        skin.dispose();
    }

    @Override
    public void render(float delta) {
        update(delta);
        if (active) {
            gameController.update(delta);
            worldRenderer.render();
        }
        stage.draw();
    }

    @Override
    public void dispose(){
        gameController.dispose();
    }

    public void getChangeState(){
        this.active = !active;
    }

    public void update(float delta){
        stage.act(delta);
    }
}
