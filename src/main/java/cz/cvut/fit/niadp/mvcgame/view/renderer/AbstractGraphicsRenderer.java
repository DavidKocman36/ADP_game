package cz.cvut.fit.niadp.mvcgame.view.renderer;

import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.GameObjectsRenderer;
import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractGraphicsRenderer {

    public abstract void render(GraphicsContext gr, GameModel model, GameObjectsRenderer gameObjectsRenderer);
}
