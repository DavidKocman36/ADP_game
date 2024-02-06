package cz.cvut.fit.niadp.mvcgame.command;

import cz.cvut.fit.niadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;

public abstract class AbstractGameCommand {
    protected IGameModel subject;
    protected Object memento;
    protected abstract void execute();
    public void doExecute() {
        this.memento = this.subject.createMemento();
        this.execute();
    }
    public void unExecute() {
        this.subject.setMemento(this.memento);
    }

}
