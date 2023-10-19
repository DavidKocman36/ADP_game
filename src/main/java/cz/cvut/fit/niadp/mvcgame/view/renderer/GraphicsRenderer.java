package cz.cvut.fit.niadp.mvcgame.view.renderer;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.view.GameView;
import javafx.scene.canvas.GraphicsContext;

public class GraphicsRenderer extends AbstractRenderer {


    @Override
    public void render(GraphicsContext gr, GameView view) {
        gr.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);
        view.drawCannon();
    }
}
