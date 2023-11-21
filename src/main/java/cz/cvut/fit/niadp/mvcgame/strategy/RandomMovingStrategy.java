package cz.cvut.fit.niadp.mvcgame.strategy;

import cz.cvut.fit.niadp.mvcgame.model.Vector;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;

import java.util.Random;

public class RandomMovingStrategy implements IMovingStrategy
{
    @Override
    public void updatePosition(AbsMissile missile) {
        Random rnd = new Random();

        int initVelocity = missile.getInitVelocity();
        double initAngle = missile.getInitAngle();
        long time = missile.getAge() / 100;

        int dX = (int) (initVelocity * time * Math.cos(initAngle));
        int number = rnd.nextInt(100);
        int aux = (int) (initVelocity * time * Math.sin(initAngle));
        int dY;
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
