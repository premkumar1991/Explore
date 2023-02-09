package lld.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Can have own policies like LRU,LFU,FIFO,LIFO,Random
 * Here LRU used
 * @param <A>
 * @param <B>
 */
public class LRUEvictionPolicy<A> implements EvictionPolicy<A>{
    HashMap<A,A> map;
    public LRUEvictionPolicy(){
        map=new LinkedHashMap<>();
    }

    @Override
    public void delete(A key) {
        map.remove(key);
    }

    @Override
    public void update(A key) {
        map.remove(key);
        map.put(key,key);
    }

    @Override
    public A getEvictionKey() {
        return map.get(0);
    }

    @Override
    public boolean containsKey(A key) {
        return map.containsKey(key);
    }

}
