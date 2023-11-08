package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;

public class Enemy extends GameObject{
    public Enemy() {

    }

    @Override
    public void acceptVisitor(IGameObjectsVisitor visitor) {
        //nothing yet
    }
}
