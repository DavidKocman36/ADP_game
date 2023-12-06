package cz.cvut.fit.niadp.config;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import java.awt.*;

public class MvcGameConfig {

    private static final Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int MAX_X = (int)size.getWidth();
    public static final int MAX_Y = (int)size.getHeight();
    public static final int MOVE_STEP = 10;
    public static final int CANNON_POS_X = 230;
    public static final int CANNON_POS_Y = MAX_Y / 2;
    public static final double ANGLE_STEP = Math.PI / 18;
    public static final int POWER_STEP = 5;
    public static final int INIT_POWER = 50;
    public static final double INIT_ANGLE = 0.0;
    public static final double GRAVITY = 9.81;
    public static final int MAX_POWER = 70;
    public static final int MIN_POWER = 30;

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
    public static final String UNDO_LAST_COMMAND_KEY = "B";
    public static final String ADD_MISSILE = "RIGHT";
    public static final String REMOVE_MISSILE = "LEFT";
    public static final String SET_CHEATS = "H";

    public static final String CANNON_IMAGE_RESOURCE = "images/cannon.png";
    public static final String MISSILE_IMAGE_RESOURCE = "images/missile.png";
    public static final String ENEMY1_IMAGE_RESOURCE = "images/enemy1.png";
    public static final String ENEMY2_IMAGE_RESOURCE = "images/enemy2.png";
    public static final String HIT_ENEMY_IMAGE_RESOURCE = "images/collision.png";
    public static final String BLOODY_ENEMY_IMAGE_RESOURCE = "images/enemy2WithBlood.png";
    public static final String OBSTACLE_IMAGE_RESOURCE = "images/bound.png";
    public static final String ICON_RESOURCE = "icons/fit-icon.png";

    public static final Image CANNON_IMAGE = new Image(CANNON_IMAGE_RESOURCE);
    public static final Image MISSILE_IMAGE = new Image(MISSILE_IMAGE_RESOURCE);
    public static final Image ENEMY1_IMAGE = new Image(ENEMY1_IMAGE_RESOURCE);
    public static final Image ENEMY2_IMAGE = new Image(ENEMY2_IMAGE_RESOURCE);
    public static final Image HIT_ENEMY_IMAGE = new Image(HIT_ENEMY_IMAGE_RESOURCE);
    public static final Image BLOODY_ENEMY_IMAGE = new Image(BLOODY_ENEMY_IMAGE_RESOURCE);
    public static final Image OBSTACLE_IMAGE = new Image(OBSTACLE_IMAGE_RESOURCE);
    public static final Image ICON_IMAGE = new Image(ICON_RESOURCE);

    public static final String BOOM_SOUND_RESOURCE = "/sounds/boom.mp3";
    public static final String MISSILE_SOUND_RESOURCE = "/sounds/missile.mp3";
    public static final Image BACKGROUND_IMAGE = new Image("images/back.jpg");

    public static final int MAX_BUTTON_WIDTH = 150;
    public static final int MAX_BUTTON_HEIGHT = 50;
    public static final int MIN_BUTTON_HEIGHT = 30;
    public static final Background IDLE_BUTTON_BACKGROUND = new Background(
            new BackgroundFill(
                    javafx.scene.paint.Color.rgb(100, 100, 100, 0.4),
                    CornerRadii.EMPTY,
                    javafx.geometry.Insets.EMPTY
            )
    );
    public static final Background ACTIVE_BUTTON_BACKGROUND = new Background(
            new BackgroundFill(
                    Color.rgb(50, 50, 50, 0.4),
                    CornerRadii.EMPTY,
                    Insets.EMPTY
            )
    );

    public static final AudioClip MISSILE_SOUND = new AudioClip(
            MvcGameConfig.class.getResource(MvcGameConfig.MISSILE_SOUND_RESOURCE).toExternalForm()
    );
    public static final AudioClip CANNON_SOUND = new AudioClip(
            MvcGameConfig.class.getResource(MvcGameConfig.BOOM_SOUND_RESOURCE).toExternalForm()
    );

    public static final Background GAME_BACKGROUND = new Background(
            new BackgroundFill(
                    new ImagePattern(
                            MvcGameConfig.BACKGROUND_IMAGE, 0, 0,
                            MAX_X,
                            MAX_Y,
                            false),
                    CornerRadii.EMPTY,
                    Insets.EMPTY
            ),
            new BackgroundFill(
                    Color.color(1.0, 1.0, 1.0, 0.4),
                    CornerRadii.EMPTY,
                    Insets.EMPTY
            )
    );
}