package cz.cvut.fit.niadp.mvcgame.model.gameobjects;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.IGameObjectsVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.ISoundsVisitor;

public class EnemyA extends AbsEnemy{
    public EnemyA(Position initPosition, String image) {
        super(initPosition);
        this.position = initPosition;
        this.image = image;
    }
    public String getImage(){
        return this.image;
    }

    // When enemy is hit -> change its image to killed
    // after a while set the image to enemyWithBlood
    public void setImage(String image){
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
