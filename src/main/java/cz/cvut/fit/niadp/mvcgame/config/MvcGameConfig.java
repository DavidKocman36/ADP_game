package cz.cvut.fit.niadp.mvcgame.config;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.awt.*;

public class MvcGameConfig {

    private static final Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int MAX_X = (int)size.getWidth();
    public static final int MAX_Y = (int)size.getHeight();
    public static final int MOVE_STEP = 10;
    public static final int CANNON_POS_X = 30;
    public static final int CANNON_POS_Y = MAX_Y / 2;
    public static final double ANGLE_STEP = Math.PI / 18;
    public static final int POWER_STEP = 5;
    public static final int INIT_POWER = 11;
    public static final double INIT_ANGLE = 0.0;
    public static final double GRAVITY = 9.81;
    public static final int MAX_POWER = 50;
    public static final int MIN_POWER = 5;

    public static final String GAME_TITLE = "The NI-ADP MvcGame";

    public static final String UP_KEY = "UP";
    public static final String DOWN_KEY = "DOWN";
    public static final String EXIT_KEY = "ESCAPE";
    public static final String SHOOT_KEY = "SPACE";

    public static final String AIM_UP_KEY = "A";
    public static final String AIM_DOWN_KEY = "Y";
    public static final String POWER_UP_KEY = "F";
    public static final String POWER_DOWN_KEY = "D";
    public static final String MOVING_STRATEGY_KEY = "M";
    public static final String SHOOTING_MODE_KEY = "N";
    public static final String STORE_SNAPSHOT_KEY = "S";
    public static final String RESTORE_SNAPSHOT_KEY = "R";
    public static final String ADD_MISSILE = "RIGHT";
    public static final String REMOVE_MISSILE = "LEFT";

    public static final String CANNON_IMAGE_RESOURCE = "images/cannon.png";
    public static final String MISSILE_IMAGE_RESOURCE = "images/missile.png";
    public static final String BOOM_SOUND_RESOURCE = "/sounds/boom.mp3";
    public static final String MISSILE_SOUND_RESOURCE = "/sounds/missile.mp3";

    public static final Image BACKGROUND_IMAGE = new Image("images/back.jpg");

    public static final AudioClip MISSILE_SOUND = new AudioClip(
            MvcGameConfig.class.getResource(MvcGameConfig.MISSILE_SOUND_RESOURCE).toExternalForm()
    );

    public static final AudioClip CANNON_SOUND = new AudioClip(
            MvcGameConfig.class.getResource(MvcGameConfig.BOOM_SOUND_RESOURCE).toExternalForm()
    );


}