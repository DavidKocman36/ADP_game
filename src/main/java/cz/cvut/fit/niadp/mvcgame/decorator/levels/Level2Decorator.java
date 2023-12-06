package cz.cvut.fit.niadp.mvcgame.decorator.levels;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.decorator.IGameLevel;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsObstacle;

import java.util.List;

public class Level2Decorator extends GameLevelBaseDecorator{

    private final int[][] level2EnemyPositions = {
            {610, 59}, {680, 99}, {1180, 89},
            {880, 309}, {950, 339}, {1110, 439},
            {790, 459}, {900, 400},
    };

    private final int[][] level2ObstaclePositions = {
            {360, 125}, {560, 400}
    };

    public Level2Decorator(IGameLevel source, IGameObjectFactory factory) {
        this.wrappee = source;
        this.gameObjectFactory = factory;
    }

    public List<AbsEnemy> generateEnemies() {
        return this.gameObjectFactory.createEnemies(this.level2EnemyPositions);
    }

    public List<AbsObstacle> generateObstacles() {
        return this.gameObjectFactory.createObstacles(level2ObstaclePositions);
    }
}
