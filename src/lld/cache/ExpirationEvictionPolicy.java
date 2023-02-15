package lld.cache;

import java.util.*;

public class ExpirationEvictionPolicy<A>  implements EvictionPolicy<A>{
    HashMap<A,Long> map;
    long expiryTime;
    public ExpirationEvictionPolicy(long expiryTime){
        this.expiryTime=expiryTime;
        map=new LinkedHashMap<>();
    }

    @Override
    public void delete(A key) {
        map.remove(key);
    }

    @Override
    public void update(A key) {
        map.put(key,System.currentTimeMillis());
    }

    @Override
    public List<A> getEvictionKeys() {
        List<A> expiredNodes = new ArrayList<>();
        for(Map.Entry<A,Long> m:map.entrySet()){
            if(System.currentTimeMillis()-m.getValue()>=expiryTime)
                expiredNodes.add(m.getKey());
        }
        return expiredNodes;
    }

    @Override
    public boolean containsKey(A key) {
        return map.containsKey(key);
    }

    // good candidate for abstract class
    @Override
    public void deleteAll(List<A> keys) {
        for(int i=0;i<keys.size();++i){
            map.remove(keys.get(i));
        }
    }
}
