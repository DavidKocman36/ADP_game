package cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer;


import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import cz.cvut.fit.niadp.mvcgame.view.renderer.GraphicsRenderer;
import javafx.scene.transform.Rotate;

public class GameObjectsRenderer implements IGameObjectsVisitor {


    private GraphicsContext gr;

    public void setGraphicsContext(GraphicsContext gr) {
        this.gr = gr;
    }

    @Override
    public void visitCannon(AbsCannon cannon) {
        Image can = new Image(MvcGameConfig.CANNON_IMAGE_RESOURCE);
        gr.save(); // saves the current state on stack, including the current transform
        Rotate r = new Rotate(cannon.getAngle()*57.2957795,
                cannon.getPosition().getX() + can.getWidth()/2,
                cannon.getPosition().getY() + can.getHeight()/2);

        gr.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gr.drawImage(can, cannon.getPosition().getX(), cannon.getPosition().getY());
        gr.restore(); // back to original state (before rotation)
    }

    @Override
    public void visitMissile(AbsMissile missile) {
        this.gr.drawImage(
                new Image(MvcGameConfig.MISSILE_IMAGE_RESOURCE),
                missile.getPosition().getX(),
                missile.getPosition().getY()
        );
    }

}
