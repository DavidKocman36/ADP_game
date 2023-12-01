package cz.cvut.fit.niadp.mvcgame.bridge;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;

public class GameGraphics implements IGameGraphics {
    private final IGameGraphicsImplementor implementor;
    public GameGraphics(IGameGraphicsImplementor implementor) {
        this.implementor = implementor;
    }
    @Override
    public double[] drawImage(String path, Position position) {
        return this.implementor.drawImage(path, position);
    }
    @Override
    public void drawText(String text, Position position, int size) {
        this.implementor.drawText(text, position, size);
    }
    @Override
    public void drawRectangle(Position leftTop, Position rightBottom) {
        this.implementor.drawLine(leftTop, new Position(rightBottom.getX(), leftTop.getY()));
        this.implementor.drawLine(new Position(rightBottom.getX(), leftTop.getY()), rightBottom);
        this.implementor.drawLine(rightBottom, new Position(leftTop.getX(), rightBottom.getY()));
        this.implementor.drawLine(new Position(leftTop.getX(), rightBottom.getY()), leftTop);
    }
    @Override
    public void clear() {
        this.implementor.clear();
    }

    @Override
    public void save() {
        this.implementor.save();
    }

    @Override
    public void rotateCannon(AbsCannon cannon) {
        this.implementor.rotateCannon(cannon);
    }

    @Override
    public void restore() {
        this.implementor.restore();
    }
}

