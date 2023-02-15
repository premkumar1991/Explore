package lld.cache;

import java.util.List;

public interface EvictionPolicy<A> {
    void delete(A key);
    void update(A key);
    List<A> getEvictionKeys();
    boolean containsKey(A key);
    void deleteAll(List<A> keys);
}
