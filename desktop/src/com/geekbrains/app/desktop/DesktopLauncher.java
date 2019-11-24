package com.geekbrains.app.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.geekbrains.app.GameOptions;
import com.geekbrains.app.SpaceProject;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = GameOptions.SCREEN_WIDTH;
		config.height = GameOptions.SCREEN_HEIGHT;

		if (GameOptions.FULL_SCREEN){
			config.fullscreen = true;
		}
		new LwjglApplication(new SpaceProject(), config);
	}
}
