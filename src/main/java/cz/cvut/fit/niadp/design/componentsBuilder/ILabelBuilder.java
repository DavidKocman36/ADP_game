package cz.cvut.fit.niadp.design.componentsBuilder;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public interface ILabelBuilder {
    void reset();
    ILabelBuilder setText(String text);
    ILabelBuilder setFont(Font font);
    Label build();
}
