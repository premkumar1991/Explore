package lld.cache;

import java.util.HashMap;

/***
 * Can have own store like Hashmap,LinkedHashMap, TreeMap or any custom map
 * @param <A>
 * @param <B>
 */
public class HashMapStore<A,B> implements Store<A,B>{
    private HashMap<A,B> map;
    public HashMapStore(){
        map = new HashMap<>();
    }

    @Override
    public void put(A key, B value) {
        map.put(key,value);
    }

    @Override
    public B get(A key) {
        return map.get(key);
    }

    @Override
    public B delete(A key) {
        return map.remove(key);
    }

    @Override
    public boolean containsKey(A key) {
        return map.containsKey(key);
    }


}
