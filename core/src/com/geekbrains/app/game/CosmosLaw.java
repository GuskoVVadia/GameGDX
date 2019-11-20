package com.geekbrains.app.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class CosmosLaw {
    private GameController gc;
    private ArrayList<SpaceObject> listSO;
    private SpaceObject[] inGameObject;

    public CosmosLaw(GameController gc) {
        this.gc = gc;
        this.listSO = gc.getListSO();
        this.inGameObject = new SpaceObject[listSO.size()];
    }

    public void update(float dt){
        listSO.toArray(inGameObject);
        for (SpaceObject o: listSO){
            for (int i = 0; i < inGameObject.length; i++) {
                if (!o.equals(inGameObject[i])){
                    float length = o.getPosition().dst(inGameObject[i].getPosition());
                    Vector2 localObject;

                    if (length <= (o.getRealSize() + inGameObject[i].getRealSize())){
                        if (o.getRealSize() < inGameObject[i].getRealSize()){
                            localObject = o.getPosition().sub(inGameObject[i].getPosition());
                            localObject.nor();
                            localObject.x *= 5;
                            localObject.y *= 5;
                            o.setPosition(localObject);
                        }else {
                            localObject = inGameObject[i].getPosition().sub(o.getPosition());
                            localObject.nor();
                            localObject.x *= 5;
                            localObject.y *= 5;
                            inGameObject[i].setPosition(localObject);
                        }
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch){
    }
}
