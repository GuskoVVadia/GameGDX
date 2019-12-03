package com.geekbrains.app.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.geekbrains.app.GameOptions;
import com.geekbrains.app.SpaceProject;
import com.geekbrains.app.screen.ScreenManager;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = ScreenManager.SCREEN_WIDTH;
		config.height = ScreenManager.SCREEN_HEIGHT;

		if (ScreenManager.FULL_SCREEN){
			config.fullscreen = true;
		}
		new LwjglApplication(new SpaceProject(), config);
	}
}
