package cz.cvut.fit.niadp.design;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainMenuDesign {

    public static Scene createMainMenu(Stage stage, Scene theScene, int winWidth, int winHeight){
        VBox menuLayout = new VBox(10);
        menuLayout.setBackground(new Background(
                new BackgroundFill(
                        new ImagePattern(
                                MvcGameConfig.BACKGROUND_IMAGE, 0, 0,
                                winWidth,
                                winHeight,
                                false),
                        CornerRadii.EMPTY,
                        Insets.EMPTY
                ),
                new BackgroundFill(
                        Color.color(1.0, 1.0, 1.0, 0.4),
                        CornerRadii.EMPTY,
                        Insets.EMPTY
                )
        ));

        Label menuName = new Label("The Furious Fowls");
        menuName.setFont(Font.font("Lucida Console", FontWeight.BOLD,35));

        Button buttonPlay  = ButtonDesign.createButton("Play");
        buttonPlay.setOnAction(e -> stage.setScene(theScene));

        Button buttonExit  = ButtonDesign.createButton("Exit");
        buttonExit.setOnAction(e -> System.exit(0));

        menuLayout.getChildren().addAll(menuName, buttonPlay, buttonExit);
        menuLayout.setAlignment(Pos.CENTER);

        return new Scene(menuLayout, winWidth, winHeight);
    }
}
