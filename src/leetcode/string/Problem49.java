package leetcode.string;

import java.util.*;

public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String sorted=new String(c);
            map.put(sorted,map.getOrDefault(sorted,new LinkedList<>()));
            map.get(sorted).add(s);
        }
        List<List<String>> res=new LinkedList<>();
        for(Map.Entry<String,List<String>> e:map.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }
}
