package designpatterns.singleton.template;
public class EagerSingleton {
    // initialize eagerly even you not asked for
    private static EagerSingleton instance = new EagerSingleton();

    // lock the constructor access outside
    private EagerSingleton(){}
    public static EagerSingleton getInstance() {
        return instance;
    }
}
