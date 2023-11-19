package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.ISoundsVisitor;

public class Enemy extends GameObject{
    public Enemy() {

    }

    @Override
    public void acceptObjectVisitor(IGameObjectsVisitor visitor) {
        //nothing yet
    }

    @Override
    public void acceptSoundsVisitor(ISoundsVisitor visitor) {

    }
}
