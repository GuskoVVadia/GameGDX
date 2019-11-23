package com.geekbrains.app.game;

import com.badlogic.gdx.math.Vector2;
import com.geekbrains.app.GameOptions;
import com.geekbrains.app.game.helpers.Poolable;

public class Bullet implements Poolable {
    private Vector2 position;
    private Vector2 velocity;
    private float angle;
    private boolean active;

    public Vector2 getPosition() {
        return position;
    }

    public float getAngle() {
        return angle;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        active = false;
    }

    public Bullet() {
        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);
        this.active = false;
    }

    public void activate(float x, float y, float vx, float vy, float angle) {
        this.position.set(x, y);
        this.velocity.set(vx, vy);
        this.active = true;
        this.angle = angle;
    }

    public void update(float dt) {
        position.mulAdd(velocity, dt);
        if (position.x < 0.0f || position.x > GameOptions.SCREEN_WIDTH || position.y < 0.0f || position.y > GameOptions.SCREEN_HEIGHT) {
            deactivate();
        }
    }
}