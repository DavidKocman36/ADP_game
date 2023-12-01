package cz.cvut.fit.niadp.mvcgame.bridge;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import javafx.scene.transform.Rotate;

public interface IGameGraphics {
    // This function returns the width and height of an image
    double[] drawImage(String path, Position position);
    void drawText(String text, Position position, int size);
    void drawRectangle(Position leftTop, Position rightBottom);
    void clear();
    void save();
    void restore();
    void rotateCannon(AbsCannon cannon);
}

