package designpatterns.observer.template;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
    void setState(Object o);
}
