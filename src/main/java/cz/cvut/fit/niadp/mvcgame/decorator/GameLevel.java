package cz.cvut.fit.niadp.mvcgame.decorator;


import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsObstacle;

import java.util.List;

public class GameLevel implements IGameLevel {

    /*
     * Basic game level class
     *
     * Here should be a behaviour shared among all levels.
     * It does nothing yet.
     */
    @Override
    public List<AbsEnemy> generateEnemies(){
        return null;
    }

    @Override
    public List<AbsObstacle> generateObstacles() {
        return null;
    }
}
