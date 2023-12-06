package cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses;

import cz.cvut.fit.niadp.mvcgame.state.IShootingMode;
import javafx.scene.image.Image;

import java.util.List;

public abstract class AbsCannon extends GameObject{
    protected IShootingMode shootingMode;

    protected int power;
    protected double angle;

    protected Image image;
    public Image getImage(){return this.image;}
    protected int numberOfMissiles;
    public abstract void primitiveShoot();
    public abstract List<AbsMissile> shoot();
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void aimUp();
    public abstract void aimDown();
    public abstract void powerUp();
    public abstract void powerDown();
    public abstract double getAngle();
    public abstract int getPower();
    public abstract void setPower(int power);
    public abstract void setAngle(double angle);
    public abstract void setNumberOfMissiles(int numberOfMissiles);
    public abstract int getNumberOfMissiles();
    public abstract void addMissile();
    public abstract void subMissile();
    public abstract void toggleShootingMode();

    public IShootingMode getShootingMode(){
        return this.shootingMode;
    }
}
