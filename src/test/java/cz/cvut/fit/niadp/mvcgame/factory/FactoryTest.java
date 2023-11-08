package cz.cvut.fit.niadp.mvcgame.factory;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.GameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import org.junit.Assert;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void singletonTest() {
        IGameObjectFactory instance1 = GameObjectFactory.getInstance(new GameModel());
        IGameObjectFactory instance2 = GameObjectFactory.getInstance(new GameModel());
        Assert.assertEquals(instance1.hashCode(), instance2.hashCode());
    }
}

