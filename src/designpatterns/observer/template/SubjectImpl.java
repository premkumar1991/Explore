package designpatterns.observer.template;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubjectImpl implements Subject{
    private Object state;
    private Set<Observer> observers = new HashSet<>();
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer: observers){
            observer.update(state);
        }
    }

    @Override
    public void setState(Object o) {
        state = o;
        notifyObserver();
    }
}
