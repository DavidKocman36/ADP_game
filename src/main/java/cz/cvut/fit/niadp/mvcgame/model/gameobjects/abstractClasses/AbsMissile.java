package cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses;

import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import javafx.scene.image.Image;

public abstract class AbsMissile extends LifetimeLimitedGameObject {
    private final double initAngle;
    private double initVelocityX;
    private double initVelocityY;
    protected Image image;
    protected AbsMissile(Position initPosition, double initAngle, int initVelocityX) {
        super(initPosition);
        this.initAngle = initAngle;
        this.initVelocityX = initVelocityX;
        this.initVelocityY = MvcGameConfig.INIT_POWER_Y;
    }
    public abstract void move();
    public double getInitAngle() {
        return this.initAngle;
    }
    public Image getImage(){return this.image;}

    public double getWidth(){
        return this.width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getHeight(){
        return this.height;
    }
    public void setHeight(double height){
        this.height = height;
    }

    public double getVelocityX(){
        return this.initVelocityX;
    }
    public double getVelocityY(){
        return this.initVelocityY;
    }
    public void setVelocityX(double velocity){
        this.initVelocityX = velocity;
    }
    public void setVelocityY(double velocity){
        this.initVelocityY = velocity;
    }
}
