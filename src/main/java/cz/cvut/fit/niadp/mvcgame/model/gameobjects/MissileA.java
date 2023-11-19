package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.ISoundsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.Sounds;

public class MissileA extends AbsMissile{
    private final IMovingStrategy movingStrategy;
    public MissileA(Position initPosition, double initAngle, int initVelocity, IMovingStrategy movingStrategy, Sounds sounds) {
        super(initPosition, initAngle, initVelocity);
        this.movingStrategy = movingStrategy;
        this.acceptSoundsVisitor(sounds);
    }

    @Override
    public void move() {
        this.movingStrategy.updatePosition(this);
    }

    @Override
    public void acceptObjectVisitor(IGameObjectsVisitor visitor) {
        visitor.visitMissile(this);
    }

    @Override
    public void acceptSoundsVisitor(ISoundsVisitor visitor) {
        visitor.visitMissile(this);
    }

}
