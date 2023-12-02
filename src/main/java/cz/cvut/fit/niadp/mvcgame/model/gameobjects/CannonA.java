package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.iterator.IIterator;
import cz.cvut.fit.niadp.mvcgame.iterator.repos.ShootingModeIteratorRepository;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.Vector;
import cz.cvut.fit.niadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.ISoundsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.Sounds;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CannonA extends AbsCannon {
    private final IGameObjectFactory gameObjectsFactory;
    private List<AbsMissile> shootingBatch;
    private LocalDateTime shotAt;
    private final Sounds sounds;
    private final ShootingModeIteratorRepository shootingModeIteratorRepository;
    private final IIterator iterator;


    public CannonA(Position initPosition, IGameObjectFactory gameObjectsFactory, Sounds sounds) {
        this.position = initPosition;
        this.gameObjectsFactory = gameObjectsFactory;
        this.power = MvcGameConfig.INIT_POWER;
        this.angle = MvcGameConfig.INIT_ANGLE;

        this.shootingBatch = new ArrayList<>();
        this.shotAt = LocalDateTime.now().minusNanos(1250000000);
        this.sounds = sounds;
        this.numberOfMissiles = 2;

        this.shootingModeIteratorRepository = new ShootingModeIteratorRepository();
        this.iterator = this.shootingModeIteratorRepository.getIterator();
        this.shootingMode = (IShootingMode) this.iterator.next();

        this.width = 0;
        this.height = 0;
    }


    @Override
    public void moveUp() {
        this.move(new Vector(0, -MvcGameConfig.MOVE_STEP));
    }

    @Override
    public void moveDown(){
        this.move(new Vector(0, MvcGameConfig.MOVE_STEP));
    }

    @Override
    public void aimUp() {
        if(this.angle > -Math.PI/2) {
            this.angle -= MvcGameConfig.ANGLE_STEP;
        }
    }
    @Override
    public void aimDown() {
        if(this.angle < Math.PI/2) {
            this.angle += MvcGameConfig.ANGLE_STEP;
        }
    }
    @Override
    public void setPower(int power) {
        this.power = power;
    }
    @Override
    public void powerUp() {
        this.power = Math.min(MvcGameConfig.MAX_POWER, this.power + MvcGameConfig.POWER_STEP);
    }
    @Override
    public void powerDown() {
        this.power = Math.max(MvcGameConfig.MIN_POWER, this.power - MvcGameConfig.POWER_STEP);
    }

    @Override
    public double getAngle() {
        return this.angle;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void setAngle(double angle){
        this.angle = angle;
    }

    @Override
    public void setNumberOfMissiles(int numberOfMissiles) {
        this.numberOfMissiles = numberOfMissiles;
    }

    @Override
    public void addMissile() {
        this.numberOfMissiles += 1;
    }

    @Override
    public void subMissile() {
        this.numberOfMissiles = Math.max(1, this.numberOfMissiles - 1);
    }

    @Override
    public int getNumberOfMissiles() {
        return this.numberOfMissiles;
    }

    @Override
    public void primitiveShoot() {
        this.shootingBatch.add(this.gameObjectsFactory.createMissile(this.angle, this.power));
    }

    @Override
    public List<AbsMissile> shoot() {
        this.shootingBatch.clear();
        LocalDateTime aux = this.shotAt.plusNanos(1250000000);

        if (aux.isBefore(LocalDateTime.now())) {
            this.shootingMode.shoot(this);
            this.shotAt = LocalDateTime.now();
            this.acceptSoundsVisitor(this.sounds);
        }

        return this.shootingBatch;
    }

    @Override
    public void toggleShootingMode() {
        this.shootingMode = (IShootingMode) iterator.next();
        System.out.println(shootingMode);
    }

    @Override
    public void acceptObjectVisitor(IGameObjectsVisitor visitor) {
        visitor.visitCannon(this);
    }

    @Override
    public void acceptSoundsVisitor(ISoundsVisitor visitor) {
        visitor.visitCannon(this);
    }
}
