package cz.cvut.fit.niadp.mvcgame.model;

import cz.cvut.fit.niadp.mvcgame.visitor.IVisitable;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.ISoundsVisitor;

public class GameInfo implements IVisitable {

    // Made them public so that there is not a large number of getters and setters
    public int enemies;
    public int destroyedEnemies;
    public double cannonAngle;
    public int cannonPower;
    public int numOfMissiles;
    public int score;
    public boolean isCheating;

    public int numberOfFiredMissiles;
    public String missileStrategy;
    public String cannonState;
    private final IGameModel model;

    public GameInfo(IGameModel model) {
        this.model = model;
        this.enemies = this.model.getEnemies().size() - this.model.getHitEnemies().size();
        this.destroyedEnemies = this.model.getHitEnemies().size();
        this.score = 0;
        this.cannonAngle = this.model.getCannon().getAngle()*-57.2957795;
        this.cannonPower = this.model.getCannon().getPower();
        this.numOfMissiles = this.model.getCannon().getNumberOfMissiles();
        this.numberOfFiredMissiles = this.model.getNumberOfFiredMissiles();
        this.missileStrategy = "Realistic";
        this.cannonState = this.model.getCannon().getShootingMode().getName();
        this.isCheating = false;
    }

    public void updateInfo(){
        this.enemies = this.model.getEnemies().size() - this.model.getHitEnemies().size();
        this.destroyedEnemies = this.model.getHitEnemies().size();
        this.score = this.model.getScore();
        this.cannonAngle = this.model.getCannon().getAngle()*-57.2957795;
        this.cannonPower = this.model.getCannon().getPower();
        this.numOfMissiles = this.model.getCannon().getNumberOfMissiles();
        this.numberOfFiredMissiles = this.model.getNumberOfFiredMissiles();
        this.missileStrategy = this.model.getMovingStrategy().getName();
        this.cannonState = this.model.getCannon().getShootingMode().getName();
        this.isCheating = this.model.getCheats();
    }

    @Override
    public void acceptObjectVisitor(IGameObjectsVisitor visitor) {
        visitor.visitGameInfo(this);
    }

    @Override
    public void acceptSoundsVisitor(ISoundsVisitor visitor) {

    }
}
