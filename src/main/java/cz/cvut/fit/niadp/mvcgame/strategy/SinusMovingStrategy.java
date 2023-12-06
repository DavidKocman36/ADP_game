package cz.cvut.fit.niadp.mvcgame.strategy;

import cz.cvut.fit.niadp.mvcgame.model.Vector;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsMissile;

public class SinusMovingStrategy implements IMovingStrategy{
    @Override
    public String getName() {
        return "Sinus";
    }
    @Override
    public void updatePosition(AbsMissile missile) {
        int initVelocity = missile.getInitVelocity();
        double initAngle = missile.getInitAngle();
        long time = missile.getAge() / 100;

        int dX = (int) (initVelocity * time * Math.cos(initAngle));
        int dY = (int) (20*Math.sin(dX));

        missile.move(new Vector(dX, dY));
    }
}
