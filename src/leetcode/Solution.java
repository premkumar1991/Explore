package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canPartition(int[] nums) {
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        boolean res=helper(nums,0,0,0,map);
        System.out.println(map);
        return res;
    }
    public boolean helper(int[] nums,int idx,int size,int sum,Map<Integer,Map<Integer,Integer>> map){
        if(size!=0&&size!=nums.length){
            if(!map.containsKey(size))
                map.put(size,new HashMap<>());
            Map<Integer,Integer> m=map.get(size);
            m.put(sum,m.getOrDefault(sum,0)+1);
            int p2=nums.length-size;
            if(map.containsKey(p2)&&p2==size&&map.get(p2).getOrDefault(sum,0)>1)
                return true;
            if(p2!=size&&map.containsKey(p2)&&map.get(p2).containsKey(sum))
                return true;
        }
        for(int i=idx;i<nums.length;++i){
            sum+=nums[i];
            if(helper(nums,i+1,1+size,sum,map))
                return true;
            sum-=nums[i];
        }
        return false;
    }
}