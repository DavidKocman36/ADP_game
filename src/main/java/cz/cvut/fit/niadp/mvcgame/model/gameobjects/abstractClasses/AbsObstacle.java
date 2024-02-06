package cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import javafx.scene.image.Image;

public abstract class AbsObstacle extends GameObject{
    protected Image image;

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

    public Image getImage(){return this.image;}
}
