package lld.cache;

abstract class Cache<A,B> {
    Store<A,B> store;
    EvictionPolicy<A> evictionPolicy;
    int capacity;
    void configure(Store<A, B> store, EvictionPolicy<A> evictionPolicy, int capacity) {
        this.store=store;
        this.evictionPolicy=evictionPolicy;
        this.capacity=capacity;
    }

    void put(A key, B value) {
        store.put(key,value);
    }

    B get(A key) {
        return store.get(key);
    }

    B delete(A key) {
        return store.delete(key);
    }
}
