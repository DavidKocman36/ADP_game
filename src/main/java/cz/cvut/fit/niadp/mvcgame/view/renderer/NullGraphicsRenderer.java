package cz.cvut.fit.niadp.mvcgame.view.renderer;

import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.GameObjectsRenderer;
public class NullGraphicsRenderer extends AbstractGraphicsRenderer {

    @Override
    public void render(IGameGraphics gameGraphics, IGameModel model, GameObjectsRenderer gameObjectsRenderer)
    {

    }
}
