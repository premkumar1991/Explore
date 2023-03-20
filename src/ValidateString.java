import java.util.*;

public class ValidateString {
    public static boolean isValidString(String s){
        int[] lowerCase = new int[26];
        for(char i:s.toCharArray()){
            lowerCase[i-'a']++;
        }
        HashMap<Integer, List<Integer>> freqGroupMap = new HashMap<>();
        for(int i=0;i<lowerCase.length;++i){
            if(lowerCase[i]>0){
                freqGroupMap.put(lowerCase[i], freqGroupMap.getOrDefault(lowerCase[i],new ArrayList<>()));
                freqGroupMap.get(lowerCase[i]).add(i);
            }
        }
        // 3 cases
        if(freqGroupMap.size()>2)
            return false;
        if(freqGroupMap.size()<=1)
            return true;
        int[] keys = new int[2];
        int idx=0;
        for(Map.Entry<Integer,List<Integer>> e: freqGroupMap.entrySet()){
            keys[idx++]=e.getKey();
        }
        // 2cases
        if(freqGroupMap.get(keys[0]).size()>=1 && freqGroupMap.get(keys[1]).size()==1 &&(keys[1]-1==keys[0] || keys[1]==1))
            return true;
        if(freqGroupMap.get(keys[1]).size()>=1 && freqGroupMap.get(keys[0]).size()==1 && (keys[0]-1==keys[1] || keys[0]==1))
            return true;
        return false;
    }
    public static void main(String[] args){
//        System.out.println(isValidString("ababc"));
//        System.out.println(isValidString("aabbbb"));
        System.out.println(isValidString("aabbb"));
        System.out.println(isValidString("aaabbbc"));
    }
}
