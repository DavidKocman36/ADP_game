package cz.cvut.fit.niadp.mvcgame;

import cz.cvut.fit.niadp.mvcgame.controller.GameController;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class MoveCannonTest {

    @Test
    public void changeStrategy() {
        if(!Setup.isRunning()) Setup.setup();
        GameModel gameModel = new GameModel();
        GameController gameController = new GameController(gameModel);

        Assert.assertEquals((int)gameModel.getCannonPos().getY(), 360);
        gameController.processPressedKeys(Arrays.asList("UP"));
        Assert.assertEquals((int)gameModel.getCannonPos().getY(), 350);
    }
}
