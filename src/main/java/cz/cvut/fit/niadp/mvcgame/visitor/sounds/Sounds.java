package cz.cvut.fit.niadp.mvcgame.visitor.sounds;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Sounds implements ISoundsVisitor{

    private final AudioClip cannonSound;
    private final AudioClip missileSound;
    public Sounds(){
        cannonSound = new AudioClip(getClass().getResource(MvcGameConfig.BOOM_SOUND_RESOURCE).toExternalForm());
        missileSound = new AudioClip(getClass().getResource(MvcGameConfig.MISSILE_SOUND_RESOURCE).toExternalForm());
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
