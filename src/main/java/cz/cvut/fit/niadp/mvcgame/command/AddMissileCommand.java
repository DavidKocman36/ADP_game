package cz.cvut.fit.niadp.mvcgame.command;

import cz.cvut.fit.niadp.mvcgame.model.IGameModel;

public class AddMissileCommand extends AbstractGameCommand{

    public AddMissileCommand(IGameModel model) {
        this.subject = model;
    }
    @Override
    protected void execute() {
        this.subject.cannonAddMissile();
    }
}
