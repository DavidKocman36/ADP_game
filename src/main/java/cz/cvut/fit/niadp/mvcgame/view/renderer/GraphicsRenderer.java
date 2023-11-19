package cz.cvut.fit.niadp.mvcgame.view.renderer;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.GameObjectsRenderer;
import javafx.scene.canvas.GraphicsContext;

public class GraphicsRenderer extends AbstractGraphicsRenderer {


    @Override
    public void render(GraphicsContext gr, GameModel model, GameObjectsRenderer gameObjectsRenderer) {
        gr.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);
        model.getGameObjects().forEach(gameObject -> gameObject.acceptObjectVisitor(gameObjectsRenderer));
    }
}
