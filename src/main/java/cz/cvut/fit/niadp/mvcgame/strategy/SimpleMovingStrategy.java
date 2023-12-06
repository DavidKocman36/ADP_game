package cz.cvut.fit.niadp.mvcgame.strategy;

import cz.cvut.fit.niadp.mvcgame.model.Vector;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsMissile;

public class SimpleMovingStrategy implements IMovingStrategy {
    @Override
    public String getName() {
        return "Simple";
    }
    @Override
    public void updatePosition(AbsMissile missile) {
        double initVelocity = missile.getVelocity();
        double initAngle = missile.getInitAngle();
        long time = missile.getAge() / 100;

        float dX = (float) (initVelocity * time * Math.cos(initAngle))/10;
        float dY = (float) (initVelocity * time * Math.sin(initAngle))/10;

        missile.move(new Vector(dX, dY));
    }
}

