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
    public List<A> getEvictionKeys() {
        return List.of(map.get(0));
    }

    @Override
    public boolean containsKey(A key) {
        return map.containsKey(key);
    }

    @Override
    public void deleteAll(List<A> keys) {
        for(int i=0;i<keys.size();++i){
            map.remove(keys.get(i));
        }
    }

}
