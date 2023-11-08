package cz.cvut.fit.niadp.mvcgame.config;

import java.awt.*;

public class MvcGameConfig {

    private static final Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int MAX_X = (int)size.getWidth();
    public static final int MAX_Y = (int)size.getHeight();
    public static final int MOVE_STEP = 10;
    public static final int CANNON_POS_X = 30;
    public static final int CANNON_POS_Y = MAX_Y / 2;

    public static final String GAME_TITLE = "The NI-ADP MvcGame";

    public static final String UP_KEY = "UP";
    public static final String DOWN_KEY = "DOWN";
    public static final String EXIT_KEY = "ESCAPE";
    public static final String SHOOT_KEY = "SPACE";

    public static final String CANNON_IMAGE_RESOURCE = "images/cannon.png";
    public static final String MISSILE_IMAGE_RESOURCE = "images/missile.png";
    public static final String BOOM_SOUND_RESOURCE = "/sounds/boom.mp3";
    public static final String MISSILE_SOUND_RESOURCE = "/sounds/missile.mp3";


}