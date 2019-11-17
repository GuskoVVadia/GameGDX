package com.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpaceProject extends ApplicationAdapter {
	private SpriteBatch batch;
    private Background background;
    private Hero hero;
    private Asteroid asteroid;

    public Hero getHero() {
        return hero;
    }

    @Override
	public void create () {
		this.batch = new SpriteBatch();
		this.background = new Background(this);
		this.hero = new Hero();
		this.asteroid = new Asteroid();
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		Gdx.gl.glClearColor(0, 0, 0.4f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
        background.render(batch);
        hero.render(batch);
        asteroid.render(batch);
		batch.end();
	}

	public void update(float dt){
	    background.update(dt);
		asteroid.update(dt);
	    hero.update(dt);


            if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
                Gdx.app.exit();
        }
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
