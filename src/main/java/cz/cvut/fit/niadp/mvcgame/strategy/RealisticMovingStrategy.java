package cz.cvut.fit.niadp.mvcgame.strategy;

import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Vector;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsMissile;

public class RealisticMovingStrategy implements IMovingStrategy {
    @Override
    public String getName() {
        return "Realistic";
    }
    @Override
    public void updatePosition(AbsMissile missile) {
        double velocityX = missile.getVelocityX();
        double velocityY = missile.getVelocityY();

        double initAngle = missile.getInitAngle();
        long time = missile.getAge() / 100;

        float dX = (float) (velocityX * time * Math.cos(initAngle)) / 10;
        float dY = (float) (velocityY * time * Math.sin(initAngle) + (0.5 * MvcGameConfig.GRAVITY * time * time)) / 10;

        missile.move(new Vector(dX, dY));
    }
}