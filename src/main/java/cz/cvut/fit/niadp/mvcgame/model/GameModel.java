package cz.cvut.fit.niadp.mvcgame.model;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.GameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.GameObject;
import cz.cvut.fit.niadp.mvcgame.observer.IObservable;
import cz.cvut.fit.niadp.mvcgame.observer.IObserver;
import cz.cvut.fit.niadp.mvcgame.observer.aspects.Aspect;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.Sounds;

import java.util.*;
import java.util.stream.Stream;

public class GameModel implements IObservable {
    private final IGameObjectFactory gameObjectFactory;
    private final AbsCannon cannon;
    private final List<AbsMissile> missiles;
    private final Map<Aspect, Set<IObserver>> observers;
    private final Sounds sounds;
    public GameModel() {
        this.observers = new EnumMap<>(Aspect.class);
        gameObjectFactory = GameObjectFactory.getInstance(this);
        cannon = gameObjectFactory.createCannon();
        this.missiles = new ArrayList<>();
        this.sounds = new Sounds();

        Arrays.stream(Aspect.values()).forEach(value ->
                observers.put(value, new HashSet<>())
        );
    }

    public void update() {
        this.moveMissiles();
    }

    public void moveMissiles() {
        this.missiles.forEach(missile -> missile.move(new Vector(MvcGameConfig.MOVE_STEP, 0)));
        this.destroyMissiles();
        this.notifyObservers(Aspect.PositionChangedAspect);
    }

    private void destroyMissiles() {
        this.missiles.removeAll(
                this.missiles.stream().filter(missile -> missile.getPosition().getX() > MvcGameConfig.MAX_X).toList()
        );
    }


    public Position getCannonPos() {
        return this.cannon.getPosition();
    }

    public void moveCannonUp() {
        this.cannon.moveUp();
        this.notifyObservers(Aspect.PositionChangedAspect);
    }

    public void moveCannonDown() {
        this.cannon.moveDown();
        this.notifyObservers(Aspect.PositionChangedAspect);
    }

    public void cannonShoot() {
        this.missiles.add(this.cannon.shoot());
        this.notifyObservers(Aspect.PositionChangedAspect);

        //Playing the sounds
        this.cannon.acceptVisitor(sounds);
        this.missiles.get(this.missiles.size() - 1).acceptVisitor(sounds);
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
