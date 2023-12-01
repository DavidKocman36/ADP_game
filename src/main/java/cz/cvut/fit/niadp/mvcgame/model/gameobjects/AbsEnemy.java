package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.model.Position;

public abstract class AbsEnemy extends LifetimeLimitedGameObject {
    protected String image;

    protected AbsEnemy(Position position) {
        super(position);
    }

    public abstract String getImage();
    public abstract void setImage(String image);
}
