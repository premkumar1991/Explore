package lld.cache;

public class CacheImpl<A, B> extends Cache<A, B> {
    public Store<A, B> store;
    public EvictionPolicy<A> evictionPolicy;
    public int capacity;
    public int usedCapacity = 0;

    @Override
    public void put(A key, B value) {
        usedCapacity++;
        if (usedCapacity > capacity) {
            A evictionKey = evictionPolicy.getEvictionKeys().get(0);
            evictionPolicy.delete(evictionKey);
            store.delete(evictionKey);
            usedCapacity = capacity;
        }
        evictionPolicy.update(key);
        store.put(key, value);
    }

    @Override
    public B get(A key) {
        evictionPolicy.update(key);
        return store.get(key);
    }

    @Override
    public B delete(A key) {
        if (store.containsKey(key)) {
            usedCapacity--;
        }
        evictionPolicy.delete(key);
        return store.delete(key);
    }
}
