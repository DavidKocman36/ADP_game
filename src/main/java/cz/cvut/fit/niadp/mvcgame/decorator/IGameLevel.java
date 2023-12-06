package cz.cvut.fit.niadp.mvcgame.decorator;

import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsObstacle;

import java.util.List;

public interface IGameLevel {

    List<AbsEnemy> generateEnemies();
    List<AbsObstacle> generateObstacles();
}
