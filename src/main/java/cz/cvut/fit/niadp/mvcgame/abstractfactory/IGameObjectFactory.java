package cz.cvut.fit.niadp.mvcgame.abstractfactory;

import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsObstacle;

import java.util.List;

public interface IGameObjectFactory {
    AbsCannon createCannon();
    AbsMissile createMissile(double initAngle, int initVelocity);
    List<AbsEnemy> createEnemies(float[][] pos);
    List<AbsObstacle> createObstacles(float[][] pos);
}
