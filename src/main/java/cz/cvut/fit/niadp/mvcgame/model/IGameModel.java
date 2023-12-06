package cz.cvut.fit.niadp.mvcgame.model;

import cz.cvut.fit.niadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.AbsMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.abstractClasses.GameObject;
import cz.cvut.fit.niadp.mvcgame.observer.IObservable;
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.Sounds;

import java.util.List;
import java.util.Queue;

public interface IGameModel extends IObservable {
    void update();

    Position getCannonPos();

    GameInfo getGameInfo();

    void moveCannonUp();

    void moveCannonDown();

    void aimCannonUp();

    void aimCannonDown();

    void cannonPowerUp();

    void cannonPowerDown();

    void cannonShoot();

    List<AbsMissile> getMissiles();

    List<GameObject> getGameObjects();

    IMovingStrategy getMovingStrategy();

    void toggleMovingStrategy();

    void toggleShootingMode();

    Object createMemento();

    void setMemento(Object memento);

    void registerCommand(AbstractGameCommand command);

    void undoLastCommand();

    void cannonAddMissile();

    void cannonSubMissile();
    Sounds getSounds();

    List<AbsEnemy> getEnemies();
    List<AbsEnemy> getHitEnemies();
    AbsCannon getCannon();
    int getNumberOfFiredMissiles();
    int getScore();
    Queue<AbstractGameCommand> getUnexecutedCommands();
    void generateLevel(int level);
}

