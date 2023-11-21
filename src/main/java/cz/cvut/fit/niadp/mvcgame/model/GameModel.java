package cz.cvut.fit.niadp.mvcgame.model;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.GameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.iterator.IIterator;
import cz.cvut.fit.niadp.mvcgame.iterator.repos.MovingStrategyIteratorRepository;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.GameObject;
import cz.cvut.fit.niadp.mvcgame.observer.IObservable;
import cz.cvut.fit.niadp.mvcgame.observer.IObserver;
import cz.cvut.fit.niadp.mvcgame.observer.aspects.Aspect;
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.Sounds;

import java.util.*;
import java.util.stream.Stream;

public class GameModel implements IObservable {
    private final IGameObjectFactory gameObjectFactory;
    private final AbsCannon cannon;
    private final List<AbsMissile> missiles;
    private final Map<Aspect, Set<IObserver>> observers;
    private final Sounds sounds;
    private IMovingStrategy movingStrategy;
    private final MovingStrategyIteratorRepository movingStrategyIteratorRepository;
    private final IIterator iterator;

    public GameModel() {
        this.observers = new EnumMap<>(Aspect.class);
        this.gameObjectFactory = GameObjectFactory.getInstance(this);
        this.sounds = new Sounds();
        this.cannon = gameObjectFactory.createCannon();
        this.missiles = new ArrayList<>();

        this.movingStrategyIteratorRepository = new MovingStrategyIteratorRepository();
        this.iterator = this.movingStrategyIteratorRepository.getIterator();
        this.movingStrategy = (IMovingStrategy) this.iterator.next();

        Arrays.stream(Aspect.values()).forEach(value ->
                observers.put(value, new HashSet<>())
        );
    }

    public Sounds getSounds(){
        return this.sounds;
    }

    public void update() {
        this.moveMissiles();
    }

    public void moveMissiles() {
        this.missiles.forEach(AbsMissile::move);
        this.destroyMissiles();
        this.notifyObservers(Aspect.PositionChangedAspect);
    }

    private void destroyMissiles() {
        this.missiles.removeAll(
                this.missiles.stream()
                        .filter(missile -> missile.getPosition().getX() > MvcGameConfig.MAX_X || missile.getPosition().getY() > MvcGameConfig.MAX_Y)
                        .toList()
        );
    }

    public Position getCannonPos() {
        return this.cannon.getPosition();
    }

    public void moveCannonUp() {
        if(this.getCannonPos().getY() - MvcGameConfig.MOVE_STEP > 0) {
            this.cannon.moveUp();
            this.notifyObservers(Aspect.PositionChangedAspect);
        }
    }

    public void moveCannonDown() {
        if(this.getCannonPos().getY() + MvcGameConfig.MOVE_STEP < (MvcGameConfig.MAX_Y * 0.82)) {
            this.cannon.moveDown();
            this.notifyObservers(Aspect.PositionChangedAspect);
        }
    }

    public void aimCannonUp() {
        this.cannon.aimUp();
        this.notifyObservers(Aspect.PositionChangedAspect);
    }
    public void aimCannonDown() {
        this.cannon.aimDown();
        this.notifyObservers(Aspect.PositionChangedAspect);
    }
    public void cannonPowerUp() {
        this.cannon.powerUp();
        this.notifyObservers(Aspect.PositionChangedAspect);
    }
    public void cannonPowerDown() {
        this.cannon.powerDown();
        this.notifyObservers(Aspect.PositionChangedAspect);
    }


    public void cannonShoot() {
        this.missiles.addAll(this.cannon.shoot());
        this.notifyObservers(Aspect.PositionChangedAspect);
    }

    public IMovingStrategy getMovingStrategy() {
        return this.movingStrategy;
    }

    public void toggleMovingStrategy() {
        this.movingStrategy = (IMovingStrategy) iterator.next();
    }

    public void toggleShootingMode() {
        this.cannon.toggleShootingMode();
        this.notifyObservers(Aspect.PositionChangedAspect);
    }

    public void cannonAddMissile() {
        this.cannon.addMissile();
    }

    public void cannonSubMissile() {
        this.cannon.subMissile();
    }

    private static class Memento {
        private int cannonPositionX;
        private int cannonPositionY;
        // game model snapshot (enemies, gameInfo, strategy, state)
    }

    public Object createMemento() {
        Memento gameModelSnapshot = new Memento();
        gameModelSnapshot.cannonPositionX = this.getCannonPos().getX();
        gameModelSnapshot.cannonPositionY = this.getCannonPos().getY();
        return gameModelSnapshot;
    }

    public void setMemento(Object memento) {
        Memento gameModelSnapshot = (Memento) memento;
        this.cannon.getPosition().setX(gameModelSnapshot.cannonPositionX);
        this.cannon.getPosition().setY(gameModelSnapshot.cannonPositionY);
    }

    @Override
    public void registerObserver(IObserver observer, Aspect interest) {
        this.observers.get(interest).add(observer);
    }

    @Override
    public void unregisterObserver(IObserver observer) {
        observers.forEach((key, value) ->
                observers.get(key).remove(observer)
        );
    }

    @Override
    public void notifyObservers(Aspect interest) {
        this.observers.get(interest).forEach(IObserver::update);
    }

    public List<AbsMissile> getMissiles() {
        return this.missiles;
    }

    public List<GameObject> getGameObjects() {
        return Stream.concat(Stream.of(this.cannon), this.missiles.stream()).toList();
    }

}
