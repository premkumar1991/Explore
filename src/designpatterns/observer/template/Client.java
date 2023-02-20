package designpatterns.observer.template;

public class Client {
    public static void main(String[] a){
        Observer observer1 = new ObserverImpl("observer1");
        Observer observer2 = new ObserverImpl("observer2");
        Subject subject = new SubjectImpl();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.setState(new Object());
        subject.removeObserver(observer2);
        subject.setState(new Object());
    }
}
