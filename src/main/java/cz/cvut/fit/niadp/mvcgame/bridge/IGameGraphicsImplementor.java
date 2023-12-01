package cz.cvut.fit.niadp.mvcgame.bridge;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;

public interface IGameGraphicsImplementor {
    void drawImage(String path, Position position);
    void drawText(String text, Position position);
    void drawLine(Position beginPosition, Position endPosition);
    void clear();
    void save();
    void restore();
    void rotateCannon(AbsCannon cannon);
}

