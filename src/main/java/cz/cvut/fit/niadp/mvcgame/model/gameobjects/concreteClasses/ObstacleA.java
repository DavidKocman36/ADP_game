package cz.cvut.fit.niadp.mvcgame.model.gameobjects.concreteClasses;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsObstacle;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.ISoundsVisitor;
import javafx.scene.image.Image;

public class ObstacleA extends AbsObstacle {

    public ObstacleA(Position position, Image image) {
        this.position = position;
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    @Override
    public void acceptObjectVisitor(IGameObjectsVisitor visitor) {
        visitor.visitObstacle(this);
    }

    @Override
    public void acceptSoundsVisitor(ISoundsVisitor visitor) {

    }
}
