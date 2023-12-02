package cz.cvut.fit.niadp.mvcgame.command;

import cz.cvut.fit.niadp.mvcgame.model.IGameModel;

public class ShootingModeCommand extends AbstractGameCommand{
    public ShootingModeCommand(IGameModel model){
        this.subject = model;
    }

    @Override
    protected void execute() {
        this.subject.getCannon().toggleShootingMode();
    }

    @Override
    public void doExecute() {
        this.execute();
    }
}
