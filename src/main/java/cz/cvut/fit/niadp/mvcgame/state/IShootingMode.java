package cz.cvut.fit.niadp.mvcgame.state;

import cz.cvut.fit.niadp.mvcgame.model.gameobjects.AbsCannon;

public interface IShootingMode {
    String getName();
    void shoot(AbsCannon cannon);

}
