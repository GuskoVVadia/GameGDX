package com.geekbrains.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.geekbrains.ScreenManager;
import com.geekbrains.SpaceProject;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;

		if (ScreenManager.FULL_SCREEN){
			config.fullscreen = true;
		}
		new LwjglApplication(new SpaceProject(), config);
	}
}
