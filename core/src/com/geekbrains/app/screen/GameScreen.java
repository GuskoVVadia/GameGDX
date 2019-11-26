package com.geekbrains.app.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.geekbrains.app.game.GameController;
import com.geekbrains.app.game.WorldRenderer;
import com.geekbrains.app.screen.utils.Assets;

public class GameScreen extends AbstractScreen {
    private GameController gameController;
    private WorldRenderer worldRenderer;
    private SpriteBatch batch;

    public GameScreen(SpriteBatch batch) {
        this.batch = batch;
    }

    @Override
    public void show() {
        Assets.getInstance().loadAssets(ScreenManager.ScreenType.GAME);
        this.gameController = new GameController();
        this.worldRenderer = new WorldRenderer(gameController, batch);
    }

    @Override
    public void render(float delta) {
        gameController.update(delta);
        worldRenderer.render();
    }
}
