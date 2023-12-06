package cz.cvut.fit.niadp.mvcgame.decorator.levels;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.decorator.IGameLevel;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsObstacle;

import java.util.List;

public class Level1Decorator extends GameLevelBaseDecorator{

    private final int[][] level1EnemyPositions = {
            {580, 59}, {560, 79}, {1180, 89},
            {780, 309}, {580, 339}, {1080, 439},
            {790, 459}
    };

    public Level1Decorator(IGameLevel source, IGameObjectFactory factory) {
        this.wrappee = source;
        this.gameObjectFactory = factory;
    }

    public List<AbsEnemy> generateEnemies(){
        return this.gameObjectFactory.createEnemies(this.level1EnemyPositions);
    }

    public List<AbsObstacle> generateObstacles() {
        return null;
    }
}
