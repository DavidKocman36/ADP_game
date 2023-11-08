package cz.cvut.fit.niadp.mvcgame.visitor;

import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.ISoundsVisitor;

public interface IVisitable {
    void acceptVisitor(IGameObjectsVisitor visitor);
    void acceptVisitor(ISoundsVisitor visitor);
}
