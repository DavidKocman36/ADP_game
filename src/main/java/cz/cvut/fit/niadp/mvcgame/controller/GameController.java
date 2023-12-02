package cz.cvut.fit.niadp.mvcgame.controller;

import cz.cvut.fit.niadp.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.command.*;
import cz.cvut.fit.niadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.niadp.mvcgame.model.IGameModel;

import java.util.List;

public class GameController {
    private final IGameModel model;
    private boolean isPressedAimUp = false;
    private boolean isPressedAimDown = false;
    private boolean isPressedPowerUp = false;
    private boolean isPressedPowerDown = false;
    private boolean isPressedMovingStrategy = false;
    private boolean isPressedShootingMode = false;
    private boolean isPressedUndo = false;
    private boolean isPressedShoot = false;
    private boolean isPressedAddMissile = false;
    private boolean isPressedSubMissile = false;
    private boolean isPressedPrevStep = false;

    public GameController(IGameModel model) {
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
            case MvcGameConfig.UNDO_LAST_COMMAND_KEY -> isPressedUndo = false;
            case MvcGameConfig.ADD_MISSILE ->  isPressedAddMissile = false;
            case MvcGameConfig.REMOVE_MISSILE -> isPressedSubMissile = false;
            case MvcGameConfig.STEP_BACK_KEY -> isPressedPrevStep = false;
        }
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        for(String code : pressedKeysCodes) {
            switch (code) {
                case MvcGameConfig.UP_KEY -> this.model.registerCommand(new MoveCannonUpCommand(this.model));
                case MvcGameConfig.DOWN_KEY -> this.model.registerCommand(new MoveCannonDownCommand(this.model));
                case MvcGameConfig.SHOOT_KEY -> {
                    if(!this.isPressedShoot) {
                        this.model.registerCommand(new CannonShootCommand(this.model));
                        //CareTaker.getInstance().createMemento();
                        this.isPressedShoot = true;
                    }
                }
                case MvcGameConfig.AIM_UP_KEY -> {
                    if(!this.isPressedAimUp){
                        this.model.registerCommand(new AimCannonUpCommand(this.model));
                        this.isPressedAimUp = true;
                    }
                }
                case MvcGameConfig.AIM_DOWN_KEY -> {
                    if(!this.isPressedAimDown){
                        this.model.registerCommand(new AimCannonDownCommand(this.model));
                        this.isPressedAimDown = true;
                    }
                }
                case MvcGameConfig.POWER_UP_KEY -> {
                    if (!this.isPressedPowerUp) {
                        this.model.registerCommand(new PowerUpCommand(this.model));
                        this.isPressedPowerUp = true;
                    }
                }
                case MvcGameConfig.POWER_DOWN_KEY -> {
                    if (!this.isPressedPowerDown) {
                        this.model.registerCommand(new PowerDownCommand(this.model));
                        this.isPressedPowerDown = true;
                    }
                }
                case MvcGameConfig.MOVING_STRATEGY_KEY -> {
                    if (!this.isPressedMovingStrategy) {
                        this.model.registerCommand(new StrategyCommand(this.model));
                        this.isPressedMovingStrategy = true;
                    }
                }
                case MvcGameConfig.SHOOTING_MODE_KEY -> {
                    if(!this.isPressedShootingMode) {
                        this.model.registerCommand(new ShootingModeCommand(this.model));
                        this.isPressedShootingMode = true;
                    }
                }
                case MvcGameConfig.UNDO_LAST_COMMAND_KEY -> {
                    if(!this.isPressedUndo) {
                        this.model.undoLastCommand();
                        this.isPressedUndo = true;
                    }
                }
                case MvcGameConfig.ADD_MISSILE -> {
                    if(!this.isPressedAddMissile){
                        this.model.registerCommand(new AddMissileCommand(this.model));
                        this.isPressedAddMissile = true;
                    }
                }
                case MvcGameConfig.REMOVE_MISSILE -> {
                    if(!this.isPressedSubMissile){
                        this.model.registerCommand(new SubMissileCommand(this.model));
                        this.isPressedSubMissile = true;
                    }
                }
                case MvcGameConfig.STEP_BACK_KEY->{
                    if(!this.isPressedPrevStep){
                        //CareTaker.getInstance().setMemento();
                        this.isPressedPrevStep = true;
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