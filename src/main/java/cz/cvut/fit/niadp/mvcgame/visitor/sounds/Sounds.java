package cz.cvut.fit.niadp.mvcgame.visitor.sounds;

import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;
import javafx.scene.media.AudioClip;

public class Sounds implements ISoundsVisitor{

    private final AudioClip cannonSound;
    private final AudioClip missileSound;
    public Sounds(){
        cannonSound = MvcGameConfig.CANNON_SOUND;
        missileSound = MvcGameConfig.MISSILE_SOUND;
    }
    @Override
    public void visitCannon(AbsCannon cannon) {
        cannonSound.play();
    }

    @Override
    public void visitMissile(AbsMissile missile) {
        missileSound.play();
    }
}
