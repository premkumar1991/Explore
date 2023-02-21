package designpatterns.singleton.template;

import java.io.Serializable;

// this handle multithreading using extra static helper nested class
// which is available constant one time initialisation to all threads or invokers,
// so it handles multithreading without synchronisation
public class MemoryPerfOptimisedMultiThreadSingleton implements Cloneable, Serializable {
    private MemoryPerfOptimisedMultiThreadSingleton(){}
    private static class MemoryOptimisedMultiThreadSingletonHelper{
        private static final MemoryPerfOptimisedMultiThreadSingleton instance = new MemoryPerfOptimisedMultiThreadSingleton();
    }
    public static MemoryPerfOptimisedMultiThreadSingleton getInstance(){
        return MemoryOptimisedMultiThreadSingletonHelper.instance;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    // to prevent the class serialize,deserialize to produce different copies
    // example write the class to file and reading it back
    public Object readResolve(){
        return MemoryOptimisedMultiThreadSingletonHelper.instance;
    }
}
