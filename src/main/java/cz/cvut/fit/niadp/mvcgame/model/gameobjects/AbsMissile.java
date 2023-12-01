package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.model.Position;

public abstract class AbsMissile extends LifetimeLimitedGameObject {
    private final double initAngle;
    private final int initVelocity;
    protected AbsMissile(Position initPosition, double initAngle, int initVelocity) {
        super(initPosition);
        this.initAngle = initAngle;
        this.initVelocity = initVelocity;
    }
    public abstract void move();
    public double getInitAngle() {
        return this.initAngle;
    }
    public int getInitVelocity() {
        return this.initVelocity;
    }

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

}
