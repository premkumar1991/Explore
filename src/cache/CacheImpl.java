package cache;

public class CacheImpl<A,B> implements Cache<A,B>{
    private Store<A,B> store;
    private EvictionPolicy<A> evictionPolicy;
    private int capacity;
    @Override
    public void configure(Store<A, B> store, EvictionPolicy<A> evictionPolicy,int capacity) {
        this.store=store;
        this.evictionPolicy=evictionPolicy;
    }

    @Override
    public void put(A key, B value) {
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
        return store.delete(key);
    }
}
