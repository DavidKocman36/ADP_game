package cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import javafx.scene.image.Image;

public abstract class AbsMissile extends LifetimeLimitedGameObject {
    private final double initAngle;
    private double initVelocity;
    protected Image image;
    protected AbsMissile(Position initPosition, double initAngle, int initVelocity) {
        super(initPosition);
        this.initAngle = initAngle;
        this.initVelocity = initVelocity;
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

    public double getVelocity(){
        return this.initVelocity;
    }
    public void setVelocity(double velocity){
        this.initVelocity = velocity;
    }

}
