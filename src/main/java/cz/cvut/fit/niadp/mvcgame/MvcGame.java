package cz.cvut.fit.niadp.mvcgame;

import java.util.List;

import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.niadp.mvcgame.controller.GameController;
import cz.cvut.fit.niadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;
import cz.cvut.fit.niadp.mvcgame.proxy.GameModelProxy;
import cz.cvut.fit.niadp.mvcgame.view.GameInfoView;
import cz.cvut.fit.niadp.mvcgame.view.GameView;

public class MvcGame {


    private IGameModel model;
    private GameView view;
    private GameController controller;
    private GameInfoView gameInfoView;

    public void init() {
        this.model = new GameModelProxy(new GameModel());
        this.view = new GameView(model);
        this.gameInfoView = new GameInfoView(model);
        this.controller = this.view.getController();
        CareTaker.getInstance().setModel(this.model);
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        this.controller.processPressedKeys(pressedKeysCodes);
    }

    public void processUnpressedKeys(String code) {
        this.controller.processUnpressedKeys(code);
    }

    public String getWindowTitle() {
        return MvcGameConfig.GAME_TITLE;
    }

    public int getWindowWidth() {
        return MvcGameConfig.MAX_X;
    }

    public int getWindowHeight() {
        return  MvcGameConfig.MAX_Y;
    }

    public void setGraphicsContext(IGameGraphics gameGraphics) {
        this.view.setGraphicsContext(gameGraphics);
    }

    public void setInfoGraphicsContext(IGameGraphics gameGraphics) {
        this.gameInfoView.setGraphicsContext(gameGraphics);
    }

}