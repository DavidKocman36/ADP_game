package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.Vector;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.ISoundsVisitor;

public class CannonA extends AbsCannon {

    // private int power
    // private double angle

    private final IGameObjectFactory gameObjectsFactory;

    public CannonA(Position initPosition, IGameObjectFactory gameObjectsFactory) {
        this.position = initPosition;
        this.gameObjectsFactory = gameObjectsFactory;
    }


    @Override
    public void moveUp() {
        this.move(new Vector(0, -MvcGameConfig.MOVE_STEP));
    }

    @Override
    public void moveDown(){
        this.move(new Vector(0, MvcGameConfig.MOVE_STEP));
    }

    @Override
    public AbsMissile shoot() {
        return gameObjectsFactory.createMissile();
    }

    @Override
    public void acceptVisitor(IGameObjectsVisitor visitor) {
        visitor.visitCannon(this);
    }

    @Override
    public void acceptVisitor(ISoundsVisitor visitor) {
        visitor.visitCannon(this);
    }
}
