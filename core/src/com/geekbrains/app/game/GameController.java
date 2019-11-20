package com.geekbrains.app.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import java.util.ArrayList;

public class GameController {
    private Background background;
    private Hero hero;
    private Asteroid asteroid;
    private ArrayList<SpaceObject> listSO;
    private CosmosLaw cosmosLaw;

    public GameController() {
        this.listSO = new ArrayList<>();
        this.background = new Background(this);
        this.hero = new Hero(this);
        this.asteroid = new Asteroid(this);
        this.cosmosLaw = new CosmosLaw(this);
    }

    public Hero getHero() {
        return hero;
    }

    public Background getBackground() {
        return background;
    }

    public Asteroid getAsteroid() {
        return asteroid;
    }

    public void addListSO(SpaceObject object){
        listSO.add(object);
    }

    public ArrayList<SpaceObject> getListSO() {
        return listSO;
    }

    public void update(float dt){
        background.update(dt);
        cosmosLaw.update(dt);
        asteroid.update(dt);
        hero.update(dt);


        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    void print(){
        for (SpaceObject o: listSO){
            System.out.println(o);
        }
    }


}
