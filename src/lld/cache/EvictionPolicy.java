package lld.cache;

public interface EvictionPolicy<A> {
    void delete(A key);
    void update(A key);
    A getEvictionKey();
    boolean containsKey(A key);
}
