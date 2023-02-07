package cache;

public interface EvictionPolicy<A> {
    void delete(A key);
    void update(A key);
    A getEvictionKey();
}
