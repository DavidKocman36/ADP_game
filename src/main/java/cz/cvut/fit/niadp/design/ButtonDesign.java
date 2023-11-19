package cz.cvut.fit.niadp.design;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ButtonDesign {
    private final static int MAX_WIDTH = 150;
    private final static int MAX_HEIGHT = 50;
    private final static int MIN_HEIGHT = 30;

    private final static Background IDLE_BACKGROUND = new Background(
            new BackgroundFill(
                    Color.rgb(100, 100, 100, 0.4),
                    CornerRadii.EMPTY,
                    Insets.EMPTY
            )
    );

    private final static Background ACTIVE_BACKGROUND = new Background(
            new BackgroundFill(
                    Color.rgb(50, 50, 50, 0.4),
                    CornerRadii.EMPTY,
                    Insets.EMPTY
            )
    );

    public static Button createButton(String text){
        Button b = new Button(text);
        b.setMaxWidth(MAX_WIDTH);
        b.setMaxHeight(MAX_HEIGHT);
        b.setMinHeight(MIN_HEIGHT);
        b.setBackground(IDLE_BACKGROUND);

        b.setOnMouseEntered(e -> {
            b.setBackground(ACTIVE_BACKGROUND);
        });
        b.setOnMouseExited(e -> {
            b.setBackground(IDLE_BACKGROUND);
        });
        b.setFont(Font.font(16));

        return b;
    }
}
