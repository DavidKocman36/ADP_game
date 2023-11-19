package cz.cvut.fit.niadp;

import cz.cvut.fit.niadp.design.GameDesign;
import cz.cvut.fit.niadp.design.MainMenuDesign;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import java.util.ArrayList;

import cz.cvut.fit.niadp.mvcgame.MvcGame;

public class MvcGameJavaFxLauncher extends Application {

    private static final MvcGame theMvcGame = new MvcGame();

    @Override
    public void init() {
        theMvcGame.init();
    }

    @Override
    public void start(Stage stage) throws InterruptedException {
        String winTitle = theMvcGame.getWindowTitle();
        int winWidth = theMvcGame.getWindowWidth();
        int winHeight = theMvcGame.getWindowHeight();
        ArrayList<String> pressedKeysCodes = new ArrayList<>();
        stage.setTitle( winTitle );

        Group root = new Group();
        Scene gameScene = GameDesign.createGameView(root, pressedKeysCodes, theMvcGame);

        Scene mainMenuScene = MainMenuDesign.createMainMenu(stage, gameScene, winWidth, winHeight);
        stage.setScene( mainMenuScene );

        Canvas canvas = new Canvas( winWidth, winHeight );
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // the game-loop
        theMvcGame.setGraphicsContext(gc);
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                theMvcGame.processPressedKeys(pressedKeysCodes);
            }
        }.start();
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}