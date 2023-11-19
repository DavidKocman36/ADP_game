package cz.cvut.fit.niadp.mvcgame.iterator.repos;

import cz.cvut.fit.niadp.mvcgame.iterator.IContainer;
import cz.cvut.fit.niadp.mvcgame.iterator.IIterator;
import cz.cvut.fit.niadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.niadp.mvcgame.state.DynamicShootingMode;
import cz.cvut.fit.niadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.niadp.mvcgame.state.SingleShootingMode;

import java.util.Arrays;
import java.util.List;

public class ShootingModeIteratorRepository implements IContainer {
    public final List<IShootingMode> shootingModes = Arrays.asList(
            new SingleShootingMode(),
            new DoubleShootingMode(),
            new DynamicShootingMode()
    );
    @Override
    public IIterator getIterator() {
        return new ShootingModeIterator();
    }
    private class ShootingModeIterator implements IIterator{

        int index;
        @Override
        public boolean hasNext() {
            return index < shootingModes.size();
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return shootingModes.get(index++);
            }
            else {
                index = 0;
                return shootingModes.get(index++);
            }
        }
    }
}
