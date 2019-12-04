package com.geekbrains.app.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Shop extends Group{
    private Hero hero;

    public Shop(Hero hero){
        this.hero = hero;

        Pixmap pixmap = new Pixmap(400, 400, Pixmap.Format.RGB888);
        pixmap.setColor(Color.rgb888(0.0f, 0.0f, 0.4f));
        pixmap.fill();

        Image image = new Image(new Texture(pixmap));
        addActor(image);
    }




}
