package cz.cvut.fit.niadp.mvcgame.strategy;

import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsMissile;

public interface IMovingStrategy {
    String getName();
    void updatePosition(AbsMissile missile);
}
