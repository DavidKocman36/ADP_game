package cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer;

import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;

public interface IGameObjectsVisitor {
    void visitCannon(AbsCannon cannon);
    void visitMissile(AbsMissile missile);
}
