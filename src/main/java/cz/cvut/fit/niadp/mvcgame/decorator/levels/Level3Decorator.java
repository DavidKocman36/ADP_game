package cz.cvut.fit.niadp.mvcgame.decorator.levels;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.decorator.IGameLevel;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsObstacle;

import java.util.List;

public class Level3Decorator extends GameLevelBaseDecorator{

    private final int[][] level3EnemyPositions = {
            {580, 59}, {560, 79}, {1180, 89},
            {780, 309}, {580, 339}, {1080, 439},
            {790, 459}
    };

    private final int[][] level3ObstaclePositions = {
            {360, 59}, {760, 89}, {360, 125}
    };

    public Level3Decorator(IGameLevel source, IGameObjectFactory factory) {
        this.wrappee = source;
        this.gameObjectFactory = factory;
    }

    public List<AbsEnemy> generateEnemies() {
        return this.gameObjectFactory.createEnemies(this.level3EnemyPositions);
    }

    public List<AbsObstacle> generateObstacles() {
        return this.gameObjectFactory.createObstacles(level3ObstaclePositions);
    }
}
