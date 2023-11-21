package cz.cvut.fit.niadp.design;

import cz.cvut.fit.niadp.design.components.ButtonBuilder;
import cz.cvut.fit.niadp.design.components.LabelBuilder;
import cz.cvut.fit.niadp.config.MvcGameConfig;
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
        ButtonBuilder bBuilder = new ButtonBuilder();
        LabelBuilder lBuilder = new LabelBuilder();
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

        Label menuName = lBuilder.setText("The Furious Fowls")
                .setFont(Font.font("Lucida Console", FontWeight.BOLD,35))
                .build();

        Button buttonPlay = bBuilder.setText("Play")
                .setMaxHeight(MvcGameConfig.MAX_BUTTON_HEIGHT)
                .setMaxWidth(MvcGameConfig.MAX_BUTTON_WIDTH)
                .setMinHeight(MvcGameConfig.MIN_BUTTON_HEIGHT)
                .setBackground(MvcGameConfig.IDLE_BUTTON_BACKGROUND)
                .setFont(16)
                .setAction(e -> stage.setScene(theScene))
                .build();
        buttonPlay = bBuilder.setMouseEntered(buttonPlay);

        Button buttonExit = bBuilder.setText("Exit")
                .setMaxHeight(MvcGameConfig.MAX_BUTTON_HEIGHT)
                .setMaxWidth(MvcGameConfig.MAX_BUTTON_WIDTH)
                .setMinHeight(MvcGameConfig.MIN_BUTTON_HEIGHT)
                .setBackground(MvcGameConfig.IDLE_BUTTON_BACKGROUND)
                .setFont(16)
                .setAction(e -> System.exit(0))
                .build();
        buttonExit = bBuilder.setMouseEntered(buttonExit);

        menuLayout.getChildren().addAll(menuName, buttonPlay, buttonExit);
        menuLayout.setAlignment(Pos.CENTER);

        return new Scene(menuLayout, winWidth, winHeight);
    }
}
