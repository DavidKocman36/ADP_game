package cz.cvut.fit.niadp.mvcgame.iterator.repos;

import cz.cvut.fit.niadp.mvcgame.iterator.IContainer;
import cz.cvut.fit.niadp.mvcgame.iterator.IIterator;
import cz.cvut.fit.niadp.mvcgame.strategy.*;

import java.util.Arrays;
import java.util.List;

public class MovingStrategyIteratorRepository implements IContainer {
    public final List<IMovingStrategy> movingStrategies = Arrays.asList(
            new RealisticMovingStrategy(),
            new SimpleMovingStrategy(),
            new RandomMovingStrategy(),
            new SinusMovingStrategy()
    );
    @Override
    public IIterator getIterator() {
        return new MovingStrategyIterator();
    }
    private class MovingStrategyIterator implements IIterator{

        int index;
        @Override
        public boolean hasNext() {
            return index < movingStrategies.size();
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return movingStrategies.get(index++);
            }
            else {
                index = 0;
                return movingStrategies.get(index++);
            }
        }
    }
}
