package cache;

public interface Store<A,B> {
    void put(A key,B value);
    B get(A key);
    B delete(A key);
}
