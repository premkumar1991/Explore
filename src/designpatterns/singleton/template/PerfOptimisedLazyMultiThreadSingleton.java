package designpatterns.singleton.template;

import java.io.Serializable;

public class PerfOptimisedLazyMultiThreadSingleton implements Cloneable, Serializable {
    private static PerfOptimisedLazyMultiThreadSingleton instance;

    private PerfOptimisedLazyMultiThreadSingleton(){}
    // this block level synchronisation will put lock until assigning new instance
    // next invocation after assignment will not need any local, not null condition prevents it entering
    // java 5 before has memory problem
    // MemoryOptimisedMultiThreadSingleton

    public static PerfOptimisedLazyMultiThreadSingleton getInstance() {
        if(instance==null){
            synchronized (PerfOptimisedLazyMultiThreadSingleton.class){
                if(instance==null)
                    instance=new PerfOptimisedLazyMultiThreadSingleton();
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    public Object readResolve(){
        return instance;
    }
}
