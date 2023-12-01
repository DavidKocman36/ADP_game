package cz.cvut.fit.niadp.mvcgame.strategy;

import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;

public interface IMovingStrategy {
    String getName();
    void updatePosition(AbsMissile missile);
}
