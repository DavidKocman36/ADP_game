package cz.cvut.fit.niadp.mvcgame.abstractfactory;

import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;

import java.util.List;

public interface IGameObjectFactory {
    AbsCannon createCannon();
    AbsMissile createMissile(double initAngle, int initVelocity);
    List<AbsEnemy> createEnemies();
}
