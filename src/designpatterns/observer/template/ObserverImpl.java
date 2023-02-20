package designpatterns.observer.template;

public class ObserverImpl extends AbstractObserverImpl implements Observer{

    public ObserverImpl(String observerName) {
        super(observerName);
    }

    @Override
    public void update(Object o) {
        System.out.println("invoking observer: "+ observerName + " with hashcode "+o.hashCode());
    }
}
