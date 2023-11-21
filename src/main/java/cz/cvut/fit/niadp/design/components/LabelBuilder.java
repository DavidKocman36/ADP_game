package cz.cvut.fit.niadp.design.components;

import cz.cvut.fit.niadp.design.componentsBuilder.ILabelBuilder;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelBuilder implements ILabelBuilder {
    private Label label;

    public LabelBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.label = new Label();
    }

    @Override
    public ILabelBuilder setText(String text) {
        this.label.setText(text);
        return this;
    }

    @Override
    public ILabelBuilder setFont(Font font) {
        this.label.setFont(font);
        return this;
    }

    @Override
    public Label build() {
        Label product = this.label;
        this.reset();
        return product;
    }
}
