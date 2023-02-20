package designpatterns.observer.template;

public class ObserverImpl2 extends AbstractObserverImpl implements Observer{
    public ObserverImpl2(String observerName) {
        super(observerName);
    }

    @Override
    public void update(Object o) {
        System.out.println("invoking observer: "+observerName + " with state "+o.toString());
    }
}
