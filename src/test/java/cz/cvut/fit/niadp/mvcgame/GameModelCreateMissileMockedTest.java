package cz.cvut.fit.niadp.mvcgame;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.GameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsMissile;

import cz.cvut.fit.niadp.mvcgame.visitor.sounds.Sounds;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameModelCreateMissileMockedTest {
    private static final int CANNON_TEST_POSITION_X = 100;
    private static final int CANNON_TEST_POSITION_Y = 100;
    private static final double INIT_TEST_ANGLE = 0;
    private static final int INIT_TEST_VELOCITY = 0;

    private GameModel gameModelMock;

    @Before
    public void init() throws InterruptedException {
        gameModelMock = mock(GameModel.class);
    }
    @Test
    public void moveCannonTest() {
        if(!Setup.isRunning()) Setup.setup();
        IGameObjectFactory gameObjectFactory = GameObjectFactory.getInstance(gameModelMock);
        when(gameModelMock.getCannonPos()).thenReturn(new Position(CANNON_TEST_POSITION_X, CANNON_TEST_POSITION_Y));
        when(gameModelMock.getSounds()).thenReturn(new Sounds());

        AbsMissile missile = gameObjectFactory.createMissile(INIT_TEST_ANGLE, INIT_TEST_VELOCITY);
        Assert.assertEquals(CANNON_TEST_POSITION_X, (int) missile.getPosition().getX());
        Assert.assertEquals(CANNON_TEST_POSITION_Y, (int) missile.getPosition().getY());
    }
}