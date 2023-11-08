package cz.cvut.fit.niadp.mvcgame.visitor.sounds;

import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;

public interface ISoundsVisitor {
    void visitCannon(AbsCannon cannon);
    void visitMissile(AbsMissile missile);
}
