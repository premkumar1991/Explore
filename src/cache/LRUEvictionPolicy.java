package cache;

import java.util.LinkedList;
import java.util.List;

/**
 * Can have own policies like LRU,LFU,FIFO,LIFO,Random
 * Here LRU used
 * @param <A>
 * @param <B>
 */
public class LRUEvictionPolicy<A> implements EvictionPolicy<A>{
    List<A> list;
    public LRUEvictionPolicy(){
        list=new LinkedList<>();
    }

    @Override
    public void delete(A key) {
        list.remove(key);
    }

    @Override
    public void update(A key) {
        list.remove(key);
        list.add(key);
    }

    @Override
    public A getEvictionKey() {
        return this.list.get(0);
    }

}
