package cz.cvut.fit.niadp.mvcgame.model;

import cz.cvut.fit.niadp.mvcgame.abstractfactory.GameObjectFactory;
import cz.cvut.fit.niadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.niadp.mvcgame.iterator.IIterator;
import cz.cvut.fit.niadp.mvcgame.iterator.repos.MovingStrategyIteratorRepository;
import cz.cvut.fit.niadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.niadp.mvcgame.model.gameobjects.*;
import cz.cvut.fit.niadp.mvcgame.observer.IObserver;
import cz.cvut.fit.niadp.mvcgame.observer.aspects.Aspect;
import cz.cvut.fit.niadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.visitor.sounds.Sounds;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.*;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import java.util.stream.Stream;

public class GameModel implements IGameModel {
    private final IGameObjectFactory gameObjectFactory;
    private GameInfo gameInfo;
    private final AbsCannon cannon;
    private final List<AbsMissile> missiles;
    private final Map<Aspect, Set<IObserver>> observers;
    private final Sounds sounds;
    private IMovingStrategy movingStrategy;
    private final MovingStrategyIteratorRepository movingStrategyIteratorRepository;
    private final IIterator iterator;
    private final Queue<AbstractGameCommand> unexecutedCommands;
    private final Stack<AbstractGameCommand> executedCommands;
    private List<AbsEnemy> enemies;
    private List<AbsEnemy> hitEnemies;
    private int numberOfFiredMissiles;
    private int score;


    public GameModel() {
        this.observers = new EnumMap<>(Aspect.class);
        this.gameObjectFactory = GameObjectFactory.getInstance(this);
        this.sounds = new Sounds();
        this.cannon = gameObjectFactory.createCannon();
        this.missiles = new ArrayList<>();
        this.enemies = gameObjectFactory.createEnemies();
        this.hitEnemies = new ArrayList<>();
        this.gameInfo = new GameInfo(this);
        this.numberOfFiredMissiles = 0;
        this.score = 0;

        this.movingStrategyIteratorRepository = new MovingStrategyIteratorRepository();
        this.iterator = this.movingStrategyIteratorRepository.getIterator();
        this.movingStrategy = (IMovingStrategy) this.iterator.next();

        this.unexecutedCommands = new LinkedBlockingQueue<>();
        this.executedCommands = new Stack<>();

        // The snapshot at the beginning
        //CareTaker.getInstance().createMemento();

        Arrays.stream(Aspect.values()).forEach(value ->
                observers.put(value, new HashSet<>())
        );
    }

    public Sounds getSounds(){
        return this.sounds;
    }

    public void update() {
        this.executeCommands();
        this.checkEnemies();
        this.moveMissiles();
    }

    public void moveMissiles() {
        this.missiles.forEach(AbsMissile::move);
        this.destroyMissiles();
        this.checkCollision();
        this.notifyObservers(Aspect.PositionChangedAspect);
    }

    private void checkCollision(){
        for(AbsMissile missile : this.missiles){
            Ellipse2D.Double e1 = new Ellipse2D.Double(missile.getPosition().getX(),
                    missile.getPosition().getY(),
                    (int)missile.getWidth(),
                    (int)missile.getHeight());
            Rectangle e1Bounds = e1.getBounds();

            for(AbsEnemy enemy : this.enemies){
                Ellipse2D.Double e2 = new Ellipse2D.Double(enemy.getPosition().getX(),
                        enemy.getPosition().getY(),
                        (int)enemy.getWidth(),
                        (int)enemy.getHeight());
                Rectangle e2Bounds = e2.getBounds();

                if(e1Bounds.intersects(e2Bounds) && !this.hitEnemies.contains(enemy)){
                    enemy.setImage(MvcGameConfig.HIT_ENEMY_IMAGE_RESOURCE);
                    enemy.setCollided(enemy.getAge());
                    this.hitEnemies.add(enemy);
                    int range = (int)Math.sqrt( Math.pow(enemy.getPosition().getX() - this.cannon.getPosition().getX(), 2) + Math.pow(enemy.getPosition().getY() - this.cannon.getPosition().getY(), 2));
                    this.score += 1000 + range / this.cannon.getPower();
                    this.notifyObservers(Aspect.UpdateInfoAspect);
                }
            }
        }
    }

    private void checkEnemies(){
        for(AbsEnemy e : this.hitEnemies){
            if(e.getAge() >= e.getCollided() + 5000){
                e.setImage(MvcGameConfig.BLOODY_ENEMY_IMAGE_RESOURCE);
            }
        }
    }

    private void destroyMissiles() {
        this.missiles.removeAll(
                this.missiles.stream()
                        .filter(missile -> missile.getPosition().getX() > MvcGameConfig.MAX_X ||
                                missile.getPosition().getY() > MvcGameConfig.MAX_Y ||
                                missile.getAge() > 20000)
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
        this.notifyObservers(Aspect.UpdateInfoAspect);
    }
    public void aimCannonDown() {
        this.cannon.aimDown();
        this.notifyObservers(Aspect.PositionChangedAspect);
        this.notifyObservers(Aspect.UpdateInfoAspect);
    }
    public void cannonPowerUp() {
        this.cannon.powerUp();
        this.notifyObservers(Aspect.PositionChangedAspect);
        this.notifyObservers(Aspect.UpdateInfoAspect);
    }
    public void cannonPowerDown() {
        this.cannon.powerDown();
        this.notifyObservers(Aspect.PositionChangedAspect);
        this.notifyObservers(Aspect.UpdateInfoAspect);
    }

    public void cannonShoot() {
        List<AbsMissile> batch = this.cannon.shoot();
        this.numberOfFiredMissiles += batch.size();
        this.missiles.addAll(batch);
        this.notifyObservers(Aspect.PositionChangedAspect);
        this.notifyObservers(Aspect.UpdateInfoAspect);
    }

    public int getNumberOfFiredMissiles(){
        return this.numberOfFiredMissiles;
    }

    public IMovingStrategy getMovingStrategy() {
        return this.movingStrategy;
    }

    public void toggleMovingStrategy() {
        this.movingStrategy = (IMovingStrategy) iterator.next();
        this.notifyObservers(Aspect.UpdateInfoAspect);
    }

    public void toggleShootingMode() {
        this.cannon.toggleShootingMode();
        this.notifyObservers(Aspect.PositionChangedAspect);
        this.notifyObservers(Aspect.UpdateInfoAspect);
    }

    public void cannonAddMissile() {
        this.cannon.addMissile();
        this.notifyObservers(Aspect.UpdateInfoAspect);
    }

    public void cannonSubMissile() {
        this.cannon.subMissile();
        this.notifyObservers(Aspect.UpdateInfoAspect);
    }
    private void executeCommands() {
        while(!this.unexecutedCommands.isEmpty()) {
            AbstractGameCommand command = this.unexecutedCommands.poll();
            command.doExecute();
            this.executedCommands.add(command);
        }
    }

    public GameInfo getGameInfo(){
        return this.gameInfo;
    }

    private static class Memento {
        private int cannonPositionY;
        private GameInfo gameInfo;
        private List<AbsEnemy> enemies;
        private List<AbsEnemy> hitEnemies = new ArrayList<>();
        private int numOfHitEnemies = 0;
        private int firedMissiles;
        private int score;

        private double angle;
        private int power;
        private int numOfMissiles;
    }

    public Object createMemento() {
        Memento gameModelSnapshot = new Memento();
        gameModelSnapshot.cannonPositionY = this.getCannonPos().getY();
        gameModelSnapshot.gameInfo = this.gameInfo;

        gameModelSnapshot.enemies = new ArrayList<>(this.enemies.size());
        for(AbsEnemy e : this.enemies) {
            AbsEnemy en = new EnemyA(e.getPosition(), e.getImage());
            gameModelSnapshot.enemies.add(en);
        }

        gameModelSnapshot.numOfHitEnemies = this.hitEnemies.size();
        gameModelSnapshot.hitEnemies = new ArrayList<>(this.enemies.size());
        for(AbsEnemy e : this.hitEnemies){
            AbsEnemy en = new EnemyA(e.getPosition(), e.getImage());
            gameModelSnapshot.hitEnemies.add(en);
        }

        gameModelSnapshot.firedMissiles = this.numberOfFiredMissiles;
        gameModelSnapshot.score = this.score;
        gameModelSnapshot.angle = this.cannon.getAngle();
        gameModelSnapshot.power = this.cannon.getPower();
        gameModelSnapshot.numOfMissiles = this.getCannon().getNumberOfMissiles();

        return gameModelSnapshot;
    }

    public void setMemento(Object memento) {
        Memento gameModelSnapshot = (Memento) memento;
        if(gameModelSnapshot != null) {
            this.cannon.getPosition().setY(gameModelSnapshot.cannonPositionY);
            this.gameInfo = gameModelSnapshot.gameInfo;
            this.enemies.clear();
            this.enemies.addAll(gameModelSnapshot.enemies);
            this.hitEnemies.clear();
            this.hitEnemies.addAll(gameModelSnapshot.hitEnemies);
            this.numberOfFiredMissiles = gameModelSnapshot.firedMissiles;
            this.score = gameModelSnapshot.score;
            this.cannon.setAngle(gameModelSnapshot.angle);
            this.cannon.setPower(gameModelSnapshot.power);
            this.cannon.setNumberOfMissiles(gameModelSnapshot.numOfMissiles);
        }
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

    @Override
    public void registerCommand(AbstractGameCommand command) {
        this.unexecutedCommands.add(command);
    }
    @Override
    public void undoLastCommand() {
        if (!this.executedCommands.isEmpty()) {
            this.executedCommands.pop().unExecute();
            this.notifyObservers(Aspect.PositionChangedAspect);
            this.notifyObservers(Aspect.UpdateInfoAspect);
        }
    }
    public List<AbsMissile> getMissiles() {
        return this.missiles;
    }
    public List<GameObject> getGameObjects() {
        return Stream.concat(Stream.of(this.cannon), this.missiles.stream()).toList();
    }
    public List<AbsEnemy> getEnemies(){
        return this.enemies;
    }
    public List<AbsEnemy> getHitEnemies(){
        return this.hitEnemies;
    }
    public AbsCannon getCannon(){return this.cannon;}
    public int getScore(){return this.score;}
}