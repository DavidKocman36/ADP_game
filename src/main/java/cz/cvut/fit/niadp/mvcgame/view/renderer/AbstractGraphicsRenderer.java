package cz.cvut.fit.niadp.mvcgame.view.renderer;

import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.niadp.mvcgame.model.GameInfo;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.GameObjectsRenderer;

public abstract class AbstractGraphicsRenderer {

    public abstract void render(IGameGraphics gameGraphics, IGameModel model, GameObjectsRenderer gameObjectsRenderer);

    public abstract void infoRender(IGameGraphics gameGraphics, IGameModel model, GameObjectsRenderer gameObjectsRenderer);
}
