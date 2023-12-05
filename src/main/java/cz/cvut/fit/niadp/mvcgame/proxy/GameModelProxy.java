package cz.cvut.fit.niadp.mvcgame.proxy;

import cz.cvut.fit.niadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.niadp.mvcgame.model.GameInfo;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.GameObject;
import cz.cvut.fit.niadp.mvcgame.observer.IObserver;
import cz.cvut.fit.niadp.mvcgame.observer.aspects.Aspect;
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.Sounds;

import java.util.List;
import java.util.Queue;

public class GameModelProxy implements IGameModel {
    private IGameModel subject;
    public GameModelProxy(IGameModel model) {
        this.subject = model;
    }

    @Override
    public void registerObserver(IObserver observer, Aspect interest) {
        this.subject.registerObserver(observer, interest);
    }

    @Override
    public void unregisterObserver(IObserver obs) {
        this.subject.unregisterObserver(obs);
    }

    @Override
    public void notifyObservers(Aspect interest) {
        this.subject.notifyObservers(interest);
    }
    @Override
    public void update() {
        this.subject.update();
    }
    @Override
    public Position getCannonPos() {
        return this.subject.getCannonPos();
    }

    @Override
    public GameInfo getGameInfo() {
        return this.subject.getGameInfo();
    }

    @Override
    public void moveCannonUp() {
        this.subject.moveCannonUp();
    }
    @Override
    public void moveCannonDown() {
        this.subject.moveCannonDown();
    }
    @Override
    public void aimCannonUp() {
        this.subject.aimCannonUp();
    }
    @Override
    public void aimCannonDown() {
        this.subject.aimCannonDown();
    }
    @Override
    public void cannonPowerUp() {
        this.subject.cannonPowerUp();
    }
    @Override
    public void cannonPowerDown() {
        this.subject.cannonPowerDown();
    }
    @Override
    public void cannonShoot() {
        this.subject.cannonShoot();
    }
    @Override
    public List<AbsMissile> getMissiles() {
        return this.subject.getMissiles();
    }
    @Override
    public List<GameObject> getGameObjects() {
        return this.subject.getGameObjects();
    }
    @Override
    public IMovingStrategy getMovingStrategy() {
        return this.subject.getMovingStrategy();
    }
    @Override
    public void toggleMovingStrategy() {
        this.subject.toggleMovingStrategy();
    }
    @Override
    public void toggleShootingMode() {
        this.subject.toggleShootingMode();
    }
    @Override
    public Object createMemento() {
        return this.subject.createMemento();
    }
    @Override
    public void setMemento(Object memento) {
        this.subject.setMemento(memento);
    }
    @Override
    public void registerCommand(AbstractGameCommand command) {
        this.subject.registerCommand(command);
    }
    @Override
    public void undoLastCommand() {
        this.subject.undoLastCommand();
    }

    @Override
    public void cannonAddMissile() {
        this.subject.cannonAddMissile();
    }

    @Override
    public void cannonSubMissile() {
        this.subject.cannonSubMissile();
    }

    @Override
    public Sounds getSounds() {
        return this.subject.getSounds();
    }

    @Override
    public List<AbsEnemy> getEnemies() {
        return this.subject.getEnemies();
    }

    @Override
    public List<AbsEnemy> getHitEnemies() {
        return this.subject.getHitEnemies();
    }

    @Override
    public AbsCannon getCannon() {
        return this.subject.getCannon();
    }

    @Override
    public int getNumberOfFiredMissiles() {
        return this.subject.getNumberOfFiredMissiles();
    }

    @Override
    public int getScore() {
        return this.subject.getScore();
    }

    @Override
    public Queue<AbstractGameCommand> getUnexecutedCommands() {
        return this.subject.getUnexecutedCommands();
    }
}

