package cz.cvut.fit.niadp.design.componentsBuilder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;

public interface IButtonBuilder {
    void reset();
    IButtonBuilder setText(String text);
    IButtonBuilder setMaxWidth(double value);
    IButtonBuilder setMinWidth(double value);
    IButtonBuilder setMinHeight(double value);
    IButtonBuilder setMaxHeight(double value);
    IButtonBuilder setBackground(Background background);
    IButtonBuilder setFont(double size);
    IButtonBuilder setAction(EventHandler<ActionEvent> event);
    Button build();
}
