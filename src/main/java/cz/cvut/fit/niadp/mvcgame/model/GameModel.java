package cz.cvut.fit.niadp.mvcgame.model;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.Cannon;
import cz.cvut.fit.niadp.mvcgame.observer.IObservable;
import cz.cvut.fit.niadp.mvcgame.observer.IObserver;
import cz.cvut.fit.niadp.mvcgame.observer.aspects.Aspect;

import java.util.*;

public class GameModel implements IObservable {
    private final Cannon cannon;
    private final Map<Aspect, Set<IObserver>> observers;
    public GameModel() {
        this.cannon = new Cannon(new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y));
        this.observers = new EnumMap<>(Aspect.class);

        Arrays.stream(Aspect.values()).forEach(value ->
                observers.put(value, new HashSet<>())
        );
    }

    public void update() {
        // this.moveMissiles();
    }

    public Position getCannonPos() {
        return this.cannon.getPosition();
    }

    public void moveCannonUp() {
        this.cannon.moveUP();
        this.notifyObservers(Aspect.PositionChangedAspect);
    }

    public void moveCannonDown() {
        this.cannon.moveDown();
        this.notifyObservers(Aspect.PositionChangedAspect);
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
}
