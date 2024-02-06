package cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.Vector;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitable;

public abstract class GameObject implements IVisitable {

    protected Position position;

    protected double width;
    protected double height;

    public void move(Vector vector)
    {
        this.position.add(vector);
    }

    public Position getPosition() {
        return position;
    }
}
