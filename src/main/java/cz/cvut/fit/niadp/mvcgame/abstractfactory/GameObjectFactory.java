package cz.cvut.fit.niadp.mvcgame.abstractfactory;

import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.*;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.EnemyPos;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameObjectFactory implements IGameObjectFactory {

    private final IGameModel model;
    private static IGameObjectFactory instance = null;
    private final Image missileImg;
    private final Image cannonImg;
    private final Image enemy1Img;
    private final Image enemy2Img;


    private GameObjectFactory(IGameModel model) {
        this.model = model;
        this.missileImg = MvcGameConfig.MISSILE_IMAGE;
        this.cannonImg = MvcGameConfig.CANNON_IMAGE;
        this.enemy1Img = MvcGameConfig.ENEMY1_IMAGE;
        this.enemy2Img = MvcGameConfig.ENEMY2_IMAGE;
    }

    public static IGameObjectFactory getInstance(GameModel model){
        if(instance == null)
            instance = new GameObjectFactory(model);

        return instance;
    }

    @Override
    public AbsCannon createCannon() {
        return new CannonA(
                new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y),
                this,
                this.model.getSounds(),
                this.cannonImg
        );
    }

    @Override
    public MissileA createMissile(double initAngle, int initVelocity) {
        return new MissileA(
                new Position(this.model.getCannonPos().getX(), this.model.getCannonPos().getY()),
                initAngle,
                initVelocity,
                this.model.getMovingStrategy(),
                this.model.getSounds(),
                this.missileImg
        );

    }

    @Override
    public List<AbsEnemy> createEnemies() {
        EnemyPos enemyPos = new EnemyPos();
        int[][] pos = enemyPos.getInitPos();
        List<AbsEnemy> enemies = new ArrayList<>();
        Image [] arr = {this.enemy1Img, this.enemy2Img};
        Random random = new Random();
        int select;
        for (int[] p : pos) {
            select = random.nextInt(arr.length);
            enemies.add(new EnemyA(new Position(p[0], p[1]), arr[select]));
        }
        return enemies;
    }
}
