package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.ISoundsVisitor;

public class MissileA extends AbsMissile{
    public MissileA(Position position) {
        this.position = position;
    }

    @Override
    public void acceptVisitor(IGameObjectsVisitor visitor) {
        visitor.visitMissile(this);
    }

    @Override
    public void acceptVisitor(ISoundsVisitor visitor) {
        visitor.visitMissile(this);
    }

}
