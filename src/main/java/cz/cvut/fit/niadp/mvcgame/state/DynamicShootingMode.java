package cz.cvut.fit.niadp.mvcgame.state;

import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsCannon;

public class DynamicShootingMode implements IShootingMode{
    @Override
    public String getName() {
        return "Dynamic";
    }

    @Override
    public void shoot(AbsCannon cannon) {
        boolean isEven = cannon.getNumberOfMissiles() % 2 == 0;
        double initAngle = cannon.getAngle();

        if(isEven) {
            for (int i = 1; i <= cannon.getNumberOfMissiles(); i++) {
                this.aimAndShoot(i, cannon);
            }
            cannon.setAngle(initAngle);
        }
        else {
            for (int i = 0; i < cannon.getNumberOfMissiles(); i++) {
                this.aimAndShoot(i, cannon);
            }
            cannon.setAngle(initAngle);
        }
    }

    private void aimAndShoot(int i, AbsCannon cannon){
        if (i%2==1) {
            for (int j = 0; j < i; j++) {
                if(cannon.getAngle() > -Math.PI/2)
                    cannon.aimUp();
                else
                    cannon.aimDown();
            }
            cannon.primitiveShoot();
        }
        else {
            for (int j = 0; j < i; j++) {
                if(cannon.getAngle() < Math.PI/2)
                    cannon.aimDown();
                else
                    cannon.aimUp();
            }
            cannon.primitiveShoot();
        }
    }
}


