package lld.cache;

import java.util.List;

public interface Store<A,B> {
    void put(A key,B value);
    B get(A key);
    B delete(A key);
    boolean containsKey(A key);
    void deleteAll(List<A> keys);
}
