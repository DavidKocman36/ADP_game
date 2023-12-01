package cz.cvut.fit.niadp.mvcgame.view;

import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.niadp.mvcgame.controller.GameController;
import cz.cvut.fit.niadp.mvcgame.model.GameInfo;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;
import cz.cvut.fit.niadp.mvcgame.observer.IObserver;
import cz.cvut.fit.niadp.mvcgame.observer.aspects.Aspect;
import cz.cvut.fit.niadp.mvcgame.view.renderer.AbstractGraphicsRenderer;
import cz.cvut.fit.niadp.mvcgame.view.renderer.GraphicsRenderer;
import cz.cvut.fit.niadp.mvcgame.view.renderer.NullGraphicsRenderer;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.GameObjectsRenderer;

public class GameInfoView implements IObserver {
    private final IGameModel model;
    private final GameInfo gameInfo;
    private final GameController controller;
    private IGameGraphics gameGraphics;
    private final GameObjectsRenderer gameObjectsRenderer;

    private AbstractGraphicsRenderer graphicsRenderer;
    private final GraphicsRenderer graphr;
    private final NullGraphicsRenderer n_graphr;
    public GameInfoView(IGameModel model) {
        this.model = model;
        this.controller = new GameController(this.model);
        this.model.registerObserver(this, Aspect.UpdateInfoAspect);
        this.gameObjectsRenderer = new GameObjectsRenderer();
        this.gameInfo = this.model.getGameInfo();

        this.n_graphr = new NullGraphicsRenderer();
        this.graphr = new GraphicsRenderer();

        // set the abstract renderer based on the gr value
        this.graphicsRenderer = this.setRenderer();
    }

    public AbstractGraphicsRenderer setRenderer(){
        if(this.gameGraphics == null){
            return this.n_graphr;
        }
        return this.graphr;
    }

    public void setGraphicsContext(IGameGraphics gameGraphics) {
        this.gameGraphics = gameGraphics;
        this.graphicsRenderer = this.setRenderer();
        this.gameObjectsRenderer.setGraphicsContext(gameGraphics);
        graphicsRenderer.infoRender(this.gameGraphics ,model, gameObjectsRenderer);
    }

    @Override
    public void update() {
        graphicsRenderer.infoRender(this.gameGraphics, model, gameObjectsRenderer);
    }
}
