package designpatterns.observer.template;

abstract class AbstractObserverImpl {
    String observerName;
    public AbstractObserverImpl(String observerName){
        this.observerName=observerName;
    }
}
