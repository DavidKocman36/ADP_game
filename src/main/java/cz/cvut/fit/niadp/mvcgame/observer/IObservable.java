package cz.cvut.fit.niadp.mvcgame.observer;

import cz.cvut.fit.niadp.mvcgame.observer.aspects.Aspect;

public interface IObservable {
    void registerObserver(IObserver observer, Aspect interest);
    void unregisterObserver(IObserver observer);
    void notifyObservers(Aspect interest);

}
