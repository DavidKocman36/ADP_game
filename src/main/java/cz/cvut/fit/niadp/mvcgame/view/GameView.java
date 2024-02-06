package cz.cvut.fit.niadp.mvcgame.view;

import cz.cvut.fit.niadp.mvcgame.controller.GameController;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;
import cz.cvut.fit.niadp.mvcgame.observer.IObserver;
import cz.cvut.fit.niadp.mvcgame.observer.aspects.Aspect;
import cz.cvut.fit.niadp.mvcgame.view.renderer.AbstractGraphicsRenderer;
import cz.cvut.fit.niadp.mvcgame.view.renderer.GraphicsRenderer;
import cz.cvut.fit.niadp.mvcgame.view.renderer.NullGraphicsRenderer;
import cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer.GameObjectsRenderer;
import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics;
public class GameView implements IObserver {

    private final IGameModel model;
    private final GameController controller;
    private IGameGraphics gameGraphics;
    private final GameObjectsRenderer gameObjectsRenderer;


    private AbstractGraphicsRenderer graphicsRenderer;
    private final GraphicsRenderer graphr;
    private final NullGraphicsRenderer n_graphr;

    public GameView(IGameModel model) {
        this.model = model;
        this.controller = new GameController(this.model);
        this.model.registerObserver(this, Aspect.PositionChangedAspect);
        this.gameObjectsRenderer = new GameObjectsRenderer();

        // create the classes beforehand so they will not be created multiple times
        // in case the context changes
        this.n_graphr = new NullGraphicsRenderer();
        this.graphr = new GraphicsRenderer();

        // set the abstract renderer based on the gr value
        this.graphicsRenderer = this.setRenderer();

    }

    public GameController getController() {
        return this.controller;
    }

    /*
    * This method returns a null object if the GraphicsContext is null.
    */
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
        graphicsRenderer.render(this.gameGraphics, model, gameObjectsRenderer);
    }


    @Override
    public void update() {
        graphicsRenderer.render(this.gameGraphics, model, gameObjectsRenderer);
    }
}
