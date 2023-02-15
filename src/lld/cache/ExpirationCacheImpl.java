package lld.cache;

import java.util.List;

public class ExpirationCacheImpl<A,B> extends CacheImpl<A,B>{
    @Override
    public void put(A key, B value) {
        usedCapacity++;
        if (usedCapacity > capacity) {
            List<A> evictionKeys = evictionPolicy.getEvictionKeys();
            evictionPolicy.deleteAll(evictionKeys);
            store.deleteAll(evictionKeys);
            usedCapacity = capacity;
        }
        evictionPolicy.update(key);
        store.put(key, value);
    }
}
