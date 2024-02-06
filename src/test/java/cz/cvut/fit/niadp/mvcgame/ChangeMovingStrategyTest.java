package cz.cvut.fit.niadp.mvcgame;

import cz.cvut.fit.niadp.mvcgame.controller.GameController;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.strategy.RealisticMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.strategy.SimpleMovingStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ChangeMovingStrategyTest {
    @Test
    public void changeStrategy(){
        if(!Setup.isRunning()) Setup.setup();

        GameModel model = new GameModel();
        GameController controller = new GameController(model);

        Assert.assertTrue(model.getMovingStrategy() instanceof RealisticMovingStrategy);
        controller.processPressedKeys(Arrays.asList("M"));
        Assert.assertTrue(model.getMovingStrategy() instanceof SimpleMovingStrategy);
    }
}
