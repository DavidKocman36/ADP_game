package cz.cvut.fit.niadp.mvcgame;

import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.EnemyA;
import org.junit.Assert;
import org.junit.Test;

public class EnemyCollidedBasicTest {
    @Test
    public void setCollidedEnemy() throws InterruptedException {
        AbsEnemy enemy = new EnemyA(new Position(333, 444), MvcGameConfig.ENEMY1_IMAGE);
        Thread.sleep(500);
        Assert.assertEquals(enemy.getImage(), MvcGameConfig.ENEMY1_IMAGE);
        enemy.setCollided(enemy.getAge());
        enemy.setImage(MvcGameConfig.HIT_ENEMY_IMAGE);
        Assert.assertNotEquals(enemy.getImage(), MvcGameConfig.ENEMY1_IMAGE);
    }
}

