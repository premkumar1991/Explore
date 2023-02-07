import cache.*;

public class Main {

    public static void main(String[] args) {
        Cache<Integer,Integer> cache = new CacheImpl<>();
        HashMapStore<Integer,Integer> store = new HashMapStore<>();
        LRUEvictionPolicy<Integer> lruEvictionPolicy=new LRUEvictionPolicy<>();
        cache.configure(store,lruEvictionPolicy,100);
        cache.put(1,2);
        cache.put(2,3);
        System.out.println(cache.get(2));
        System.out.println(lruEvictionPolicy.getEvictionKey());
    }

}