package cz.cvut.fit.niadp.mvcgame.view.renderer;

import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.niadp.mvcgame.model.GameInfo;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.GameObjectsRenderer;

public class GraphicsRenderer extends AbstractGraphicsRenderer {


    @Override
    public void render(IGameGraphics gameGraphics, IGameModel model, GameObjectsRenderer gameObjectsRenderer) {
        gameGraphics.clear();
        model.getGameObjects().forEach(gameObject -> gameObject.acceptObjectVisitor(gameObjectsRenderer));
        model.getEnemies().forEach(gameObject -> gameObject.acceptObjectVisitor(gameObjectsRenderer));
    }

    @Override
    public void infoRender(IGameGraphics gameGraphics, GameInfo info, GameObjectsRenderer gameObjectsRenderer) {
        gameGraphics.clear();
        info.acceptObjectVisitor(gameObjectsRenderer);
    }
}
