package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.ISoundsVisitor;
import javafx.scene.image.Image;

public class EnemyA extends AbsEnemy{
    public EnemyA(Position initPosition, Image image) {
        super(initPosition);
        this.position = initPosition;
        this.image = image;
    }
    public Image getImage(){
        return this.image;
    }

    // When enemy is hit -> change its image to killed
    // after a while set the image to enemyWithBlood
    public void setImage(Image image){
        this.image = image;
    }
    @Override
    public void acceptObjectVisitor(IGameObjectsVisitor visitor) {
        visitor.visitEnemy(this);
    }

    @Override
    public void acceptSoundsVisitor(ISoundsVisitor visitor) {

    }
}
