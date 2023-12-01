package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.model.Position;

public abstract class AbsEnemy extends LifetimeLimitedGameObject {
    protected String image;
    protected Long collided;

    protected AbsEnemy(Position position) {
        super(position);
        this.width = 0;
        this.height = 0;
        this.collided = (long)0;
    }

    public abstract String getImage();
    public abstract void setImage(String image);
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
    public void setCollided(Long collided) {
        this.collided = collided;
    }
    public Long getCollided() {
        return this.collided;
    }
}
