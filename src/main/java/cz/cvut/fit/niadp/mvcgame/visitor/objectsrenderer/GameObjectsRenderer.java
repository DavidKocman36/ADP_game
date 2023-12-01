package cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer;


import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;
import javafx.geometry.Pos;
import javafx.scene.image.Image;

import java.util.Random;

public class GameObjectsRenderer implements IGameObjectsVisitor {

    private IGameGraphics gameGraphics;

    public void setGraphicsContext(IGameGraphics gameGraphics) {
        this.gameGraphics = gameGraphics;
    }

    @Override
    public void visitCannon(AbsCannon cannon) {
        this.gameGraphics.save(); // saves the current state on stack, including the current transform
        this.gameGraphics.rotateCannon(cannon);
        this.gameGraphics.drawImage(MvcGameConfig.CANNON_IMAGE_RESOURCE, cannon.getPosition());
        this.gameGraphics.restore(); // back to original state (before rotation)
    }

    @Override
    public void visitMissile(AbsMissile missile) {
        double[] img = this.gameGraphics.drawImage(MvcGameConfig.MISSILE_IMAGE_RESOURCE, missile.getPosition());
        missile.setWidth(img[0]);
        missile.setHeight(img[1]);
    }

    @Override
    public void visitEnemy(AbsEnemy enemy) {
        double[] img = this.gameGraphics.drawImage(enemy.getImage(), enemy.getPosition());
        enemy.setWidth(img[0]);
        enemy.setHeight(img[1]);
    }
}
