package cz.cvut.fit.niadp.mvcgame.bridge;

import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsCannon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;

public class JavaFxGraphics implements  IGameGraphicsImplementor {
    private final GraphicsContext gr;
    public JavaFxGraphics(GraphicsContext gr) {
        this.gr = gr;
    }
    @Override
    public double[] drawImage(String path, Position position) {
        Image img = new Image(path);
        this.gr.drawImage(img, position.getX(), position.getY());
        return new double[]{img.getWidth(), img.getHeight()};
    }

    @Override
    public double[] drawImage(Image img, Position position) {
        this.gr.drawImage(img, position.getX(), position.getY());
        return new double[]{img.getWidth(), img.getHeight()};
    }
    @Override
    public void drawText(String text, Position position, int size) {
        this.gr.setFont(Font.font("Lucida Console", size));
        this.gr.fillText(text, position.getX(), position.getY());
    }
    @Override
    public void drawLine(Position beginPosition, Position endPosition) {
        this.gr.strokeLine(beginPosition.getX(), beginPosition.getY(), endPosition.getX(), endPosition.getY());
    }
    @Override
    public void clear() {
        this.gr.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);
    }

    @Override
    public void save() {
        gr.save();
    }

    @Override
    public void rotateCannon(AbsCannon cannon) {
        // Maybe redundant but needed for image size
        Image can = new Image(MvcGameConfig.CANNON_IMAGE_RESOURCE);
        Rotate r = new Rotate(cannon.getAngle()*57.2957795,
                cannon.getPosition().getX() + can.getWidth()/2,
                cannon.getPosition().getY() + can.getHeight()/2);

        gr.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        can = null;
    }

    @Override
    public void restore() {
        gr.restore();
    }
}

