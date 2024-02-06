package cz.cvut.fit.niadp.design.components;

import cz.cvut.fit.niadp.design.componentsBuilder.IButtonBuilder;
import cz.cvut.fit.niadp.config.MvcGameConfig;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class ButtonBuilder implements IButtonBuilder {
    private Button button;

    public ButtonBuilder(){
        this.reset();
    }

    @Override
    public IButtonBuilder setText(String text){
        this.button.setText(text);
        return this;
    }

    @Override
    public IButtonBuilder setMaxWidth(double value){
        this.button.setMaxWidth(value);
        return this;
    }

    @Override
    public IButtonBuilder setMinWidth(double value){
        this.button.setMinWidth(value);
        return this;
    }

    @Override
    public IButtonBuilder setMinHeight(double value){
        this.button.setMinHeight(value);
        return this;
    }

    @Override
    public IButtonBuilder setMaxHeight(double value){
        this.button.setMaxHeight(value);
        return this;
    }

    @Override
    public IButtonBuilder setBackground(Background background){
        this.button.setBackground(background);
        return this;
    }

    @Override
    public IButtonBuilder setFont(double size){
        this.button.setFont(Font.font(size));
        return this;
    }

    @Override
    public IButtonBuilder setAction(EventHandler<ActionEvent> event) {
        this.button.setOnAction(event);
        return this;
    }

    @Override
    public void reset() {
        this.button = new Button();
    }

    @Override
    public Button build() {
        Button product = this.button;
        this.reset();
        return product;
    }

    // complementary function to set the onHover method
    public Button setMouseEntered(Button b) {
        b.setOnMouseEntered(e -> b.setBackground(MvcGameConfig.ACTIVE_BUTTON_BACKGROUND));
        b.setOnMouseExited(e -> b.setBackground(MvcGameConfig.IDLE_BUTTON_BACKGROUND));
        return b;
    }
}
