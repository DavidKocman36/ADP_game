package cz.cvut.fit.niadp.mvcgame.visitor;

import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;

public interface IVisitable {
    void acceptVisitor(IGameObjectsVisitor visitor);
}
