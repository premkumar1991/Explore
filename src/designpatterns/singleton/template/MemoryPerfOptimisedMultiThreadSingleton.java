package designpatterns.singleton.template;

// this handle multithreading using extra static helper nested class
// which is available constant one time initialisation to all threads or invokers,
// so it handles multithreading without synchronisation
public class MemoryPerfOptimisedMultiThreadSingleton {
    private MemoryPerfOptimisedMultiThreadSingleton(){}
    private static class MemoryOptimisedMultiThreadSingletonHelper{
        private static final MemoryPerfOptimisedMultiThreadSingleton instance = new MemoryPerfOptimisedMultiThreadSingleton();
    }
    public static MemoryPerfOptimisedMultiThreadSingleton getInstance(){
        return MemoryOptimisedMultiThreadSingletonHelper.instance;
    }
}
