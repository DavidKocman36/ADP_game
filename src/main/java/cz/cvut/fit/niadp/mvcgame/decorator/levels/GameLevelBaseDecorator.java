package cz.cvut.fit.niadp.mvcgame.decorator.levels;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.decorator.IGameLevel;


public abstract class GameLevelBaseDecorator implements IGameLevel {
    protected IGameLevel wrappee;
    protected IGameObjectFactory gameObjectFactory;
}
