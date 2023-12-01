package cz.cvut.fit.niadp.mvcgame.abstractfactory;

import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.CannonA;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.MissileA;

public class GameObjectFactory implements IGameObjectFactory {

    private final IGameModel model;
    private static IGameObjectFactory instance = null;

    private GameObjectFactory(IGameModel model) {
        this.model = model;
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
                this.model.getSounds()
        );
    }

    @Override
    public MissileA createMissile(double initAngle, int initVelocity) {
        return new MissileA(
                new Position(this.model.getCannonPos().getX(), this.model.getCannonPos().getY()),
                initAngle,
                initVelocity,
                this.model.getMovingStrategy(),
                this.model.getSounds()
        );

    }
}
