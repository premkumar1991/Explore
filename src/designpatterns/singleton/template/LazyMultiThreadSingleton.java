package designpatterns.singleton.template;

public class LazyMultiThreadSingleton {
    private static LazyMultiThreadSingleton instance;
    private LazyMultiThreadSingleton(){}
    // This is costly because of lock and wait on other threads
    // Even if one thread is assigned with new instance, other thread still has expensive waits
    // This can be solved with PerfOptimisedLazyMultiThreadSingleton
    public static synchronized LazyMultiThreadSingleton getInstance(){
        if(instance!=null)
            instance=new LazyMultiThreadSingleton();
        return instance;
    }
}
