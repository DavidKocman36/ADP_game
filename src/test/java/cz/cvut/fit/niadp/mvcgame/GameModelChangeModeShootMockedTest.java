package cz.cvut.fit.niadp.mvcgame;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.GameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.niadp.mvcgame.state.SingleShootingMode;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.Sounds;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameModelChangeModeShootMockedTest {
    private GameModel gameModelMock;

    @Before
    public void init() throws InterruptedException {
        gameModelMock = mock(GameModel.class);
    }
    @Test
    public void changeModeAndShoot() {
        if(!Setup.isRunning()) Setup.setup();

        IGameObjectFactory gameObjectFactory = GameObjectFactory.getInstance(this.gameModelMock);
        when(gameModelMock.getCannonPos()).thenReturn(new Position(100, 100));
        when(gameModelMock.getSounds()).thenReturn(new Sounds());

        AbsCannon cannon = gameObjectFactory.createCannon();
        Assert.assertTrue(cannon.getShootingMode() instanceof SingleShootingMode);
        cannon.toggleShootingMode();
        List<AbsMissile> batch = cannon.shoot();
        Assert.assertEquals(batch.size(), 2);
    }
}
