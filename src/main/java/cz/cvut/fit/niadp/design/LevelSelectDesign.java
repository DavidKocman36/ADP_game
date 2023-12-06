package cz.cvut.fit.niadp.design;

import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.design.components.ButtonBuilder;
import cz.cvut.fit.niadp.design.components.LabelBuilder;
import cz.cvut.fit.niadp.mvcgame.MvcGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LevelSelectDesign {

    private static Scene mainMenuScene;

    public static void setMainMenuScene(Scene scene){
        mainMenuScene = scene;
    }

    public static Scene createLevelSelection(int winWidth, int winHeight, MvcGame game, Scene theScene, Stage stage){
        ButtonBuilder bBuilder = new ButtonBuilder();
        LabelBuilder lBuilder = new LabelBuilder();
        VBox sceneLayout = new VBox(10);
        HBox buttonLayout = new HBox(10);

        sceneLayout.setBackground(MvcGameConfig.GAME_BACKGROUND);

        Button firstLevel = bBuilder.setText("Level 1")
                .setMaxHeight(MvcGameConfig.MAX_BUTTON_HEIGHT)
                .setMaxWidth(MvcGameConfig.MAX_BUTTON_WIDTH)
                .setMinHeight(MvcGameConfig.MIN_BUTTON_HEIGHT)
                .setBackground(MvcGameConfig.IDLE_BUTTON_BACKGROUND)
                .setFont(16)
                .setAction(e -> {
                    game.selectLevel(1);
                    stage.setScene(theScene);
                })
                .build();
        firstLevel = bBuilder.setMouseEntered(firstLevel);

        Button secondLevel = bBuilder.setText("Level 2")
                .setMaxHeight(MvcGameConfig.MAX_BUTTON_HEIGHT)
                .setMaxWidth(MvcGameConfig.MAX_BUTTON_WIDTH)
                .setMinHeight(MvcGameConfig.MIN_BUTTON_HEIGHT)
                .setBackground(MvcGameConfig.IDLE_BUTTON_BACKGROUND)
                .setFont(16)
                .setAction(e -> {
                    game.selectLevel(2);
                    stage.setScene(theScene);
                })
                .build();
        secondLevel = bBuilder.setMouseEntered(secondLevel);

        Button thirdLevel = bBuilder.setText("Level 3")
                .setMaxHeight(MvcGameConfig.MAX_BUTTON_HEIGHT)
                .setMaxWidth(MvcGameConfig.MAX_BUTTON_WIDTH)
                .setMinHeight(MvcGameConfig.MIN_BUTTON_HEIGHT)
                .setBackground(MvcGameConfig.IDLE_BUTTON_BACKGROUND)
                .setFont(16)
                .setAction(e -> {
                    game.selectLevel(3);
                    stage.setScene(theScene);
                })
                .build();
        thirdLevel = bBuilder.setMouseEntered(thirdLevel);

        Button backButton = bBuilder.setText("Back")
                .setMaxHeight(MvcGameConfig.MAX_BUTTON_HEIGHT)
                .setMaxWidth(MvcGameConfig.MAX_BUTTON_WIDTH)
                .setMinHeight(MvcGameConfig.MIN_BUTTON_HEIGHT)
                .setBackground(MvcGameConfig.IDLE_BUTTON_BACKGROUND)
                .setFont(16)
                .setAction(e -> {
                    stage.setScene(mainMenuScene);
                })
                .build();
        backButton = bBuilder.setMouseEntered(backButton);

        Label levelsTitle = lBuilder.setText("Select a level")
                .setFont(Font.font("Lucida Console", FontWeight.BOLD,35))
                .build();


        buttonLayout.getChildren().addAll(firstLevel, secondLevel, thirdLevel);
        sceneLayout.getChildren().addAll(levelsTitle, buttonLayout, backButton);
        sceneLayout.setAlignment(Pos.CENTER);
        buttonLayout.setAlignment(Pos.CENTER);
        return new Scene(sceneLayout, winWidth, winHeight);
    }
}
