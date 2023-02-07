package cache;

public interface Cache<A,B> {
    void configure(Store<A,B> store, EvictionPolicy<A> evictionPolicy,int capacity);
    void put(A key,B value);
    B get(A key);
    B delete(A key);
}
