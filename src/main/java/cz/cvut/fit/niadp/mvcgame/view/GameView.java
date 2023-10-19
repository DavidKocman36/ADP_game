package cz.cvut.fit.niadp.mvcgame.view;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.controller.GameController;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.observer.IObserver;
import cz.cvut.fit.niadp.mvcgame.observer.aspects.Aspect;
import cz.cvut.fit.niadp.mvcgame.view.renderer.AbstractRenderer;
import cz.cvut.fit.niadp.mvcgame.view.renderer.GraphicsRenderer;
import cz.cvut.fit.niadp.mvcgame.view.renderer.NullGraphicsRenderer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView implements IObserver {

    private final GameModel model;
    private final GameController controller;
    private GraphicsContext gr;

    private AbstractRenderer renderer;

    private final GraphicsRenderer graphr;
    private final NullGraphicsRenderer n_graphr;

    public GameView(GameModel model) {
        this.model = model;
        this.controller = new GameController(this.model);
        this.model.registerObserver(this, Aspect.PositionChangedAspect);

        // create the classes beforehand so they will not be created multiple times
        // in case the context changes
        this.n_graphr = new NullGraphicsRenderer();
        this.graphr = new GraphicsRenderer();

        // set the abstract renderer based on the gr value
        this.renderer = this.setRenderer();

    }

    public GameController getController() {
        return this.controller;
    }

    /*
    * This method returns a null object if the GraphicsContext is null.
    */
    public AbstractRenderer setRenderer(){
        if(this.gr == null){
            return this.n_graphr;
        }
        return this.graphr;
    }

    public void drawCannon() {
        Position cannonPosition = this.model.getCannonPos();
        this.gr.drawImage(new Image(MvcGameConfig.CANNON_IMAGE_RESOURCE), cannonPosition.getX(), cannonPosition.getY());
    }

    public void setGraphicsContext(GraphicsContext gr) {
        this.gr = gr;
        renderer = this.setRenderer();
        renderer.render(gr, this);
    }

    @Override
    public void update() {
        renderer.render(gr, this);
    }
}
