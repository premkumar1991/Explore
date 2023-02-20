package leetcode.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem90 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(0,nums,new ArrayList<>());
        return res;
    }
    public void backTrack(int idx,int[] nums,List<Integer> acc){
        res.add(new ArrayList<>(acc));
        int lastEle=-11;
        for(int i=idx;i<nums.length;++i){
            if(nums[i]!=lastEle){
                acc.add(nums[i]);
                backTrack(i+1,nums,acc);
                acc.remove(acc.size()-1);
            }
            lastEle=nums[i];
        }
    }
}
