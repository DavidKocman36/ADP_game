package cz.cvut.fit.niadp;

import cz.cvut.fit.niadp.design.GameDesign;
import cz.cvut.fit.niadp.design.MainMenuDesign;
import cz.cvut.fit.niadp.mvcgame.bridge.GameGraphics;
import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.niadp.mvcgame.bridge.JavaFxGraphics;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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

        Pane holder = new Pane();
        holder.setBackground(new Background(
                new BackgroundFill(
                    Color.color(1.0, 1.0, 1.0, 0.4),
                    CornerRadii.EMPTY,
                    Insets.EMPTY
                ))
        );

        Canvas canvas = new Canvas( winWidth, winHeight );
        Canvas infoCanvas = new Canvas(200, winHeight);

        holder.getChildren().add(infoCanvas);
        root.getChildren().add(canvas);
        root.getChildren().add(holder);
        IGameGraphics gameGraphics = new GameGraphics(new JavaFxGraphics(canvas.getGraphicsContext2D()));
        IGameGraphics infoGraphics = new GameGraphics(new JavaFxGraphics(infoCanvas.getGraphicsContext2D()));

        theMvcGame.setGraphicsContext(gameGraphics);
        theMvcGame.setInfoGraphicsContext(infoGraphics);


        // the game-loop
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