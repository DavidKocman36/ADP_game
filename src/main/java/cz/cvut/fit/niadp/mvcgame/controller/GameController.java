package cz.cvut.fit.niadp.mvcgame.controller;

import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;

import java.util.List;

public class GameController {
    private final GameModel model;
    private boolean isPressedAimUp = false;
    private boolean isPressedAimDown = false;
    private boolean isPressedPowerUp = false;
    private boolean isPressedPowerDown = false;
    private boolean isPressedMovingStrategy = false;
    private boolean isPressedShootingMode = false;
    private boolean isPressedStore = false;
    private boolean isPressedRestore = false;
    private boolean isPressedShoot = false;
    private boolean isPressedAddMissile = false;
    private boolean isPressedSubMissile = false;

    public GameController(GameModel model) {
        this.model = model;
    }

    public void processUnpressedKeys(String code){
        switch (code){
            case MvcGameConfig.SHOOT_KEY -> isPressedShoot = false;
            case MvcGameConfig.AIM_UP_KEY -> isPressedAimUp = false;
            case MvcGameConfig.AIM_DOWN_KEY -> isPressedAimDown = false;
            case MvcGameConfig.POWER_UP_KEY -> isPressedPowerUp = false;
            case MvcGameConfig.POWER_DOWN_KEY -> isPressedPowerDown = false;
            case MvcGameConfig.SHOOTING_MODE_KEY -> isPressedShootingMode = false;
            case MvcGameConfig.MOVING_STRATEGY_KEY -> isPressedMovingStrategy = false;
            case MvcGameConfig.STORE_SNAPSHOT_KEY -> isPressedStore = false;
            case MvcGameConfig.RESTORE_SNAPSHOT_KEY -> isPressedRestore = false;
            case MvcGameConfig.ADD_MISSILE ->  isPressedAddMissile = false;
            case MvcGameConfig.REMOVE_MISSILE -> isPressedSubMissile = false;
        }
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        for(String code : pressedKeysCodes) {
            switch (code) {
                case MvcGameConfig.UP_KEY -> this.model.moveCannonUp();
                case MvcGameConfig.DOWN_KEY -> this.model.moveCannonDown();
                case MvcGameConfig.SHOOT_KEY -> {
                    if(!this.isPressedShoot) {
                        this.model.cannonShoot();
                        this.isPressedShoot = true;
                    }
                }
                case MvcGameConfig.AIM_UP_KEY -> {
                    if(!this.isPressedAimUp){
                        this.model.aimCannonUp();
                        this.isPressedAimUp = true;
                    }
                }
                case MvcGameConfig.AIM_DOWN_KEY -> {
                    if(!this.isPressedAimDown){
                        this.model.aimCannonDown();
                        this.isPressedAimDown = true;
                    }
                }
                case MvcGameConfig.POWER_UP_KEY -> {
                    if (!this.isPressedPowerUp) {
                        this.model.cannonPowerUp();
                        this.isPressedPowerUp = true;
                    }
                }
                case MvcGameConfig.POWER_DOWN_KEY -> {
                    if (!this.isPressedPowerDown) {
                        this.model.cannonPowerDown();
                        this.isPressedPowerDown = true;
                    }
                }
                case MvcGameConfig.MOVING_STRATEGY_KEY -> {
                    if (!this.isPressedMovingStrategy) {
                        this.model.toggleMovingStrategy();
                        this.isPressedMovingStrategy = true;
                    }
                }
                case MvcGameConfig.SHOOTING_MODE_KEY -> {
                    if(!this.isPressedShootingMode) {
                        this.model.toggleShootingMode();
                        this.isPressedShootingMode = true;
                    }
                }
                case MvcGameConfig.STORE_SNAPSHOT_KEY -> {
                    if(!this.isPressedStore) {
                        CareTaker.getInstance().createMemento();
                        this.isPressedStore = true;
                    }
                }
                case MvcGameConfig.RESTORE_SNAPSHOT_KEY -> {
                    if(!this.isPressedRestore) {
                        CareTaker.getInstance().setMemento();
                        this.isPressedRestore = true;
                    }
                }
                case MvcGameConfig.ADD_MISSILE -> {
                    if(!this.isPressedAddMissile){
                        this.model.cannonAddMissile();
                        this.isPressedAddMissile = true;
                    }
                }
                case MvcGameConfig.REMOVE_MISSILE -> {
                    if(!this.isPressedSubMissile){
                        this.model.cannonSubMissile();
                        this.isPressedSubMissile = true;
                    }
                }
                case MvcGameConfig.EXIT_KEY -> System.exit(0);
                default -> {
                }
                //nothing
            }

        }
        this.model.update();
    }
}


