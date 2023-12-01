package cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer;


import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.niadp.mvcgame.model.GameInfo;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;

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

    @Override
    public void visitGameInfo(GameInfo gameInfo) {
        //draw texts with the use of game info
        gameInfo.updateInfo();
        this.gameGraphics.drawText("Scoreboard", new Position(5, 30), 25);
        this.gameGraphics.drawText("Score: " + gameInfo.score, new Position(10, 50), 12);
        this.gameGraphics.drawText("No. of enemies: " + gameInfo.enemies, new Position(10, 65), 12);
        this.gameGraphics.drawText("No. of killed enemies: " + gameInfo.destroyedEnemies, new Position(10, 80), 12);
        this.gameGraphics.drawText("Cannon angle: " + Math.round(gameInfo.cannonAngle) + " deg.", new Position(10, 95), 12);
        this.gameGraphics.drawText("Cannon power: " + gameInfo.cannonPower, new Position(10, 110), 12);
        this.gameGraphics.drawText("No. of fired missiles: " + gameInfo.numberOfFiredMissiles, new Position(10, 125), 12);

        this.gameGraphics.drawText("No. of missiles: " + gameInfo.numOfMissiles, new Position(10, 160), 12);
        this.gameGraphics.drawText("Shooting mode: " + gameInfo.cannonState, new Position(10, 175), 12);
        this.gameGraphics.drawText("Strategy: " + gameInfo.missileStrategy, new Position(10, 190), 12);
    }
}
