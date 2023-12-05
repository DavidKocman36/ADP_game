package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import javafx.scene.image.Image;

public abstract class AbsEnemy extends LifetimeLimitedGameObject {
    protected Image image;
    protected Long collided;

    protected AbsEnemy(Position position) {
        super(position);
        this.width = 0;
        this.height = 0;
        this.collided = (long)0;
    }

    public abstract Image getImage();
    public abstract void setImage(Image image);
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
