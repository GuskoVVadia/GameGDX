package com.geekbrains.app.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class SpaceObject {
    protected Texture texture;
    protected Vector2 position;
    protected Vector2 velocity;
    protected float size;
    protected GameController gc;

    SpaceObject(GameController gc, Texture tx, Vector2 pos, Vector2 velocity){
        this.gc = gc;
        this.texture = tx;
        this.position = pos;
        this.velocity = velocity;
        this.size = 1.0f;
        setThis();
    }

    public float getRealSize(){
        return (texture.getHeight() * size) / 2;
    }

    public Vector2 getPosition(){
        return position;
    };

    public Vector2 getVelocity(){
        return velocity;
    };

    //for background
    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    private void setThis(){
        gc.addListSO(this);
    };




}
