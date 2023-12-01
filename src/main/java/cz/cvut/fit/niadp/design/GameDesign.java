package cz.cvut.fit.niadp.design;

import cz.cvut.fit.niadp.mvcgame.MvcGame;
import cz.cvut.fit.niadp.config.MvcGameConfig;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;

import java.util.List;

public class GameDesign {

    public static Scene createGameView(Group root, List<String> pressedKeysCodes, MvcGame theMvcGame){
        Scene theScene = new Scene( root );

        theScene.setFill(new ImagePattern(MvcGameConfig.BACKGROUND_IMAGE));

        theScene.setOnKeyPressed(
                e -> {
                    String code = e.getCode().toString();
                    // only add once... prevent duplicates
                    if (!pressedKeysCodes.contains(code))
                        pressedKeysCodes.add(code);
                }
        );
        theScene.setOnKeyReleased(
                e -> {
                    String code = e.getCode().toString();
                    pressedKeysCodes.remove( code );
                    theMvcGame.processUnpressedKeys(code);
                }
        );
        return theScene;
    }
}
