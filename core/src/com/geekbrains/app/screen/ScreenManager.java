/*
ScreenManager - Singleton.
 */

package com.geekbrains.app.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.geekbrains.app.SpaceProject;
import com.geekbrains.app.screen.utils.Assets;

public class ScreenManager {
    public static final boolean FULL_SCREEN = false;


    public static final int SCREEN_WIDTH = 1280;
    public static final int HALF_SCREEN_WIDTH = SCREEN_WIDTH / 2;
    public static final int SCREEN_HEIGHT = 720;
    public static final int HALF_SCREEN_HEIGHT = SCREEN_HEIGHT / 2;

    public enum ScreenType {
        MENU, GAME, OVER
    }

        private SpaceProject game;
        private SpriteBatch batch;
        private LoadingScreen loadingScreen;
        private GameScreen gameScreen;
        private MenuScreen menuScreen;
        private GameOverScreen overScreen;
        private Screen targetScreen;
        private Viewport viewport;
        private Camera camera;

    public GameOverScreen getOverScreen() {
        return overScreen;
    }

    private static ScreenManager ourInstance = new ScreenManager();

        public static ScreenManager getInstance() {
            return ourInstance;
        }

        public Viewport getViewport() {
            return viewport;
        }

        public Camera getCamera() {
            return camera;
        }

        private ScreenManager() {
        }

        public void init(SpaceProject game, SpriteBatch batch) {
            this.game = game;
            this.batch = batch;
            this.camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
            this.viewport = new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT, camera);
            this.gameScreen = new GameScreen(batch);
            this.menuScreen = new MenuScreen(batch);
            this.overScreen = new GameOverScreen(batch);
            this.loadingScreen = new LoadingScreen(batch);
        }

        public void resize(int width, int height) {
            viewport.update(width, height);
            viewport.apply();
        }

        public void resetCamera() {
            camera.position.set(HALF_SCREEN_WIDTH, HALF_SCREEN_HEIGHT, 0);
            camera.update();
            batch.setProjectionMatrix(camera.combined);
        }

        public void changeScreen(ScreenType type) {
            Screen screen = game.getScreen();
            Assets.getInstance().clear();
            if (screen != null) {
                screen.dispose();
            }
            resetCamera();
            game.setScreen(loadingScreen);
            switch (type) {
                case GAME:
                    targetScreen = gameScreen;
                    Assets.getInstance().loadAssets(ScreenType.GAME);
                    break;
                case MENU:
                    targetScreen = menuScreen;
                    Assets.getInstance().loadAssets(ScreenType.MENU);
                    break;
                case OVER:
                    targetScreen = overScreen;
                    Assets.getInstance().loadAssets(ScreenType.OVER);
                    break;
            }
        }

        public void goToTarget() {
            game.setScreen(targetScreen);
        }
    }
