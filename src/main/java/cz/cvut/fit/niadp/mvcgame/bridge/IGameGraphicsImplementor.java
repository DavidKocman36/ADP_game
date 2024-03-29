package cz.cvut.fit.niadp.mvcgame.bridge;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsCannon;
import javafx.scene.image.Image;

public interface IGameGraphicsImplementor {
    // This function returns the width and height of an image
    double[] drawImage(String path, Position position);
    double[] drawImage(Image img, Position position);

    void drawText(String text, Position position, int size);
    void drawLine(Position beginPosition, Position endPosition);
    void clear();
    void save();
    void restore();
    void rotateCannon(AbsCannon cannon);
}

