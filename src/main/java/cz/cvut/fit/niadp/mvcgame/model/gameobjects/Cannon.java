package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.Vector;

public class Cannon extends GameObject {

    // private int power
    // private double angle

    public Cannon(Position initPos){
        this.position = initPos;
    }

    public void moveUP(){
        this.move(new Vector(0, -MvcGameConfig.MOVE_STEP));
    }

    public void moveDown(){
        this.move(new Vector(0, MvcGameConfig.MOVE_STEP));
    }

}
