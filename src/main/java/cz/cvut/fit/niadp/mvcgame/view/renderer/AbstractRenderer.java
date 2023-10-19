package cz.cvut.fit.niadp.mvcgame.view.renderer;

import cz.cvut.fit.niadp.mvcgame.view.GameView;
import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractRenderer {

    public abstract void render(GraphicsContext gr, GameView view);
}
