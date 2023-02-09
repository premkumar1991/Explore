package lld.cache;

public class CacheImpl<A,B> implements Cache<A,B>{
    private Store<A,B> store;
    private EvictionPolicy<A> evictionPolicy;
    private int capacity;
    private int usedCapacity=0;
    @Override
    public void configure(Store<A, B> store, EvictionPolicy<A> evictionPolicy,int capacity) {
        this.store=store;
        this.evictionPolicy=evictionPolicy;
        this.capacity=capacity;
    }

    @Override
    public void put(A key, B value) {
        usedCapacity++;
        if(usedCapacity>capacity){
           evictionPolicy.delete(evictionPolicy.getEvictionKey());
           usedCapacity=capacity;
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
        if(store.containsKey(key)){
            usedCapacity--;
        }
        return store.delete(key);
    }
}
