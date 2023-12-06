package cz.cvut.fit.niadp.mvcgame.strategy;

import cz.cvut.fit.niadp.mvcgame.model.Vector;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsMissile;

import java.util.Random;

public class RandomMovingStrategy implements IMovingStrategy
{
    @Override
    public String getName() {
        return "Random";
    }

    @Override
    public void updatePosition(AbsMissile missile) {
        Random rnd = new Random();

        double initVelocity = missile.getVelocity();
        double initAngle = missile.getInitAngle();
        long time = missile.getAge() / 100;

        float dX = (float) (initVelocity * time * Math.cos(initAngle))/10;
        int number = rnd.nextInt(100);
        int aux = (int) (initVelocity * time * Math.sin(initAngle))/10;
        float dY;
        if(number > 75) {
            dY = rnd.nextInt(aux,aux+50);
        }
        else if (number < 25){
            dY = rnd.nextInt(aux-50,aux);
        }
        else {
            dY = aux;
        }

        missile.move(new Vector(dX, dY));
    }
}
